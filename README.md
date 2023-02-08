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

### Bytecode
- para ver o bycode de uma classe, execute:
````
javap -c -p ArraySimulacao

````

### Inteface lock
- adiciona diferentes tipos de bloqueios (como bloqueios de leitura/escrita)
- não restringe bloqueios a blocos(permite bloqueio a um método e um desbloqueio em outro)
- se uma thread não adquirir um bloqueio,permite que ela volte ou faça outra coisa
- permite que uma thread tente adquirir um bloqueio e desista após um determinado período de tempo

#### Implementações da interface lock
- reentrantLock -> equivale ao synchronized, so que mais flexível
- reentrantReadWriteLock -> oferece melhor desempenho onde há muitos leituros e poucos escritores

### CountdownLatch
- fornece uma barreira de consenso, prmite que várias threads alcancem um ponto de coordenação e esperem até que a barreira seja liberada.
- para isso forneça uma int ao construi-lo
- o operator await bloquea o método até que chegue a 0 o contador (countDown())

### CopyOnWriteArrayList
- tira uma copia da lista quando esta é modificada, por exemplo abaixo:
```
        var ls = new CopyOnWriteArrayList(List.of(1, 2, 3));
        var it = ls.iterator();
        ls.add(4);
        var modifiedIt = ls.iterator();
        while (it.hasNext()) {
            System.out.println("Original: "+ it.next());
        }
        while (modifiedIt.hasNext()) {
            System.out.println("Modified: "+ modifiedIt.next());
        }
```

### Queue
- utilizamos mais a interface BlockingQueue, que extende a interface Queue
- Existem alguns operadores, como:
  - put -> colocar um item na fila
  - take() -> esperar surgir um item na fila, caso surja, processe e libere o take
  - pool espere durante um tempo na fila, caso não surja nenhum item, retorna um null
  - affer() lança uma exception, caso não tenha nenhum item
- O funcionamento entre consumir e produzir itens na fila via threads, segue:
  - a thread produz um item na fila put, e essa não é bloqueada
  - a thread que chamar um take(), ela ficará bloqueada até que surja um item
  - caso a fila esteja cheia, a thread é bloqueada no momento do put, até que seja liberado espaço

### Workunit
- é uma classe container, onde embrulhamos o body da mensagem ou objeto a ser inserido na fila
- ideal para testes, metadados de metricas e etc

### shutdown de um pool de threads
- inicia o desligamento ordenado, ou seja, as tarefas nos pool são executadas/concluídas e nenhuma nova tarefa é aceita.

### Executors
- single thread executor -> executor com uma única thread
- fixed thread pool -> pool com um número fixo de threads, passada por parâmetro
- cache thread pool -> cria threads no cache, conforme a necessidade, e as destroi após 60 segundos sem uso (obs, pode criar muitas threads)
- scheduled thread pool executor -> criá uma thread, após a conclusão da anterior  e o atraso especificado tiver decorrido

### Desempenho JVM

#### latencia
- tempo de ponta a ponta necessário para processar uma unica unidade de trabalho em uma determinada carga de trabalho.

#### Throughput
- número de unidades de trabalho que um sistema pode executar, em algum período de tempo com recursos fornecidos

#### Capacidade
- número de unidades de trabalho que podem estar em andamento, pelo sistema a qualquer momento.

#### Escalabilidade
- a medida que os recursos são adicionados a um sistema, a taxa de transferência (ou latência) muda. Essa mudança na taxa de transferência ou latência é a escalabilidade do sistema

#### Degradação
- quando ao adicionar unidades de trabalho a um sistema, causará um efeito negativo, seja aumento da latência do processamento.

### Memoria JVM
- pilha -> onde as variávies locais  primitivas são armazenadas e variavéis do tipo referência
- as variavéis do tipo referência na stack (pilha), apontam para um local no heap
- heap -> aonde os objetos são criados
- gc (coleta de lixo) -> tira do heap variáveis que não estão sendo utilizadas 
- em 2022, a prática recomendada para a maioria das cargas de trabalho, na ausência de qualquer outra evidência, é definir Xmxe não definir Xms.

### JIT (just in time)
- compilação na hora certa
- java é compilado
- a jvm verifica o bytecode gerado, e os métodos mais utilizados primeiro, são compilados
- ou seja, na jvm moderna, os métodos são compilados sobdemanda


### Hotspot
- java é uma linguagem dinamicamente compilada, ou seja:
 - gera o bytecode (faz o uso da interpretação)
 - os métodos mais utilizados são transformados em linguagem de máquina, tornando 100 vezes mais rapidos

### Versionamento
- PRINCIPAL -> 1.x
- MINOR -> tem retrocompatibilidade com versões anteriores 1.1
 PATH, para correções e bugs 1.1.1