package com.decsef.pixserver.auth;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import static com.decsef.pixserver.security.AppUserRole.USER;

@RequiredArgsConstructor
@Repository("fake")
public class FakeApplicationDaoService implements ApplicatioUserDAO {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByName(String username) {
        return getApplicationUsers()
                .stream().filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        "israel",
                        passwordEncoder.encode("12345"),
                        USER.getGrantedAuthorities()),
                new ApplicationUser(
                        "monserrat",
                        passwordEncoder.encode("12345"),
                        USER.getGrantedAuthorities()),
                new ApplicationUser(
                        "tom",
                        passwordEncoder.encode("12345"),
                        USER.getGrantedAuthorities())
        );
    }

}
