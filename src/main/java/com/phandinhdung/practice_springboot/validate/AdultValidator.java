package com.phandinhdung.practice_springboot.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {

    private int minAge;

    @Override
    public void initialize(Adult constraintAnnotation) {
        this.minAge = constraintAnnotation.minAge();
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
        if (dateOfBirth == null) {
            return true; // Để @NotNull xử lý riêng nếu cần
        }

        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= minAge;
    }
}

