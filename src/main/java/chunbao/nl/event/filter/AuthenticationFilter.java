package chunbao.nl.event.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * A filter to create transaction before and commit it once request completes The current
 * implemenatation is just for demo
 *
 * @author hemant
 */
@Component
@Order(1)
public class AuthenticationFilter implements Filter {

  private static final Logger LOG = LoggerFactory.getLogger(AuthenticationFilter.class);

  @Autowired LoginCheck loginCheck;

  @Override
  public void init(final FilterConfig filterConfig) throws ServletException {
    LOG.info("Initializing filter :{}", this);
  }

  @Override
  public void doFilter(
      final ServletRequest request, final ServletResponse response, final FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    if (loginCheck.hasLogin((String) req.getSession().getAttribute("username"))) {

      chain.doFilter(request, response);
    } else {
      LOG.info("Please login");
      HttpServletResponse res = (HttpServletResponse) response;
      res.sendRedirect("/");
    }
  }

  @Override
  public void destroy() {
    LOG.warn("Destructing filter :{}", this);
  }
}
