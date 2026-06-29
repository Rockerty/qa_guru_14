package models.favorite;

import lombok.Data;

import java.util.List;

@Data
public class SuccessfulAddToFavoriteResponseModel {
    Boolean success;
    State state;
    String message;

    @Data
    public static class State {
        List<Integer> productIds;
    }
}