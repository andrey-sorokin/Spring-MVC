package app.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import app.web.model.Customer;


public class CustomerValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Customer.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.name", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surName",
				"required.surName", "Field Surname is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Field Email is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message",
				"required.message", "Field Message is required.");
	}
	
}