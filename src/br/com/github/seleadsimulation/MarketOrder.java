package br.com.github.seleadsimulation;

import java.time.LocalDateTime;

public record MarketOrder(int units,
                          int pair,
                          int side,
                          LocalDateTime sentAt,
                          boolean allOrNothing) implements FXOrder {
}
