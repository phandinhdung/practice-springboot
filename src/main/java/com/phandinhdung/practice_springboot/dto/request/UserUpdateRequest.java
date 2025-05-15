package com.phandinhdung.practice_springboot.dto.request;

//import jakarta.validation.constraints.Size;
import com.phandinhdung.practice_springboot.validate.Adult;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String id;

    @Adult(minAge = 18)
    LocalDate dateOfBirth;

    String email;
    String password;
    String firstName;
    String lastName;
}