import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

class Emprestimo {
    int indice;
    double taxaJuros;

    // Classe para representar um empréstimo com índice e taxa de juros
    Emprestimo(int indice, double taxaJuros) {
        this.indice = indice;
        this.taxaJuros = taxaJuros;
    }
}

public class App {

    private static Random random = new Random();

    // Algoritmo que ordena os empréstimos usando Heap Sort
    public static List<Integer> ordemPagamentoEmprestimosHeapSort(double[] taxasJuros) {
        int n = taxasJuros.length;
        PriorityQueue<Emprestimo> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(e -> -e.taxaJuros));
        List<Integer> ordemPagamento = new ArrayList<>();
        double totalGasto = 0;

        // Adiciona os empréstimos à fila de prioridade (Heap)
        for (int i = 0; i < n; i++) {
            filaPrioridade.add(new Emprestimo(i, taxasJuros[i]));
        }

        // Calcula a ordem de pagamento e o valor total gasto
        for (int i = 1; i < n; i++) {
            Emprestimo emprestimo = filaPrioridade.poll();
            totalGasto += 1000 * Math.pow(emprestimo.taxaJuros, i);
            ordemPagamento.add(emprestimo.indice);
        }

        // Exibe a ordem de pagamento e o valor total gasto
        //System.out.println("Ordem de pagamento dos empréstimos: " + ordemPagamento);
        System.out.println("Valor total gasto: " + totalGasto);

        return ordemPagamento;
    }

    // Algoritmo que ordena os empréstimos usando Quick Sort
    public static List<Integer> ordemPagamentoEmprestimosQuickSort(double[] taxasJuros) {
        int n = taxasJuros.length;
        List<Emprestimo> emprestimos = new ArrayList<>();

        // Cria uma lista de empréstimos
        for (int i = 0; i < n; i++) {
            emprestimos.add(new Emprestimo(i, taxasJuros[i]));
        }

        // Ordena os empréstimos em ordem decrescente de taxa de juros usando Quick Sort
        Collections.sort(emprestimos, Comparator.comparingDouble(e -> -e.taxaJuros));

        // Calcula a ordem de pagamento e o valor total gasto
        List<Integer> ordemPagamento = new ArrayList<>();
        double totalGasto = 0;
        for (int i = 1; i < n; i++) {
            totalGasto += 1000 * Math.pow(emprestimos.get(i-1).taxaJuros, i);
            ordemPagamento.add(emprestimos.get(i-1).indice);
        }

        // Exibe a ordem de pagamento e o valor total gasto
       // System.out.println("Ordem de pagamento dos empréstimos: " + ordemPagamento);
        System.out.println("Valor total gasto: " + totalGasto);

        return ordemPagamento;
    }

    public static void main(String[] args) {
        // Recebe o tipo de algoritmo a ser usado (heap ou quick) e o número de casos de
        // teste
        int numCasosTeste = Integer.parseInt(args[1]);
        double[] taxasJuros = new double[numCasosTeste];

        System.out.println("Taxas de juros: ");
        for (int j = 0; j < numCasosTeste; j++) {
            // Gera taxas de juros aleatórias entre 1 e 2
            taxasJuros[j] = 1 + random.nextDouble();
        //    System.out.print(j + ": " + taxasJuros[j] + " \n");
        }

        System.out.println("\n------------------------------");
        System.out.println("Número de casos de teste: " + numCasosTeste);

        if (args[0].equals("heap")) {
            double start = System.currentTimeMillis();
            System.out.println("------------------------------");
            ordemPagamentoEmprestimosHeapSort(taxasJuros);
            System.out.println("Tempo de execução: " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("------------------------------");
        } else if (args[0].equals("quick")) {
            double start = System.currentTimeMillis();
            ordemPagamentoEmprestimosQuickSort(taxasJuros);
            System.out.println("Tempo de execução: " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("------------------------------");
        } else
            System.out.println("Algoritmo não encontrado");
    }
}
