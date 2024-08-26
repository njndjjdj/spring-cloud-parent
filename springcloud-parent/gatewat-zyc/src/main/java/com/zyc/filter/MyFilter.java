package com.zyc.filter;

import com.zyc.properties.MySecurityGatewayProperties;
import com.zyc.util.JwtUtil;
import com.zyc.util.ResponseUtil;
import com.zyc.constant.MyConstant;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/23
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@Component
@Slf4j
public class MyFilter implements GlobalFilter, Ordered {
    @Resource
    private MySecurityGatewayProperties properties;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 使用自定义全局过滤器进行网关鉴权
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();

        // 配置白名单，此名单上的路径不需要鉴权即可直接访问
        List<String> whites = properties.getWhites();
        // 通过exchange获得请求对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        // 根据请求对象获得uri
        URI uri = request.getURI();
        // 根据uri获得请求路径
        String path = uri.getPath();
        // 判断该路径是否在白名单内，如果在的话直接放行
        if (whites.contains(path)) {
            return chain.filter(exchange);
        }
        // 不在白名单内进行鉴权操作
        // 2.3 得到请求头中的token值
        String authorization = request.getHeaders().getFirst(MyConstant.AUTHORIZATION);
        // 由于jwt规定token必须加上 Bearer ，所以去掉之后才是真正的token
        String token = "";
        try {
            token = authorization.replace("Bearer ", "");
        } catch (Exception e) {
            return ResponseUtil.webFluxResponseWriter(response, "权限不足，登陆失败！");
        }
        // 获得封装进入的uuid
        Claims claims = JwtUtil.parseToken(token);
        String uuid = (String) claims.get("user_key");
        // 组装redis的key
        String key = MyConstant.LOGIN_TOKEN + uuid;
        // 去redis中查找是否有这个key
        Boolean hasKey = stringRedisTemplate.hasKey(key);
        // 不相等直接拦截抛异常
        if (Boolean.FALSE.equals(hasKey)) {
            return ResponseUtil.webFluxResponseWriter(response, "权限不足，登陆失败！");
        }
        // 满足条件直接放行
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }

    /**
     * 设置过滤器优先级
     *
     * @return
     */
    @Override
    public int getOrder() {
        return -100;
    }
}
