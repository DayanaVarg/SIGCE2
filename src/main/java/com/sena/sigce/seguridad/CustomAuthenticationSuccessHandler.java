package com.sena.sigce.seguridad;

import com.sena.sigce.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        String url = "";

        System.out.println("Objeto Authentication: " + authentication);
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        System.out.println("Roles del usuario: " + roles);

        if (roles.contains("ROLE_INSTRUCTOR")) {
            url = "/Instructor/menuInstructor";
        } else if (roles.contains("ROLE_FUNCIONARIO")) {
            url = "/Funcionario/menuFuncionario";
        } else if (roles.contains("ROLE_APRENDIZ")) {
            url = "/Aprendiz/menuAprendiz";
        }

        return url;
    }
}