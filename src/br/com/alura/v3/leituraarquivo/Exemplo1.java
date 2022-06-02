package br.com.alura.v3.leituraarquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exemplo1 {

    public static void main(String[] args) throws Exception {
        Path file = Paths.get("/Users/fabriciojacob/Documents/texto.txt");

        try (FileReader isr = new FileReader(file.toFile(), StandardCharsets.ISO_8859_1)) {
            int i;
            while ((i = isr.read()) != -1) {
                System.out.println((char) i);
            }
        }

        try (BufferedReader isr = new BufferedReader( new InputStreamReader(new FileInputStream(file.toFile()), StandardCharsets.ISO_8859_1))) {
            String i;
            while ((i = isr.readLine()) != null) {
                System.out.println(i);
            }
        }
    }
}
