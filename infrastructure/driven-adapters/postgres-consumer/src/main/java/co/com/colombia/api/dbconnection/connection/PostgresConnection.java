package co.com.colombia.api.dbconnection.connection;

import co.com.colombia.api.model.cliente.gateway.GatewayCliente;
import co.com.colombia.api.model.cliente.request.Cliente;
import co.com.colombia.api.model.cliente.response.ResponseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PostgresConnection implements GatewayCliente {


    //Generar conectior a la bd

    @Override
    public Mono<ResponseClient> save(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<ResponseClient> get(String numeroDoc) {
        return null;
    }

    @Override
    public Mono<ResponseClient> update(Cliente cliente) {
        return null;
    }

    @Override
    public Mono<ResponseClient> delete(String numeroDoc) {
        return null;
    }
}
