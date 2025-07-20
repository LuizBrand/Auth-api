package com.LuizBrand.AuthRoles.services;

import com.LuizBrand.AuthRoles.config.JwtService;
import com.LuizBrand.AuthRoles.dto.request.UserRequest;
import com.LuizBrand.AuthRoles.dto.response.LoginResponse;
import com.LuizBrand.AuthRoles.dto.response.UserResponse;
import com.LuizBrand.AuthRoles.entity.Role;
import com.LuizBrand.AuthRoles.entity.User;
import com.LuizBrand.AuthRoles.mapper.UserMapper;
import com.LuizBrand.AuthRoles.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder encoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public UserResponse registerUser(UserRequest request) {
        User user = UserMapper.toUser(request);
        user.setPassword(encoder.encode(request.password()));
        Role userRole = Role.builder()
                .id(2L)
                .build();

        user.setRoles(Set.of(userRole));
        userRepository.save(user);

        return UserMapper.toUserResponse(user);
    }

    public LoginResponse login(UserRequest request) {
        UsernamePasswordAuthenticationToken userAndPass =
                new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();
        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }


}
