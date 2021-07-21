package co.com.colombia.api.reactiveredis.redis;


import co.com.colombia.api.model.mdm.RedisMdmGateway;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Component;

import co.com.colombia.api.reactiveredis.commons.Util;
import reactor.core.publisher.Mono;


@Component
public class KeyRedisMdm implements RedisMdmGateway {

    private final ReactiveRedisOperations<String, String> redisOperationsString;

    public KeyRedisMdm(ReactiveRedisOperations<String, String> clientRedis) {
        this.redisOperationsString = clientRedis;
    }

    @Override
    public Mono<String> getMdmKey(String typeDocument, String documentNumber) {

        String key = Util.formattedKey(typeDocument,documentNumber);
        ReactiveValueOperations valueOperations = redisOperationsString.opsForValue();
    
        return valueOperations.get(key);

    }

}
