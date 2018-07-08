package com.bupt.miaoshao.validator;

import com.bupt.miaoshao.util.ValidatorUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class mobileValidator implements ConstraintValidator<isMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(isMobile constraintAnnotation) {

        this.required = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(StringUtils.isEmpty(s))
            return required;

        return ValidatorUtils.isMoblie(s);

    }
}
