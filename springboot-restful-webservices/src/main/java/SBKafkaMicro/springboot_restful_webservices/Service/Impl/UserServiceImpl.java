package SBKafkaMicro.springboot_restful_webservices.Service.Impl;

import SBKafkaMicro.springboot_restful_webservices.Entity.User;
import SBKafkaMicro.springboot_restful_webservices.Service.UserService;
import SBKafkaMicro.springboot_restful_webservices.dto.UserDto;
import SBKafkaMicro.springboot_restful_webservices.exception.EmailAlreadyExistsException;
import SBKafkaMicro.springboot_restful_webservices.exception.ResourceNotFoundException;
import SBKafkaMicro.springboot_restful_webservices.mapper.UserMapper;
import lombok.AllArgsConstructor;
import SBKafkaMicro.springboot_restful_webservices.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Convert UserDto into User JPA Entity
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());

        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email is already exist for the user");
        }

        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());
        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(()-> new ResourceNotFoundException("User", "id", user.getId()));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {

        userRepository.deleteById(userId);
    }
}
