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

### Fork/Join
- o aumento da velocidade e cores dos processados, aumentaram muito
- mas o desempenho I/O não teve uma melhora notável
- Fork/join é uma tentativa de melhorar o desempenho do I/O
- alguns componentes que fazem parte do framework fork/join:
  - forkjoinpool -> é um poll executor
  - forkjointask -> é uma tarefa menor que a thread
- forjoin é ideal para solucionar problemas, que podem ser divididos
- por fim o forkjoin expõe os seguintes métodos primários:
  - execute() -> começa uma execução assíncrona
  - invoke() -> começa execução e aguarda o resultado
  - submit() -> começa a execução e retorna um futuro para o resultado
- O paralelismo, usando o api parallelStream, utilize com cuidado, pois ela utiliza um pool comum de threads, onde concorrerá por recursos, diminuindo o desempenho.
- é acomselhável combinar com o forkjoin pool, assim:
```
// Use a custom pool
var forkJoinPool = new ForkJoinPool(4);
List<String> origins2 = forkJoinPool.submit(() -> musicians
    .parallelStream()
    .filter(artist -> artist.getName().startsWith("The"))
    .map(artist -> artist.getNationality())
    .collect(toList())).get();
forkJoinPool.shutdown();
```

### Uso de identificadores de métodos
- os identificadores são uteis para utilizar na reflexão
- ideal para acessar métodos privados
- mais rápidos que a api antiga de reflexão
- exemplo:
- antiga
```
    public Method makeReflective() {
        Method meth = null;
 
        try {
            Class<?>[] argTypes = new Class[] { Void.class };
            meth = ExamplePrivate.class
                       .getDeclaredMethod("callThePrivate", argTypes);
            meth.setAccessible(true);
        } catch (IllegalArgumentException |
                    NoSuchMethodException |
                    SecurityException e) {
            throw (AssertionError)new AssertionError().initCause(e);
        }
 
        return meth;
    }
```
- nova (a partir do java 8)
```
    public MethodHandle makeMh() {
        MethodHandle mh;
        var desc = MethodType.methodType(void.class);
 
        try {
            mh = MethodHandles.lookup()
                     .findVirtual(ExamplePrivate.class,
                         "callThePrivate", desc);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw (AssertionError)new AssertionError().initCause(e);
        }
 
        return mh;
    }
```
- exemplo de uso para gerar uma logger:
```
Logger lgr = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
```

## Alocação memoria jvm
- Na Java Virtual Machine (JVM), as variáveis de instância (também conhecidas como variáveis de membro) são armazenadas em uma área de memória chamada heap. A heap é a área de memória compartilhada por todos os threads em execução na JVM e é usada para armazenar objetos e outras estruturas de dados dinamicamente alocados.

- Quando um objeto é criado em Java, um espaço é alocado na heap para armazenar suas variáveis de instância. Cada variável de instância é armazenada em um deslocamento específico dentro desse espaço de objeto, que é calculado em tempo de compilação com base no layout da classe e nas informações sobre os tipos de dados das variáveis de instância.

- Ao contrário das variáveis locais, que são armazenadas na stack e são alocadas e desalocadas automaticamente quando um método é chamado e retorna, as variáveis de instância são alocadas e desalocadas manualmente pelo programador, usando o operador new para criar novos objetos e o garbage collector para liberar a memória alocada por objetos que não estão mais em uso.

## callable vs supplier
- callable -> retorna um objeto, podendo lançar uma exception, indicado quando a tarefe é executada em outra thread. Em uma cadeia de chamadas, nao fica performatico, pois o tempo para concluir processo como um todo e a soma do tempo de cada tarefa. 
- supplier -> retorna um objeto, uso mais frequente e adiar a execução de algum código. Em varia tarefas, com apoio do completableFuture, cada uma e executada independentemente ou em paralelo, resolvendo o problema no uso do future com callable.

## completablefuture join vs get
- join pode lançar uma exception não verificada
- get exige que o programador capture a exception.
- ambos sincronização e retornam o valor