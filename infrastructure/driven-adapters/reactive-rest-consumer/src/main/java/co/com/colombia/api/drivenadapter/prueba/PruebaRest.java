package co.com.colombia.api.drivenadapter.prueba;

import co.com.colombia.api.model.prueba.PruebaResponse;
import co.com.colombia.api.model.prueba.PruebaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PruebaRest implements PruebaGateway {

    @Autowired
    private WebClient webClient;

    public PruebaRest(){ }

    @Override
    public Mono<PruebaResponse> getTest() {
        return webClient
                .get()
                .uri("")
                .retrieve()
                .bodyToMono(PruebaResponse.class);
    }
}
