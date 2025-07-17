package com.LuizBrand.AuthRoles.dto.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String username) {
}
