# Trabalho de TPPE - Prof. André Lanna

## Integrantes

| Nome | Matrícula |
| ---- | :-------: |
| Caio Vitor Carneiro de Oliveira | 200057227 |
| Lucas Lopes Rocha | 202023903 |

## Introdução
Repositório destinado à implementação do trabalho de Técnicas de Programação em Plataformas Emergentes (TPPE), ministrado pelo professor André Lanna na UnB/FGA. Este projeto visa desenvolver um sistema de vendas simples para uma loja virtual, utilizando Java e práticas de desenvolvimento orientado a testes (TDD - Test-Driven Development). O sistema permite cadastrar clientes com diferentes tipos, cadastrar produtos, realizar vendas e calcular valores de frete, descontos e impostos associados às vendas.

### Objetivos Principais
- Implementar classes para clientes, produtos, vendas e outros componentes relacionados ao sistema de vendas.
- Utilizar o Maven para gerenciar o projeto e as dependências.
- Implementar testes automatizados para as funcionalidades principais do sistema utilizando JUnit.
- Aplicar princípios de TDD para desenvolver o código de forma incremental e orientada pelos testes.

### Funcionalidades Implementadas
- **Clientes:** Cadastra clientes com diferentes tipos (padrão, especial e prime), associando um tipo de cliente a um endereço que pode ser na capital ou no interior.
- **Produtos:** Cadastra produtos com código, descrição, valor de venda e unidade de medida.
- **Vendas:** Permite realizar vendas associadas a um cliente, com múltiplos produtos, método de pagamento e endereço de entrega. Calcula o valor total da venda, incluindo descontos para clientes especiais, cashback para clientes prime, frete e impostos (ICMS e municipal).
- **Testes Automatizados:** Implementa testes unitários parametrizados para validar o comportamento esperado das classes Cliente, Produto, Venda e outras funcionalidades do sistema.

## Como Rodar o Projeto
### Pré-requisitos
- Java - [ACESSO](https://www.java.com/pt-BR/)
- JUnit4 - [ACESSO](https://junit.org/junit4/)
- Maven - [ACESSO](https://maven.apache.org/)
- Ambiente de desenvolvimento integrado (IDE) compatível com Java, como Eclipse, IntelliJ IDEA ou Visual Studio Code.

### Passos para Execução


1. Clone o Repositório:

``` bash
git clone https://github.com/caiozim112/FGA0242_TP_TDD_CAIO_LUCAS.git
cd FGA0242_TP_TDD_CAIO_LUCAS/demo
```

2. Executar os Testes:

Via linha de comando (Terminal ou prompt de comando):

```bash
mvn compile
mvn test
```

Ou execute os testes diretamente do seu IDE, navegando até a classe de teste (por exemplo, VendaTest. java) e executando os testes individualmente ou em grupo.

3. Verificar Resultados:
Após a execução dos testes, verifique a saída para garantir que todos os testes passaram conforme esperado.

## Conclusão
Este projeto demonstra a aplicação de conceitos de TDD no desenvolvimento de um sistema de vendas Java. Através da prática de testes automatizados, garantimos a robustez e a confiabilidade das funcionalidades implementadas, proporcionando uma base sólida para futuras expansões e manutenções do sistema.

## Referências
> GARCIA, G. Entenda o que é TDD: Como Funciona e Benefícios.  Disponível em: <https://mercadoonlinedigital.com/blog/tdd/#:~:text=Entenda%20como%20funciona%20o%20ciclo%20TDD%201%20Red,ciclo%20TDD%20%C3%A9%20a%20%E2%80%9CRefactor%E2%80%9D%20ou%20%E2%80%9CRefatorar%E2%80%9D.%20>. Acesso em: 29 jun. 2024.