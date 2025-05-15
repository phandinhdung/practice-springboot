package com.phandinhdung.practice_springboot.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AdultValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Adult {

    String message() default "Độ tuổi không hợp lệ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minAge() default 18; // Tuổi tối thiểu
}

