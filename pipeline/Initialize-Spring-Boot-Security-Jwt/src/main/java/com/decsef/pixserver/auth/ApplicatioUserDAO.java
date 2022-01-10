package com.decsef.pixserver.auth;

import java.util.Optional;

public interface ApplicatioUserDAO {

    Optional<ApplicationUser> selectApplicationUserByName(String name);

}
