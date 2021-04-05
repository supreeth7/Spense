package com.supreeth.spense.filters;

import com.supreeth.spense.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String auth_header = httpServletRequest.getHeader("Authorization");
        if (auth_header != null) {
            String[] auth_header_arr = auth_header.split("Bearer");
            if (auth_header_arr.length > 1 && auth_header_arr[1] != null) {
                String token = auth_header_arr[1];

                try {
                    Claims claim = Jwts.parser().setSigningKey(Constants.SECRET_KEY)
                            .parseClaimsJws(token).getBody();
                    httpServletRequest.setAttribute("user_id", Integer.parseInt(claim.get("user_id").toString()));
                } catch (Exception e) {
                    httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "invalid or expired token");
                    return;
                }
            } else {
                httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "invalid or expired bearer in token");
                return;
            }
        } else {
            httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "Missing authorization token");
            return;
        }
        chain.doFilter(request, response);
    }
}
