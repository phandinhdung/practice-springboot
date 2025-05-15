package com.phandinhdung.practice_springboot.controller;

import com.phandinhdung.practice_springboot.dto.request.UserCreationRequest;
import com.phandinhdung.practice_springboot.dto.request.UserUpdateRequest;
import com.phandinhdung.practice_springboot.dto.response.UserResponse;
import com.phandinhdung.practice_springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @GetMapping("/test")
    ResponseEntity<String> test() {
        return ResponseEntity.ok("test thanh cong");
    }

    @PostMapping("/create-user")
    ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreationRequest request) {
        UserResponse userResponse = userService.createUser(request);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/get-all-users")
    ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable(value = "id") String userId) {
        return ResponseEntity.ok(userService.getUserInfo(userId));
    }

    @PutMapping("/update-user")
    ResponseEntity<UserResponse> updateUser(@RequestBody UserUpdateRequest request) throws Exception {
        UserResponse userResponse = userService.updateUser(request);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") String userId) throws Exception {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }
}
