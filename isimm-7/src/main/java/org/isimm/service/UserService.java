package org.isimm.service;

import java.util.Collections;

import org.isimm.dao.AccountRepository;
import org.isimm.dao.RoleRepository;
import org.isimm.entities.Account;
import org.isimm.entities.Role;
import org.isimm.entities.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(account.getUsername(), account.getPassword(), Collections.emptyList());
    }

    public void registerUser(Long CIN, String username, String password) {
    	if (accountRepository.findByUsername(username) != null) {
            throw new RuntimeException("Username already exists");
        }
        Account account = new Account();
        account.setCIN(CIN);
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        accountRepository.save(account);

        Role role = new Role();
        role.setCIN(CIN);
        role.setUsername(username);
        if (username.equals("admin")) {
            role.setUserRole(UserRole.ROLE_ADMIN);
        } else {
            role.setUserRole(UserRole.ROLE_STUDENT);
        }
        roleRepository.save(role);
    }
}
