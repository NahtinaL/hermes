package com.learning.hermes.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("filter!");
        //TODO: implement
        /**
         * 1. Валідація JWT токена
         * 2. У випадку успіху створюємо об'єкт Аутентифікації
         * 3. У випадку неуспіху повертаємо 403
         */
        SecurityContextHolder.getContext().setAuthentication(
                new PreAuthenticatedAuthenticationToken("phone", null, List.of(
                        new SimpleGrantedAuthority("ROLE_" + "USER")
                ))
        );
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
