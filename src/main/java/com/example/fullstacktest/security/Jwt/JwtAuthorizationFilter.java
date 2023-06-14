package com.example.fullstacktest.security.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        //Se retira el token de los headers http
        String bearerToken = request.getHeader("Authorization");
        //Checkea las credenciales
        if(bearerToken != null && bearerToken.startsWith("Bearer")){
            String token = bearerToken.replace("Bearer ", "");
            UsernamePasswordAuthenticationToken userPat = TokenUtils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(userPat);
        }
        filterChain.doFilter(request,response);
    }
}
