package fr.isika.al17.urbanisationsi.zuulserver.filters;

import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ResponseFilter extends ZuulFilter  {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean shouldFilter() {
        return false;
//        return true; // NE PAS OUBLIER DE repasser à false sinon on a tj 400 Bad Request
    }
    @Override
    public Object run() throws ZuulException {
        // TODO Auto-generated method stub
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        response.setStatus(400); // 400 Bad Request
        log.info(" CODE HTTP {} ", response.getStatus());
        return null;
    }
    @Override
    public String filterType() {
        return "post";
    }
    @Override
    public int filterOrder() {
        return 1;
    }
}
