package com.zyc.util;

import com.zyc.utils.R;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;
import com.alibaba.fastjson.JSON;

public class ResponseUtil {
	public static Mono<Void> webFluxResponseWriter(ServerHttpResponse response, String msg) {
		response.setStatusCode(HttpStatus.OK);
		response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf8");
		R result = R.error().code(HttpStatus.UNAUTHORIZED.value()).message(msg);
		DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
		return response.writeWith(Mono.just(dataBuffer));
	}
}