package co.com.colombia.api.handler;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

public class GlobalErrorAtributes extends DefaultErrorAttributes {

    public GlobalErrorAtributes() {
        super();
    }

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(request, includeStackTrace);
        return map;
    }

}
