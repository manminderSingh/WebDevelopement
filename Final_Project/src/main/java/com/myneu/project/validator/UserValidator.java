package com.myneu.project.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myneu.project.pojo.Users;
public class UserValidator implements Validator {
    public boolean supports(Class aClass)
    {
        return aClass.equals(Users.class);
    }
    public void validate(Object obj, Errors errors)
    {
    	Users newUser = (Users) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
    }
}