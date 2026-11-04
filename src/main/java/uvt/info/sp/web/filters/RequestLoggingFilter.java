package uvt.info.sp.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Order(2)
public class RequestLoggingFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        LOG.info(
                "Logging Request  {} : {}", req.getMethod(),
                req.getRequestURI());
        chain.doFilter(request, response);
        LOG.info(
                "Logging Response STATUS {} : {}",
                res.getStatus(),
                res.getContentType());
    }

    // other methods
}

