package com.decsef.pixserver.security;

import lombok.Getter;

@Getter
public enum AppUserPermission {
    USER_READ("user:read");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }
}
