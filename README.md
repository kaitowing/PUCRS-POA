## Problema de Otimização de Pagamento de Empréstimos
Este projeto aborda a otimização do pagamento de empréstimos em uma empresa de modelos generativos. O objetivo é determinar a ordem em que os empréstimos devem ser pagos para minimizar o valor total gasto, levando em consideração as diferentes taxas de juros associadas a cada empréstimo.

## Descrição do Problema
A empresa possui 𝑛 empréstimos de vários bancos diferentes, cada um com uma taxa de juros 𝑟! maior que 1. O valor dos empréstimos aumenta de acordo com essa taxa de juros a cada mês. O objetivo é determinar a ordem de pagamento dos empréstimos para minimizar o valor total gasto pela empresa.

## Solução
Foi implementado um algoritmo guloso para resolver o problema. O algoritmo calcula a ordem de pagamento dos empréstimos, priorizando aqueles com as maiores taxas de juros, o que minimiza o valor total gasto pela empresa. A complexidade do algoritmo é polinomial em relação ao número de empréstimos.

## Implementação
A solução foi implementada em Java, aproveitando uma fila de prioridade para otimizar a ordenação dos empréstimos. Foram realizadas algumas otimizações para tornar o cálculo mais eficiente, como pré-calcular as potências das taxas de juros.

## Uso
Para executar o algoritmo com um conjunto de taxas de juros, basta chamar a função ordemPagamentoEmprestimos(taxasJuros) e passar as taxas de juros desejadas como argumento. Se quiser apenas testálo com taxas aleatória apenas compile usando o comando `javac App.java` e depois o comando `java App [algoritmo] [numero de casos de teste]` . Temos como argumentos apenas 'heap' e 'quick', cada um respectivamente irá utilizar um heapsort e um quicksort na contrução da solução.

## Licença
Este projeto está licenciado sob a licença MIT - consulte o arquivo LICENSE para obter detalhes.
