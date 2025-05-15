package com.phandinhdung.practice_springboot.service;

import com.phandinhdung.practice_springboot.dto.request.UserCreationRequest;
import com.phandinhdung.practice_springboot.dto.request.UserUpdateRequest;
import com.phandinhdung.practice_springboot.dto.response.UserResponse;
import com.phandinhdung.practice_springboot.entity.User;
import com.phandinhdung.practice_springboot.mapper.UserMapper;
import com.phandinhdung.practice_springboot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(request.getPassword());
        user.setDateOfBirth(request.getDateOfBirth());


        user = userRepository.save(user);
        UserResponse userResponse = userMapper.toUserResponse(user);
        userResponse.setDateOfBirth(user.getDateOfBirth());

        return userResponse;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    public UserResponse getUserInfo(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(userMapper::toUserResponse).orElse(null);
    }

    public UserResponse getUser(String email) {
        User user = userRepository.findByEmail(email);
        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(UserUpdateRequest request) throws Exception {
        if(userRepository.existsById(request.getId())) {
            User user = new User();
            userMapper.updateUser(user, request);

            return userMapper.toUserResponse(userRepository.save(user));
        }

        throw new Exception("User không tồn tại");
    }

    public String deleteUser(String userId) throws Exception {
        if(userRepository.existsById(userId)) {
            userRepository.deleteById(userId);

            return "Xóa user thành công!";
        } else
            throw new Exception("User không tồn tại");
    }
}
