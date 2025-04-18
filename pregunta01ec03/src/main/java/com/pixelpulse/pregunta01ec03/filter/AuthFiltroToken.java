package com.pixelpulse.pregunta01ec03.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pixelpulse.pregunta01ec03.security.service.MiUserDetailsService;
import com.pixelpulse.pregunta01ec03.security.utils.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthFiltroToken extends OncePerRequestFilter{
    @Autowired
    private MiUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    /* ~ Metodos
    ==================================== */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        final String headerAuth = request.getHeader("Authorization");
        String token = null;
        String username = null;
        
        if(headerAuth != null && headerAuth.startsWith("Bearer ")){
            // Lo extraemos quitando el "Bearer " para solo tener el token
            token = headerAuth.substring(7);
            // Buscamos el username del usuario en el token
            username = jwtUtil.extraerUsername(token);
        }

        // Validamos los valores extraidos del token y el contexto de seguridad
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            // obtenemos el nombre del usuario de nuestra BD y poblamos el UserDetails
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Validamos el token si aun esta vigente y si concuerda con el usuario de la BD
            if (jwtUtil.validarToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken userPassAuthToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Generamos los detalles de la autenticacion por token
                userPassAuthToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // y establecemos el tipo de seguridad
                SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);
            } // fin de la validacion del token con los datos de la BD
        }

        filterChain.doFilter(request, response);
    }
}
