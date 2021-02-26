package co.com.colombia.api.reactive.cliente;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routesClient(Handler handler){
        return  route(
                POST("/save-client")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::saveClient)
                .andRoute(GET("/get-client")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::getClient)
                .andRoute(PUT("/update-client")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::updateClient)
                .andRoute(DELETE("/delete-client")
                        .and(accept(APPLICATION_JSON))
                        .and(contentType(APPLICATION_JSON)), handler::deleteClient);

    }

}
