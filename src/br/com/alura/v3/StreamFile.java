package br.com.alura.v3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamFile {

    public static void main(String[] args) {
        try(Stream<String> stream = Files.lines(Paths.get("/Users/fabriciojacob/Documents/repositorios/java-atualizacoes/teste.txt"));) {
            stream.forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
