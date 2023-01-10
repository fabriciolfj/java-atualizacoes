# java-atualizacoes

## Módulos
- uma outra forma de impor restrições de acesso a classes públicas dentro de certos pacotes
- podemos definir dentro do módulo, ou melhor, expor certos packages que poderão ser acessados publicamente

## Transitividade
- exemplo para explicar melhor esse conceito:
  - se um módulo A requer outro módulo transitivamente, então quer código que dependa de A também, implicitamente, pegará as dependências transitivas. 