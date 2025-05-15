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
public class UserCreationRequest {
    String id;
    String email;

    @Adult(message = "Độ tuổi phải lớn hơn 18")
    LocalDate dateOfBirth;

    String password;
    String firstName;
    String lastName;
}