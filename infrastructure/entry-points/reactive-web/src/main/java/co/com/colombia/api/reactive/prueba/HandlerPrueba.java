package co.com.colombia.api.reactive.prueba;

import co.com.colombia.api.model.prueba.PruebaResponse;
import co.com.colombia.api.usecase.prueba.PruebaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class HandlerPrueba {

    private PruebaUseCase balanceUseCase;

    public Mono<ServerResponse> getTest(ServerRequest request) {

        Mono<PruebaResponse> result = balanceUseCase.getTest();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, PruebaResponse.class);

    }



}
