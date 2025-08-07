package com.udea.petCare.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class TokenUtils {

    public static Long getIdUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getPrincipal() == null) {
            return null;
        }

        try {
            // Recordemos que el `id` es el "subject" del token, y lo guardamos como String
            String idStr = (String) authentication.getPrincipal();
            return Long.parseLong(idStr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getRolUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getAuthorities() == null) {
            return null;
        }
        return authentication.getAuthorities().stream()
                .findFirst()
                .map(auth -> auth.getAuthority().replace("ROLE_", ""))
                .orElse(null);
    }
}
