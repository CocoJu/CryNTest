package ru.cj.filters;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ANK on 29.06.2015.
 */
public class AuthorizationFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}