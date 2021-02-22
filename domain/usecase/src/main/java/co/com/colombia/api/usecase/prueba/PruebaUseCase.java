package co.com.colombia.api.usecase.prueba;

import co.com.colombia.api.model.prueba.PruebaResponse;
import co.com.colombia.api.model.prueba.PruebaGateway;
import reactor.core.publisher.Mono;

public class PruebaUseCase {

    private PruebaGateway pruebaGateway;

    public PruebaUseCase(PruebaGateway pruebaGateway){
        this.pruebaGateway = pruebaGateway;
    }

    public Mono<PruebaResponse> getTest() {
        return pruebaGateway.getTest();
    }



}

