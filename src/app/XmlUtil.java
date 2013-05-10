package app;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import app.web.model.ImageInfo;

public class XmlUtil {

	public List<ImageInfo> parseXML() throws Exception {
		List<ImageInfo> imageList = new ArrayList<>();

		XPathFactory factory = XPathFactory.newInstance();
		XPath xPath = factory.newXPath();

		NodeList employees = (NodeList) xPath
				.evaluate(
						"/root/employee",
						new InputSource(
								new FileReader(
										"/home/andrey/workspace/juno/spring/mvc/SpringSecurity2/WebContent/resources/photo/image_db.xml")),
						XPathConstants.NODESET);
		for (int i = 0; i < employees.getLength(); i++) {
			Element employee = (Element) employees.item(i);

			Element info = (Element) employee.getElementsByTagName("info")
					.item(0);

			Node message = employee.getElementsByTagName("message").item(0);

			ImageInfo imageInfo = new ImageInfo();
			imageInfo.setID(Integer.parseInt(employee.getAttribute("id")));
			imageInfo.setFirst_name(employee.getAttribute("first_name"));
			imageInfo.setMiddle_name(employee.getAttribute("middle_name"));
			imageInfo.setSecond_name(employee.getAttribute("second_name"));
			imageInfo.setAdministration(info.getAttribute("administration"));
			imageInfo.setSubject(info.getAttribute("subject"));
			imageInfo.setEducation(info.getAttribute("education"));
			imageInfo.setCategory(info.getAttribute("category"));
			imageInfo.setSpecialization(info.getAttribute("specialization"));
			imageInfo.setMessage(message.getTextContent());
			imageInfo.setUrl(imageInfo.getUrl() + imageInfo.getID() + ".jpg");
		
			imageList.add(imageInfo);

		}
		return imageList;
	}

}