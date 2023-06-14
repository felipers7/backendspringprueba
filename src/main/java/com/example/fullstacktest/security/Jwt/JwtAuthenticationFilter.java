package com.example.fullstacktest.security.Jwt;

import com.example.fullstacktest.security.CustomUserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        //Se extrae los datos enviados por JSON desde el cliente
        AuthCredentials authCredentials = new AuthCredentials();
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }
        catch (IOException e){
        }
        //Se crea una nueva clase para adaptarla a la librería JWT
        UsernamePasswordAuthenticationToken usernamePat = new UsernamePasswordAuthenticationToken(
                authCredentials.getUsername(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );

        //Verificación
        return  getAuthenticationManager().authenticate(usernamePat);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        // SE hace llamado a user details
        CustomUserDetails userDetails = (CustomUserDetails) authResult.getPrincipal();
        //Hace llamado de construcción del token
        String token = TokenUtils.createToken(userDetails.getUsername(), userDetails.getAuthorities());

        //Se preparan el header de HTTP para poder cargar el TOken
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
                "{\"" + "Authorization" + "\":\"" + "Bearer "+ token + "\"}"
        );
        response.getWriter().flush();
        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        //En caso de que falle la autenticación saldrá en consola
        System.out.println("UNSUCCESSFULL");
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
