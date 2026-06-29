package models.cart;

import lombok.Data;

import java.util.List;

@Data
public class AddToCartRequestModel {
    Boolean state;
    List<Integer> product;
    Integer quantity;
}