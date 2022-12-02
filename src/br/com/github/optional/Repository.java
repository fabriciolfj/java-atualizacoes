package br.com.github.optional;

import java.util.Optional;

public class Repository {

    public Optional<String> find() {
        throw new RuntimeException();
    }

    public Optional<String> findOk() {
        return Optional.of("teste");
    }

    public Optional<String> findEmpty() {
        return Optional.empty();
    }
}
