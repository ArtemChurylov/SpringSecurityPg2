package com.example.SpringSecurityDataBase.validation;

import com.example.SpringSecurityDataBase.auth.CrmUser;
import com.example.SpringSecurityDataBase.models.ApplicationUser;
import com.example.SpringSecurityDataBase.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueUserNameValidation implements ConstraintValidator<UniqueUserName, CrmUser> {

    @Autowired
    private final UserRepository userRepository;

    public UniqueUserNameValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UniqueUserName constraintAnnotation) {

    }

    @Override
    public boolean isValid(CrmUser applicationUser, ConstraintValidatorContext context) {

        boolean isValid = true;

        if (applicationUser.getUsername() != null && applicationUser.getUsername().length() > 2) {

            List<ApplicationUser> users = userRepository.findAll();
            isValid = users.stream().noneMatch(user -> user.getUsername().equals(applicationUser.getUsername()));
        }

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("username").addConstraintViolation();
        }

        return isValid;
    }
}
