package co.com.colombia.api;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.ConnectionObserver;
import reactor.netty.http.client.HttpClient;
import javax.net.ssl.SSLException;
import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient createWebClient() throws SSLException {
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        HttpClient httpClient = HttpClient.newConnection().compress(true).wiretap(true)
                .secure(t -> t.sslContext(sslContext))
                .tcpConfiguration(tcp ->
                        tcp.bootstrap(bootstrap -> bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS,
                                10000))
                                .observe((connect, newState) -> {
                                    if (ConnectionObserver.State.CONNECTED.equals(newState)) {
                                        connect.addHandlerLast(new ReadTimeoutHandler(10000,
                                                TimeUnit.MILLISECONDS));}}));

        return WebClient.builder().baseUrl("").clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }



}