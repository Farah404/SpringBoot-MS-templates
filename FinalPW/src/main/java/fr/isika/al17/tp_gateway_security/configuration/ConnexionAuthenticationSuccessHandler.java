package fr.isika.al17.tp_gateway_security.configuration;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ConnexionAuthenticationSuccessHandler implements AuthenticationSuccessHandler{


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	   Authentication authentication) throws IOException, ServletException {
	 response.setStatus(HttpServletResponse.SC_OK);
	 
	 for (GrantedAuthority auth : authentication.getAuthorities()) {
	            if ("ADMIN".equals(auth.getAuthority())) {
	                response.sendRedirect("/afficher");
	            }
	 }
	
    }
}
