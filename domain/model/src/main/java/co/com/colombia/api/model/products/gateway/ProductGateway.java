package co.com.colombia.api.model.products.gateway;

import co.com.colombia.api.model.products.ResponseProducts;
import reactor.core.publisher.Mono;

public interface ProductGateway {

    Mono<ResponseProducts> getAllProducts();

}
