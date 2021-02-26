package co.com.colombia.api.model.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    private String nombre;
    private String apellido;
    private String telefono;
    private String emain;
    private String tipo_doc;
    private String numero_doc;

}
