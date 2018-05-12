package org.landy.chain.responsibility.demo2;

import org.landy.chain.responsibility.demo2.domain.Request;
import org.landy.chain.responsibility.demo2.domain.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author landyl
 * @create 2:16 PM 05/12/2018
 */
public class FilterChain implements Filter {
    private List<Filter> filters = new ArrayList<Filter>();
    int index = 0;    //标记执行到第几个filter

    //把函数的返回值设为FilterChain，返回this,就能方便链式编写代码
    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        //代码的设计技巧:Chain链添加过滤规则结束后返回添加后的Chain，方便我们下面doFilter函数的操作
        return this;
    }

    public void doFilter(Request request, Response response, FilterChain fc) {
        if(index == filters.size()) return ;
        Filter f = filters.get(index);
        index++;
        f.doFilter(request, response, fc);
    }
}
