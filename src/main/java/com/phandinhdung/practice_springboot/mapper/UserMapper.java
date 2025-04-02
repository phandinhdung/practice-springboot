package com.phandinhdung.practice_springboot.mapper;

import com.phandinhdung.practice_springboot.dto.request.UserCreationRequest;
import com.phandinhdung.practice_springboot.dto.request.UserUpdateRequest;
import com.phandinhdung.practice_springboot.dto.response.UserResponse;
import com.phandinhdung.practice_springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
