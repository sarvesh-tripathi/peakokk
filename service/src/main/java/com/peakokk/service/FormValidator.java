package com.peakokk.service;

import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.peakokk.DTO.UserDTO;

@Component("FormValidator")
public class FormValidator implements Validator, IFormValidator
{
    private static Logger logger = LogManager.getLogger(FormValidator.class);

    /*
     * private final static Pattern EMAIL_PATTERN = Pattern
     * .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
     * + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
     */

    private final static Pattern EMAIL_PATTERN = Pattern
            .compile("^([_A-Za-z0-9-\\+]*[a-zA-Z]+[_A-Za-z0-9-\\+]*)(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private final static Pattern NAME_PATTERN = Pattern
            .compile("[A-Za-z]+");
    /*private final static Pattern PASSWORD_PATTERN = Pattern
            .compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");*/
    
    private final static Pattern PASSWORD_PATTERN = Pattern
            .compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");

    @Override
    public boolean supports(Class clazz)
    {
        // just validate the UserFormBean instances
        // If we want to use multiple classes using the below lines
        // return UserFormBean.class.equals(clazz) ||
        // Another.class.equals(clazz);
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        logger.debug("Inside Validate method");
    }

    private boolean isEmail(String value)
    {
        return EMAIL_PATTERN.matcher(value).matches();
    }

    private boolean isValidName(String value)
    {
        return NAME_PATTERN.matcher(value).matches();
    }

    private boolean isValidPassword(String value)
    {
        //return PASSWORD_PATTERN.matcher(value).matches();
        int passwordLength = value.length();
        if(passwordLength >= 6) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void signUpvalidate(Object target, Errors errors)
    {
        logger.debug("signUpvalidate method called");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
                "error.firstname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
                "error.lastName.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
                "error.email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "error.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
                "error.confirmPassword.empty");

        UserDTO user = (UserDTO) target;

        if (user.getFirstName() != null && !user.getFirstName().isEmpty())
        {
            if (!isValidName(user.getFirstName()))
            {
                errors.rejectValue("firstName", "error.name.only.character.allowed");
            }
        }
        if (user.getLastName() != null && !user.getLastName().isEmpty())
        {
            if (!isValidName(user.getLastName()))
            {
                errors.rejectValue("lastName", "error.name.only.character.allowed");
            }

        }

        if (!user.isTermsCheckbox())
        {
            errors.rejectValue("termsCheckbox", "error.termscheckbox.notselected");
        }
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        if (password != null && !password.isEmpty() )
        {
            if (!isValidPassword(password))
            {
                errors.rejectValue("password", "error.password.invalid");
            }
        }
        if (confirmPassword != null && !confirmPassword.isEmpty())
        { 

            if (!(password.equals(confirmPassword)))
            {
                logger.debug("Inside not matches");
                errors.rejectValue("confirmPassword", "notmatch.password");
            }
        }

        
        String emailId = user.getEmailId();
        /*
         * if (emailId == null || emailId.isEmpty() || emailId.trim().isEmpty())
         * {
         * errors.rejectValue("emailId", "error.email.empty");
         * }
         */
        if (emailId != null && !emailId.isEmpty() && !isEmail(emailId))
        {
            errors.rejectValue("emailId", "error.email.invalid");
        }
        else if (user.isEmailRegister())
        {
            logger.debug("inside email alreadyRegister::");
            errors.rejectValue("emailId", "error.email.alreadyRegister");
        }

        /*
         * String age = user.getAge();
         * if(age != null && !age.isEmpty())
         * {
         * int userAge = 0;
         * try
         * {
         * userAge = Integer.parseInt(age);
         * if(userAge < 13)
         * {
         * errors.rejectValue("age", "error.age.minimum");
         * }
         * }
         * catch(Exception e)
         * {
         * errors.rejectValue("age", "error.age.notnumeric");
         * }
         * 
         * }
         */

    }

}