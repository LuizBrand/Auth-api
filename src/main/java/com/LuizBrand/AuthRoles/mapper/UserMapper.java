package com.LuizBrand.AuthRoles.mapper;

import com.LuizBrand.AuthRoles.dto.request.UserRequest;
import com.LuizBrand.AuthRoles.dto.response.UserResponse;
import com.LuizBrand.AuthRoles.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest) {
        return User.builder()
                .username(userRequest.username())
                .password(userRequest.password())
                .build();

    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();

    }

}
