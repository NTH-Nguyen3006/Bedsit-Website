package com.example.ahihi.sevices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class AdminService {

    @Autowired
    RequestMappingHandlerMapping requestMappingHandlerMapping;

    public List<?> getEndpointsServices(String controllerName) {
        List<Map<String, String>> endpointDetails = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
            RequestMappingInfo mappingInfo = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();

            Set<String> urlPatterns = new HashSet<>();

            // Ưu tiên lấy PathPattern (Spring 6+ default)
            PathPatternsRequestCondition pathPatternsCondition = mappingInfo.getPathPatternsCondition();
            if (pathPatternsCondition != null) {
                pathPatternsCondition.getPatterns()
                        .forEach(pathPattern -> urlPatterns.add(pathPattern.getPatternString()));
            }

            if (urlPatterns.isEmpty()) {
                PatternsRequestCondition patternsCondition = mappingInfo.getPatternsCondition();
                Optional.ofNullable(patternsCondition)
                        .map(PatternsRequestCondition::getPatterns)
                        .ifPresent(patterns -> urlPatterns.addAll(patterns));
            }

            String finalUrlPatterns = urlPatterns.isEmpty() ? "N/A" : String.join(", ", urlPatterns);
            String controllerClassName = handlerMethod.getBeanType().getSimpleName();

            Map<String, String> endpointMap = new java.util.HashMap<>();
            if (controllerClassName.equals(controllerName)) {
                String endpoint = finalUrlPatterns;
                String title = "";

                endpointMap.put(endpoint, title);
                endpointDetails.add(endpointMap);
            }
            // Map<String, String> endpointMap = new java.util.HashMap<>();
            // endpointMap.put("url", finalUrlPatterns);
            // endpointMap.put("httpMethods", httpMethods);
            // endpointMap.put("controller", controllerClassName);
            // endpointMap.put("method", methodName);

        }

        System.out.println(endpointDetails.toString());

        return null;
    }
}
