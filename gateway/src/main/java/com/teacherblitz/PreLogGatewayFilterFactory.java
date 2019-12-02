package com.teacherblitz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * Spring Cloud GateWay自定义过滤器工厂
 * <pre>
 *     注意：必须以《GatewayFilterFactory》结尾，因为这个是gateway的约定
 *     -- 配置文件：名称必须为过滤器工厂类名的前缀，并且参数只能有两个，因为NameValueConfig里只定义了两个属性
 * </pre>
 * @author zhuyuan
 * @since 2019/11/24
 */
@Slf4j
@Component
public class PreLogGatewayFilterFactory
    extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return ((exchange, chain) -> {
            log.info("配置参数，NAME={},VALUE={}", config.getName(), config.getValue());
            ServerHttpRequest modifiedRequest = exchange.getRequest()
                .mutate()
                .build();
            ServerWebExchange modifiedExchange = exchange.mutate()
                .request(modifiedRequest)
                .build();
            return chain.filter(modifiedExchange);
        });
    }
}
