package org.landy.chain.responsibility.demo2;

import org.landy.chain.responsibility.demo2.domain.Request;
import org.landy.chain.responsibility.demo2.domain.Response;

/**
 * @author landyl
 * @create 2:16 PM 05/12/2018
 */
public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setRequestStr(request.getRequestStr().replace('<', '[').replace(">", "]")+"---HTMLFilter()");
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr()+"---HTMLFilter()");
    }
}
