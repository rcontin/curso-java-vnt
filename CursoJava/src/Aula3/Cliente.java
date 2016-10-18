package Aula3;

public class Cliente {
    ContaCorrente cc = new ContaCorrente();
    String nome;
    int codigo;
    
    
}

/*

1. Inicie um novo projeto no Eclipse chamado MeuBanco
a. Crie uma classe abstrata Conta.
i. Insira o atributo saldo
ii. Insira os métodos saca, deposita, getSaldo
b. Cria uma classe ContaPoupanca que herde Conta
i. Implemente o método calculaJuros(juros) na classe
ContaPoupanca, que vai calcular os juros do mês.
c. Crie uma classe ContaCorrente
i. Insira o atributo limite na classe ContaCorrente
ii. Sobrescreva a o método getSaldo para que retorne o saldo
considerando o limite
d. Crie uma classe Cliente
i. insira um atributo Conta, nome e codigo
ii. Crie os getters e setters
e. Crie uma classe TestaCliente que teste todos os métodos e
atributos dos itens acima.

*/
