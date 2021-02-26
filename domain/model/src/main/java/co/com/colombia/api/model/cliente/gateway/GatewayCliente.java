package co.com.colombia.api.model.cliente.gateway;

import co.com.colombia.api.model.cliente.request.Cliente;
import co.com.colombia.api.model.cliente.response.ResponseClient;
import reactor.core.publisher.Mono;

public interface GatewayCliente {

    Mono<ResponseClient> save(Cliente cliente);
    Mono<ResponseClient> get(String numeroDoc);
    Mono<ResponseClient> update(Cliente cliente);
    Mono<ResponseClient> delete(String numeroDoc);

}
