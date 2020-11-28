package core.entities;

import core.model.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class AuthFilter implements Filter {

  @Autowired
  protected SessionData sessionData;

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    sessionData.setInteractions(sessionData.getInteractions() + 1);
    filterChain.doFilter(servletRequest, servletResponse);
  }
}


