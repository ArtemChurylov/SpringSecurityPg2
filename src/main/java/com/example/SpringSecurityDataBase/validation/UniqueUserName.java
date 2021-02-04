package com.example.SpringSecurityDataBase.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserNameValidation.class)
public @interface UniqueUserName {
    String message() default "This name already taken";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
