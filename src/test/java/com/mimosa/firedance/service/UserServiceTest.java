package com.mimosa.firedance.service;

import com.mimosa.firedance.model.User;
import com.mimosa.firedance.repository.RoleRepository;
import com.mimosa.firedance.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private RoleRepository mockRoleRepository;

    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @BeforeEach
    public void setUp() {
        initMocks(this);

        userServiceUnderTest = new UserService(mockUserRepository, mockRoleRepository, mockBCryptPasswordEncoder);
        user = User.builder().id(1).name("Allen").lastName("Walker").email("warriorsfly@gmail.com").build();
        Mockito.when(mockUserRepository.save(any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail((anyString()))).thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {
        final String email = "warriorsfly@gmail.com";
        final User result = userServiceUnderTest.findByEmail(email);

        assertEquals(email, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        final String email = "warriorsfly@gmail.com";

        User result = userServiceUnderTest.saveUser(User.builder().build());

        // Verify the results
        assertEquals(email, result.getEmail());
    }

}