package co.com.colombia.api.helpersutil;

import ch.qos.logback.classic.Logger;
import co.com.colombia.api.model.commons.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ConnectTimeoutException;
import io.netty.handler.timeout.ReadTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Slf4j
public class HelpersUtil {


    public static final String HREF = "href";
    public static final String STATUS = "status";
    public static final String CODE = "code";
    public static final String TITLE = "title";
    public static final String DETAIL = "detail";
    public static final String TRANSACTION_CODE = "transactionCode";
    public static final String EMPTY = "";


    private static Logger logger;


    public HelpersUtil() {
        logger = (Logger) LoggerFactory.getLogger("co.com.bancolombia.cgc");
    }


    public Mono<ServerResponse> responseError(Map<String, String> map, Header header) {

        String codeError = map.get(CODE);
        String detail = map.get(DETAIL);
        String href = map.get(HREF);
        String status = map.get(STATUS);
        String title = map.get(TITLE);
        ErrorPrueba error = ErrorPrueba
                .builder()
                .code(codeError).detail(detail).status(status).title(title).href(href)
                .build();

        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .header(Constant.PRODUCT_ID,Constant.ORCHESTRATOR_PRUEBA)
                .header(TRANSACTION_CODE, "0800")
                .body(Mono.just(getErrorEntity(error)), ListError.class);
    }

    public ListError getErrorEntity(ErrorPrueba errorRecharges) {

        return  ListError.builder().errors(
                Arrays.asList(ErrorPrueba
                        .builder()
                        .code(errorRecharges.getCode())
                        .detail(errorRecharges.getDetail())
                        .href(errorRecharges.getHref())
                        .title(errorRecharges.getTitle())
                        .status(errorRecharges.getStatus())
                        .build()))
                .build();

    }


    public Map<String, String> getErrorMessage(Throwable error) {

        Map<String, String> errorResult = new HashMap<>();

        log.info("*****ERROR****ERROR**** ::::: " + error);

        if (error instanceof WebClientResponseException) {
            WebClientResponseException webException = (WebClientResponseException) error;
            ObjectMapper objectMapper = new ObjectMapper();
            ListError errorData = null;

            try {
                errorData =  objectMapper.readValue(webException.getResponseBodyAsString(), ListError.class);
            } catch (IOException e) {
                errorResult.put(CODE, String.valueOf(webException.getStatusCode().value()));
                errorResult.put(DETAIL, webException.getMessage());
                return errorResult;
            }

            errorResult.put(HREF, errorData.getErrors().get(0).getHref());
            errorResult.put(STATUS, errorData.getErrors().get(0).getStatus());
            errorResult.put(CODE, errorData.getErrors().get(0).getCode());
            errorResult.put(TITLE, errorData.getErrors().get(0).getTitle());
            errorResult.put(DETAIL, errorData.getErrors().get(0).getDetail());

        } else if (error instanceof NullPointerException) {
            errorResult.put(CODE, String.valueOf(HttpStatus.BAD_REQUEST.value()));
            errorResult.put(DETAIL, HttpStatus.BAD_REQUEST.getReasonPhrase());
        } else if(error instanceof PruebaException){
            errorResult.put(CODE, ((PruebaException) error).getCode());
            errorResult.put(DETAIL, error.getMessage());
        } else if ( error instanceof TimeoutException) {
            errorResult.put(CODE, HelpersContants.ERROR_CODE_TIMEOUT_REDIS  );
            errorResult.put(DETAIL, HelpersContants.ERROR_MESSAGE_TIMEOUT_REDIS);
        } else if (error instanceof ReadTimeoutException) {
            errorResult.put(CODE, HelpersContants.HTTP_CODE_408);
            errorResult.put(DETAIL, HelpersContants.ERROR_READ_TIME_OUT_MESSAGE);
        } else if (error instanceof ConnectTimeoutException) {
            errorResult.put(CODE, HelpersContants.HTTP_CODE_409);
            errorResult.put(DETAIL, HelpersContants.ERROR_CONNECTION_TIME_OUT_MESSAGE);
        }

        return errorResult;
    }

}
