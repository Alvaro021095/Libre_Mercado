package co.com.colombia.api.reactive.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouteProduct {

    @Bean
    public RouterFunction<ServerResponse> routesBalance(HandlerProduct handler){
        return  route(
                POST("/test")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::getAllProducts)
                .andRoute(GET("/list-all-products")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::getAllProducts);

    }


}

