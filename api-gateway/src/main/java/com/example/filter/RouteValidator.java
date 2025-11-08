package com.example.filter;

import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class RouteValidator {

    public static final List<String> openApiEndPoints = List.of("/auth/register", "/auth/validate", "/auth/token");
    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest -> openApiEndPoints.stream().noneMatch(uri->serverHttpRequest.getURI().toString().equals(uri));



}
