package org.home.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Experimental version of expire session handler
 */
@WebFilter(urlPatterns = {"/controller/*"})
public class SessionTimeoutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (session != null) {
            filterChain.doFilter(request, response);
        } else {
            String contextPath = request.getServletContext().getContextPath();
            response.sendRedirect(contextPath + "/jsp/index.jsp");
        }

    }

    @Override
    public void destroy() {
    }
}
