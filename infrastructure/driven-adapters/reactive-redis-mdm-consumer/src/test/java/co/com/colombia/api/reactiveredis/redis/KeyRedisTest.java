package co.com.colombia.api.reactiveredis.redis;

import co.com.bancolombia.cgc.lifecoach.model.commons.KeyRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class KeyRedisTest {

    @InjectMocks
    KeyRedisMdm keyRedis;

    @Mock
    ReactiveRedisOperations<String, String> clientRedis;

    @Mock
    ReactiveValueOperations valueOperations;

    Mono<String> VALUE_KEY = Mono.just("AEkYzMxZDIzYzEtYTIxNy00NTgyLThkMzMtYTdiMjEyY2ZmYjg2lIz78I7rh80UPdN");

    @Before
    public void init(){

        when(clientRedis.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get(any(String.class))).thenReturn(VALUE_KEY);
        when(valueOperations.getAndSet(any(String.class),any(String.class))).thenReturn(VALUE_KEY);

    }

    @Test
    public void testGetOauthKey(){

        MockitoAnnotations.initMocks(this);
        Mono<String> result = keyRedis.getMdmKey("CC", "1234567");
        assertNotNull(result);

    }

    @Test
    public void testGetOauthKeyUserFlag(){

        MockitoAnnotations.initMocks(this);
        Mono<String> result = keyRedis.getUserFlag("CC", "1234567");
        assertNotNull(result);

    }

    @Test
    public void testRegistryKey(){

        KeyRedis keyRe = KeyRedis.builder()
                .key("CC")
                .value("10949571803")
                .build();
        MockitoAnnotations.initMocks(this);
        Mono<String> result = keyRedis.registryUser(keyRe);
        assertNotNull(result);

    }

}
