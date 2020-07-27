package com.bosssoft.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;

/**
 * @author 张东海
 * @date 2020/7/23
 * @description
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        HashMap<Object, Object> logMap = new HashMap<>();
        logMap.put("id",request.getId());
        logMap.put("path",request.getPath());
        logMap.put("remoteAddress",request.getRemoteAddress());
        logMap.put("method",request.getMethod());
        logMap.put("enterDateTime",LocalDateTime.now());
        String uri = request.getURI().toString();
        String userId = uri.substring(uri.lastIndexOf("/") + 1);
        log.info("欢迎您,用户："+userId);
        return chain.filter(exchange).then(Mono.fromRunnable(
                () -> {
                    log.info("再见，用户："+userId);
                    logMap.put("leaveDateTime",LocalDateTime.now());
                    String logMapString = logMap.toString()+"\n";
                    try {
                        Files.write(Paths.get("access_log.txt"), logMapString.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
