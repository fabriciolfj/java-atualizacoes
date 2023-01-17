package br.com.github.v5;

import java.time.LocalDateTime;

public record FXOrder(int units,
                      int pair,
                      int side,
                      double price,
                      LocalDateTime sentAt,
                      int ttl) {

    public FXOrder {
        if (units < 1) {
            throw new IllegalArgumentException("units invalids");
        }
    }

    public static FXOrder of(int pair, int side, double price) {
        return new FXOrder(1, pair, side, price, LocalDateTime.now(), 1000);
    }
}
