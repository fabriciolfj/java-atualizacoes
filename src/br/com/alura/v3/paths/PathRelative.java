package br.com.alura.v3.paths;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathRelative {

    public static void main(String[] args) throws IOException {
        //Path path = Paths.get(URI.create("file:///learning/packt/teste.pdf"));
        Path path = Paths.get("/Users/fabriciojacob/Documents/repositorios/java-atualizacoes/learning/packt/teste.pdf");
        Files.createFile(path);

        System.out.println(path.getRoot());
    }
}
