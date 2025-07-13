# Strategy Pattern Demo (Java 21)

Este projeto demonstra o uso do padrão de projeto comportamental **Strategy** em Java 21.

## Conceito

O padrão Strategy permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Com isso, o algoritmo pode variar independentemente dos clientes que o utilizam. No nosso exemplo, o algoritmo é o método de pagamento, que pode ser *Cartão de Crédito*, *PIX* ou *Boleto*.

## Estrutura do Projeto

```
strategy_pattern_demo/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── strategy/
                        ├── PaymentStrategy.java  <- Interface Strategy
                        ├── PaymentContext.java   <- Context
                        ├── Main.java            <- Classe de demonstração
                        └── strategies/
                            ├── CreditCardPayment.java <- Estratégia concreta
                            ├── PixPayment.java        <- Estratégia concreta
                            └── BoletoPayment.java     <- Estratégia concreta
```

### Principais Componentes

* **PaymentStrategy** – Interface que define o contrato do algoritmo `pay(amount)`.
* **PaymentContext** – Guarda uma referência para `PaymentStrategy` e delega a ela o comportamento.
* **Concrete Strategies** – Implementações específicas (`CreditCardPayment`, `PixPayment`, `BoletoPayment`).
* **Main** – Demonstra a troca da estratégia em tempo de execução.

## Requisitos

* Java 21 (JDK)
* Maven 3.9+

## Como Executar

1. Abra um terminal na raiz do projeto.

2. Compile o projeto:

```bash
mvn clean package
```

3. Execute a aplicação:

```bash
java -cp target/strategy-pattern-demo-1.0-SNAPSHOT.jar com.example.strategy.Main
```

Você deverá ver uma saída semelhante a:

```
Pagando R$ 250,00 usando Cartão de Crédito ************3456
Pagando R$ 180,00 via PIX utilizando a chave flavio@example.com
Gerando boleto no valor de R$ 90,00. Número do boleto: 1234567890...
```

## Observações Importantes

* O **Context** desconhece o tipo concreto da estratégia, sabendo apenas que ela implementa `PaymentStrategy`.
* Podemos adicionar novas formas de pagamento sem alterar as classes existentes, respeitando o *Open/Closed Principle*.
* As mensagens impressas simulam a integração com serviços externos de forma simplificada.

---

© 2025 – Exemplo educacional do padrão Strategy em Java. 