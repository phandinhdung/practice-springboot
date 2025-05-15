package com.phandinhdung.practice_springboot.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import com.phandinhdung.practice_springboot.validate.Adult;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(unique = true, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    String email;

    LocalDate dateOfBirth;
    String password;
    String firstName;
    String lastName;
}

