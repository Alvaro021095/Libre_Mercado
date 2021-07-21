package co.com.colombia.api.reactive.product;

import co.com.colombia.api.model.products.ResponseProducts;
import co.com.colombia.api.usecase.prueba.ProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class HandlerProduct {

    private ProductUseCase balanceUseCase;

    public Mono<ServerResponse> getAllProducts(ServerRequest request) {

        Mono<ResponseProducts> result = balanceUseCase.getAllProduct();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, ResponseProducts.class);

    }



}
