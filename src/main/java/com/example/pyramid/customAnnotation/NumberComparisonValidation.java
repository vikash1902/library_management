package com.example.pyramid.customAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class NumberComparisonValidation implements ConstraintValidator<NumberComparison, Object> {

    private String firstNumber;
    private String secondNumber;

    @Override
    public void initialize(NumberComparison constraintAnnotation) {
        this.firstNumber = constraintAnnotation.firstNumber();
        this.secondNumber = constraintAnnotation.secondNumber();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        try {
            Field firstNo = value.getClass().getDeclaredField(firstNumber);
            firstNo.setAccessible(true);
            Field secondNo = value.getClass().getDeclaredField(secondNumber);
            secondNo.setAccessible(true);

            int first = (int) firstNo.get(value);
            int second = (int) secondNo.get(value);

            if (first >= second) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
