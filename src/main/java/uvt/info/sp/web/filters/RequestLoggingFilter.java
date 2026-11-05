package uvt.info.sp.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class RequestLoggingFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        log.info(
                "Logging Request  {} : {}", req.getMethod(),
                req.getRequestURI());
        chain.doFilter(request, response);
        log.info(
                "Logging Response STATUS {} : {}",
                res.getStatus(),
                res.getContentType());
    }
}
