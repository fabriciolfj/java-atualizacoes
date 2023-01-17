package br.com.github.seleadsimulation;

import java.time.LocalDateTime;

public sealed interface FXOrder permits MarketOrder, LimitOrder {
    int units();
    int pair();
    int side();
    LocalDateTime sentAt();
}
