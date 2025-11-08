package com.example.filter;

import com.example.util.JWTService;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private final RouteValidator validator;
    private final JWTService jwtService;

    public AuthFilter(RouteValidator validator, JWTService jwtService) {
        super(Config.class);
        this.validator = validator;
        this.jwtService = jwtService;

    }

    @Override
    public GatewayFilter apply(Config config) {

        return (((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Missing auth header");
                }
                String auth = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                if (auth != null && auth.startsWith("Bearer ")) {
                    auth = auth.substring("Bearer ".length());
                }
                try {
                    //restTemplate.getForObject("http://localhost:9898/auth/validate" + auth, String.class);
                    jwtService.validateToken(auth);
                } catch (Exception e) {
                    throw new RuntimeException("Unauthorized");
                }
            }
            return chain.filter(exchange);
            //return chain.filter(exchange).then(chain.filter(exchange).then(chain.filter(exchange)));
        }));
    }

    public static class Config {
    }
}
