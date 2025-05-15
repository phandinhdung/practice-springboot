package com.phandinhdung.practice_springboot.dto.response;

import com.phandinhdung.practice_springboot.validate.Adult;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    LocalDate dateOfBirth;
    String email;
    String firstName;
    String lastName;
}

