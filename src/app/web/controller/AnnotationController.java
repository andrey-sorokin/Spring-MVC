package app.web.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import app.XmlUtil;
import app.mail.SendMailTLS;
import app.web.model.Customer;
import app.web.model.ImageInfo;
import app.web.validator.CustomerValidator;

@Controller
public class AnnotationController {
	static Logger log = Logger.getLogger(AnnotationController.class.getName());

	CustomerValidator customerValidator;

	@Autowired
	public AnnotationController(CustomerValidator customerValidator) {
		this.customerValidator = customerValidator;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		log.info("Request is processed at /login path");
		return "login";

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		log.info("Request is processed at /loginfailed path");
		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap model, Principal principal) {
		log.info("Request is processed at /admin path");

		try {
			String name = principal.getName();
			model.addAttribute("username", name);
		} catch (Exception e) {
			log.error(e);
		}
		return "admin";

	}

	@RequestMapping({ "/", "/welcome" })
	public String welcome() {
		log.info("Request is processed at /welcome path");

		return "welcome";
	}

	@RequestMapping("/link1")
	public String link1() {
		log.info("Request is processed at /link1 path");

		return "link1";
	}

	@RequestMapping("/link2")
	public String link2() {
		log.info("Request is processed at /link2 path");

		return "link2";
	}

	@RequestMapping("/link3")
	public String link3() {
		log.info("Request is processed at /link3 path");

		return "link3";
	}

	@RequestMapping(value = "/feed_back", method = RequestMethod.POST)
	public String feedBackSubmit(@ModelAttribute("customer") Customer customer,
			BindingResult result, SessionStatus status, Model model,
			RedirectAttributes redirectAttributes,
			final HttpServletResponse response) {

		customerValidator.validate(customer, result);

		String category = customer.getCategory();

		switch (category) {
		case "kindergarten":
			category = categoryResolver("kindergarten");
			break;

		case "elementary":
			category = categoryResolver("elementary");
			break;

		case "middle":
			category = categoryResolver("middle");
			break;

		case "high":
			category = categoryResolver("high");
			break;

		case "visitor":
			category = categoryResolver("visitor");
			break;

		default:
			category = "Вне категории";
			break;
		}

		redirectAttributes.addFlashAttribute("customer", customer);
		redirectAttributes.addFlashAttribute("category", category);

		response.setHeader("Cache-Control", "no-cache");

		String body = "\n Имя: " + customer.getName() + "\n Фамилия: "
				+ customer.getSurName() + "\n Email: " + customer.getEmail()
				+ "\n Категория: " + categoryResolver(customer.getCategory())
				+ "\n\n Сообщение: " + customer.getMessage();

		int messageID = new Random(System.currentTimeMillis()).nextInt(10000 - 100) + 100;
		
		SendMailTLS.sendEmail("Уведомление о сообщении № " + messageID, body);

		if (result.hasErrors()) {
			// if validator failed
			return "feed_back";
		} else {
			status.setComplete();
			// form success
			return "redirect:feed_back_success";
		}
	}

	@RequestMapping(value = "/feed_back_success", method = RequestMethod.GET)
	public String feedBackSuccess(ModelMap model, HttpServletRequest request) {
		log.info("Request is processed at /feed_back_success path");
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);

		if (map != null)

			return "feed_back_success";

		else
			return "redirect:welcome";

	}

	@RequestMapping(value = "/feed_back", method = RequestMethod.GET)
	public String feedBack(ModelMap model) {
		log.info("Request is processed at /feed_back path");

		Customer cust = new Customer();

		// command object
		model.addAttribute("customer", cust);

		return "feed_back";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));

	}

	@ModelAttribute("categoryList")
	public Map<String, String> populateCategoryList() {

		// Data referencing for java skills list box
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("kindergarten", categoryResolver("kindergarten"));
		country.put("elementary", categoryResolver("elementary"));
		country.put("middle", categoryResolver("middle"));
		country.put("high", categoryResolver("high"));
		country.put("visitor", categoryResolver("visitor"));

		return country;
	}

	@ModelAttribute("imageList")
	public List<ImageInfo> populateImageList() throws Exception {
		
		XmlUtil xmlUtil = new XmlUtil();
		return xmlUtil.parseXML();
	}
	
	private String categoryResolver(String keyword) {
		HashMap<String, String> category = new HashMap<>();
		category.put("kindergarten", "Будующий первоклассник");
		category.put("elementary", "Младшая школа");
		category.put("middle", "Средняя школа");
		category.put("high", "Выпускник");
		category.put("visitor", "Посетитель");

		return category.get(keyword);
	}

	@RequestMapping("/dummy")
	public String dummy() {
		log.info("Request is processed at /dummy path");

		return "dummy";
	}
}
