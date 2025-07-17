package com.LuizBrand.AuthRoles.mapper;

import com.LuizBrand.AuthRoles.dto.response.UserResponse;
import com.LuizBrand.AuthRoles.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserResponse userResponse) {
        return User.builder()
                .id(userResponse.id())
                .username(userResponse.username())
                .build();

    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();

    }

}
