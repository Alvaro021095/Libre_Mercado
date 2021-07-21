package co.com.colombia.api.usecase.prueba;

import co.com.colombia.api.model.mdm.RedisMdmGateway;
import co.com.colombia.api.model.products.ResponseProducts;
import co.com.colombia.api.model.products.gateway.ProductGateway;
import reactor.core.publisher.Mono;

public class ProductUseCase {

    private ProductGateway productGateway;
    private RedisMdmGateway redisMdmGateway;


    public ProductUseCase(ProductGateway productGateway, RedisMdmGateway redisMdmGateway){
        this.productGateway = productGateway;
        this.redisMdmGateway = redisMdmGateway;
    }

    public Mono<ResponseProducts> getAllProduct() {
        Mono<String> key = redisMdmGateway.getMdmKey("CC","1094951793");
        key.doOnNext(valor -> System.out.printf("Valor Llave: " + valor)).subscribe();
        return productGateway.getAllProducts();
    }



}

