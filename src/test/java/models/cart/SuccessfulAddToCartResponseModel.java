package models.cart;

import lombok.Data;

import java.util.List;

@Data
public class SuccessfulAddToCartResponseModel {
    Boolean success;
    State state;

    @Data
    public static class State {
        List<CartItem> inCart;
        Total total;
        TotalHeader totalHeader;
        Integer minOrderPrice;
        Integer minOrderPriceB2C;
        Integer minOrderPriceB2B;
    }

    @Data
    public static class CartItem {
        Integer quantity;
        Integer productId;
        Integer cartId;
        SeoInfo seoInfo;
    }

    @Data
    public static class SeoInfo {
        String item_name;
        Double price;
        String item_brand;
        CategoryList categoryList;
        String retailRocketID;
    }

    @Data
    public static class CategoryList {
        String item_category2;
        String item_category;
        String item_category3;
    }

    @Data
    public static class Total {
        Integer positionCount;
        Integer count;
        Double basePrice;
        Double productPrice;
        Double deliveryPrice;
        Double price;
        Double discount;
        Integer deliveryDiscount;
        Integer weight;
    }

    @Data
    public static class TotalHeader {
        Double price;
        Integer count;
    }
}