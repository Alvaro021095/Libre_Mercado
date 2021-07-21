package co.com.colombia.api.drivenadapter.product;

import co.com.colombia.api.model.products.ResponseProducts;
import co.com.colombia.api.model.products.gateway.ProductGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ProductRest implements ProductGateway {

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<ResponseProducts> getAllProducts() {

        return webClient
                .get()
                .uri("/list-all-products")
                .retrieve()
                .bodyToMono(ResponseProducts.class);

    }
}
