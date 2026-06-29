package models.cart;

import lombok.Data;

import java.util.List;

@Data
public class RemoveOneItemFromCartRequestModel {
    Boolean state;
    List<Integer> cartId;
}