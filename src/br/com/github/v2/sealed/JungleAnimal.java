package br.com.github.v2.sealed;

public sealed interface JungleAnimal permits Monkey, Snake {

    void printName();
}
