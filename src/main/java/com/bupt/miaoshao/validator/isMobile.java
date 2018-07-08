package com.bupt.miaoshao.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {mobileValidator.class}
)
public @interface isMobile {

    boolean required() default false;

    String message() default "mobile is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
