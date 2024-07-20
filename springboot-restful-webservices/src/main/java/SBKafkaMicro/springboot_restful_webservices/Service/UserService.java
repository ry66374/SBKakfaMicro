package SBKafkaMicro.springboot_restful_webservices.Service;

import SBKafkaMicro.springboot_restful_webservices.Entity.User;
import SBKafkaMicro.springboot_restful_webservices.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}