import java.util.ArrayList;
import java.util.List;

public class Venda {
    private static List<String> historicoVendas = new ArrayList<>();

    public static void processarVendas(Funcionario funcionario, Inventario inventario, Remedios remedios, int quantidade, Cliente cliente, double descontoFuncionario) {
        double limiteDesconto = funcionario instanceof Gerente ? 30.0 : 5.0;

        if (descontoFuncionario > limiteDesconto) {
            System.out.println("Desconto não autorizado para este funcionário.");
            return;
        }

        if (!inventario.verificarDisponibilidade(remedios, quantidade)) {
            System.out.println("PRODUTO INDISPONIVEL OU QUANTIDADE INSUFICIENTE.");
            return;
        }

        double descontoCliente = cliente.obterDescontoCliente();
        double precoOriginal = remedios.getPreco();
        double precoComDesconto = precoOriginal * (1 - (descontoCliente + descontoFuncionario) / 100.0);
        double total = precoComDesconto * quantidade;

        String recibo = gerarRecibo(funcionario, remedios, quantidade, precoOriginal, precoComDesconto, total, cliente, descontoCliente, descontoFuncionario);
        historicoVendas.add(recibo);
        cliente.adicionarComprasAoHistorico(recibo);
        inventario.reduzirEstoque(remedios, quantidade);

        System.out.println("\n--- RECIBO ---");
        System.out.println(recibo);
    }

    private static String gerarRecibo(Funcionario funcionario, Remedios remedios, int quantidade, double precoOriginal,
                                      double precoComDesconto, double total, Cliente cliente,
                                      double descontoCliente, double descontoFuncionario) {
        return "Funcionário: " + funcionario.getNome() +
                "\nCliente: " + cliente.getNome() +
                "\nCPF: " + cliente.getCpf() +
                "\nRegistrado: " + (cliente.isRegistrado() ? "SIM" : "NÃO") +
                "\nProduto: " + remedios.getNome() +
                "\nQuantidade" + quantidade +
                "\nPreço Original: R$" + String.format("%.2f", precoOriginal) +
                "\nDesconto cliente: " + descontoCliente + "%" +
                "\nDesconto funcionário: " + descontoFuncionario + "%" +
                "\nPreço final unitário: R$" + String.format("%.2f", precoComDesconto) +
                "\nValidade: " + remedios.getValidade() +
                "\nTotal da venda: R$" + String.format("%.2f", total);
    }

    public static void listarTodasAsVendas() {
        System.out.println("\n=== HISTORICO DE TODAS AS VENDAS ===");
        for (String v : historicoVendas) {
            System.out.println("\n" + v);
        }
    }
}
