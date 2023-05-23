package service;

import com.springboot.teammates.model.User;
import com.springboot.teammates.repository.UserRepository;
import com.springboot.teammates.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("firstName");
        user.setGithubProfile("profile");

        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> users = userService.getAllUsers();

        assertEquals(1, users.size());
        assertEquals(users.get(0).getFirstName(), "firstName");
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFirstName("Anand Bhat");
        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertEquals("Anand Bhat", createdUser.getFirstName());
    }

    @Test
    public void testUpdateUser() {
        User userToUpdate = new User();
        userToUpdate.setId(1L);
        userToUpdate.setFirstName("fistName");

        User newUser = new User();
        newUser.setFirstName("updatedName");

        when(userRepository.findById(1L)).thenReturn(Optional.of(userToUpdate));
        when(userRepository.save(userToUpdate)).thenReturn(userToUpdate);

        User updatedUser = userService.updateUser(1L, newUser);

        assertEquals("updatedName", updatedUser.getFirstName());
    }
}
