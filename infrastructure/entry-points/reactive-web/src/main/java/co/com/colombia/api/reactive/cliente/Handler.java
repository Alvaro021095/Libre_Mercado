package co.com.colombia.api.reactive.cliente;

import co.com.colombia.api.model.prueba.PruebaResponse;
import co.com.colombia.api.usecase.client.ClientUseCase;
import co.com.colombia.api.usecase.prueba.PruebaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class Handler {

    private ClientUseCase clientUseCase;

    public Mono<ServerResponse> saveClient(ServerRequest request) {

        //Mono<Void> result = clientUseCase.saveClient();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("result", String.class);

    }

    public Mono<ServerResponse> getClient(ServerRequest request) {

        //Mono<Void> result = clientUseCase.saveClient();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("result", String.class);

    }

    public Mono<ServerResponse> updateClient(ServerRequest request) {

        //Mono<Void> result = clientUseCase.saveClient();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("result", String.class);

    }

    public Mono<ServerResponse> deleteClient(ServerRequest request) {

        //Mono<Void> result = clientUseCase.saveClient();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("result", String.class);

    }

}
