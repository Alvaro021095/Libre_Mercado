package co.com.colombia.api.model.prueba;

import reactor.core.publisher.Mono;

public interface PruebaGateway {

    Mono<PruebaResponse> getTest();

}
