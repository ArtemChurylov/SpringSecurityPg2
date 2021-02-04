package com.example.SpringSecurityDataBase.validation;

import com.example.SpringSecurityDataBase.auth.CrmUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidation implements ConstraintValidator<ConfirmPassword, CrmUser> {

    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(CrmUser applicationUser, ConstraintValidatorContext context) {

        boolean isValid = true;

        if (applicationUser.getPassword() != null && applicationUser.getPassword().length() > 5
                && applicationUser.getConfirmPassword() != null && applicationUser.getConfirmPassword().length() > 5) {

            isValid = applicationUser.getPassword().equals(applicationUser.getConfirmPassword());
        }

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("confirmPassword").addConstraintViolation();
        }

        return isValid;
    }
}
