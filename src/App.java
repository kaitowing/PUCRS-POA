import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

class Emprestimo {
    int indice;
    double taxaJuros;

    Emprestimo(int indice, double taxaJuros) {
        this.indice = indice;
        this.taxaJuros = taxaJuros;
    }
}

public class App {

    public static List<Integer> ordemPagamentoEmprestimosHeapSort(double[] taxasJuros) {
        int n = taxasJuros.length;
        PriorityQueue<Emprestimo> filaPrioridade = new PriorityQueue<>(Comparator.comparingDouble(e -> -e.taxaJuros));
        List<Integer> ordemPagamento = new ArrayList<>();
        double totalGasto = 0;

        for (int i = 0; i < n; i++) {
            filaPrioridade.add(new Emprestimo(i, taxasJuros[i]));
        }

        for (int i = 0; i < n; i++) {
            Emprestimo emprestimo = filaPrioridade.poll();
            totalGasto += 1000 * Math.pow(emprestimo.taxaJuros, i);
            ordemPagamento.add(emprestimo.indice);
        }

        System.out.println("Ordem de pagamento dos empréstimos: " + ordemPagamento);
        System.out.println("Valor total gasto: " + totalGasto);

        return ordemPagamento;
    }

    public static List<Integer> ordemPagamentoEmprestimosQuickSort(double[] taxasJuros) {
        int n = taxasJuros.length;
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            emprestimos.add(new Emprestimo(i, taxasJuros[i]));
        }

        Collections.sort(emprestimos, Comparator.comparingDouble(e -> -e.taxaJuros));

        List<Integer> ordemPagamento = new ArrayList<>();
        double totalGasto = 0;

        for (int i = 0; i < n; i++) {
            totalGasto += 1000 * Math.pow(emprestimos.get(i).taxaJuros, i);
            ordemPagamento.add(emprestimos.get(i).indice);
        }

        System.out.println("Ordem de pagamento dos empréstimos: " + ordemPagamento);
        System.out.println("Valor total gasto: " + totalGasto);

        return ordemPagamento;
    }

    private static Random random = new Random();

    public static void main(String[] args) {
            int numCasosTeste = Integer.parseInt(args[1]);
            double[] taxasJuros = new double[numCasosTeste];

            System.out.println("Taxas de juros: ");
            for (int j = 0; j < numCasosTeste; j++) {
                taxasJuros[j] = 1 + random.nextDouble();
                System.out.print(j + ": " + taxasJuros[j] + " \n");
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
