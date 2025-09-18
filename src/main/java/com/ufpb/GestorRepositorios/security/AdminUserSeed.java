package com.ufpb.GestorRepositorios.security;

import com.ufpb.GestorRepositorios.models.User;
import com.ufpb.GestorRepositorios.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserSeed implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminUserSeed(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsername("admin")) {
            User adminUser = new User();
            adminUser.setNome("Administrador");
            adminUser.setUsername("admin");
            adminUser.setEmail("admin@email.com");
            adminUser.setPassword(bCryptPasswordEncoder.encode("admin"));
            userRepository.save(adminUser);
        }
    }

}
