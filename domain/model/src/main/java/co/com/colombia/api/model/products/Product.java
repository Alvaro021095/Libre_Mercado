package co.com.colombia.api.model.products;

import co.com.colombia.api.model.commons.TypeOfPay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {

    private String id;
    private String code;
    private String name;
    private double price;
    private int discount;
    private List<TypeOfPay> paymentMethod;
    private int stock;

}
