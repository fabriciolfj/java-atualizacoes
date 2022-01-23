package br.com.alura.v2.sealed;

public sealed interface JungleAnimal permits Monkey, Snake {

    void printName();
}
