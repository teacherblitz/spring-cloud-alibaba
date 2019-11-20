package com.teacherblitz.sentinel.test;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 重新定义资源名称
 * @author teacherblitz
 * @since 2019/11/13
 */
@Component
public class MyUrlCleaner implements UrlCleaner {

    @Override
    public String clean(String originUrl) {
        String[] split = originUrl.split("/");
        return Arrays.stream(split).map(str ->{
            if(NumberUtils.isNumber(str)){
                return "{number}";
            }
            return str;
        })
        .reduce((a,b) -> a + "/" +b)
        .orElse("");
    }
}
