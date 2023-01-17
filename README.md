# java-atualizacoes

## Módulos
- uma outra forma de impor restrições de acesso a classes públicas dentro de certos pacotes
- podemos definir dentro do módulo, ou melhor, expor certos packages que poderão ser acessados publicamente

## Transitividade
- exemplo para explicar melhor esse conceito:
  - se um módulo A requer outro módulo transitivamente, então quer código que dependa de A também, implicitamente, pegará as dependências transitivas. 

## Tipos de módulos

### Módulos da plataforma
- são módulos da própria jdk

### Módulos de aplicativos
- são dependência do de um aplicativo ou o próprio aplicativo

### Módulos automáticos
- são classes que não estão dentro de um módulo, mas são inseridas em um automaticamente (o arquivo jar aonde elas se encontram que é utilizado/inserido dentro do módulo automático)

### Switch expressions vs Switch instruction
- expressã0 -> se todas as probabilidades são verificadas, não presiva da instrução default
- expressão podem retornar um valor
- instrução executa um código que ocasiona um efeito colateral

### Records
- são classes com representatividade de campos
- são imutáveis
- podemos fazer uso de construtores compactos, que tem por objetivo validar ou normalizar as informações. Exemplo:
```
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
}

```
