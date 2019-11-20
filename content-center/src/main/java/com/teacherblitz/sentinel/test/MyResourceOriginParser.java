package com.teacherblitz.sentinel.test;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 针对来源限流
 * @author teacherblitz
 * @since 2019/11/13
 */
//@Component
public class MyResourceOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 从请求参数中获取名为 origin 的参数并返回
        // 如果获取不到origin参数，那就抛异常
        String origin = request.getParameter("origin");
        if(StringUtils.isBlank(origin)){
            throw new IllegalArgumentException("origin must be specified");
        }
        return origin;
    }
}
