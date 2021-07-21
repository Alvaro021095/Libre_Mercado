package co.com.colombia.api;

import co.com.colombia.api.model.mdm.RedisMdmGateway;
import co.com.colombia.api.model.products.gateway.ProductGateway;
import co.com.colombia.api.usecase.prueba.ProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

	@Bean
	public ProductUseCase productUseCase(ProductGateway productGateway, RedisMdmGateway redisMdmGateway) {
		return new ProductUseCase(productGateway, redisMdmGateway);
	}

}
