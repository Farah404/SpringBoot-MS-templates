package fr.isika.al17.urbanisationsi.zuulserver.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogFilter extends ZuulFilter {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() throws ZuulException {
        // TODO Auto-generated method stub
        HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
        log.info("**** Requête interceptée ! L'URL est : {} " , req.getRequestURL());
        return null;
    }
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 1;
    }
}