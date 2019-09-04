package com.kkh.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator
        implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        this.coursePrefix = constraintAnnotation.value(); // annotation value
    }

    @Override
    public boolean isValid(String theCode,
                           ConstraintValidatorContext constraintValidatorContext) { // can place additional error messages

        if (theCode != null) {
            return theCode.startsWith(this.coursePrefix);
        }

        return true;
    }
}
