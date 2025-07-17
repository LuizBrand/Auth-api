package com.LuizBrand.AuthRoles.services;

import com.LuizBrand.AuthRoles.dto.response.UserResponse;
import com.LuizBrand.AuthRoles.entity.User;
import com.LuizBrand.AuthRoles.mapper.UserMapper;
import com.LuizBrand.AuthRoles.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toUserResponse)
                .toList();
    }

    public Optional<UserResponse> findById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toUserResponse);

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
