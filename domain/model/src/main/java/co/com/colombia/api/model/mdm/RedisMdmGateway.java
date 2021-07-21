package co.com.colombia.api.model.mdm;

import reactor.core.publisher.Mono;

public interface RedisMdmGateway {

    Mono<String> getMdmKey(String typeDocument, String documentNumber);

}
