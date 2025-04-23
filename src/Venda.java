import java.util.List;

public class Venda {


    public static void processarVendas(Funcionario funcionario, Inventario inventario, Remedios remedios, int quantidade, Cliente cliente, double descontoExtra) {
        if (funcionario instanceof Gerente) {
            if (descontoExtra > 30.0) {
                System.out.println("Desconto não permitido para gerente, máximo de 30%.");
                return;
            }
        } else if (funcionario instanceof Caixa) {
            if (descontoExtra > 5.0) {
                System.out.println("Desconto não permitido para caixa, máximo de 5%.");
                return;
            }
        }


        if (inventario.verificarDisponibilidade(remedios, quantidade)) {

            double precoOriginal = remedios.getPreco();
            double precoComDesconto = precoOriginal * (1 - descontoExtra / 100);
            double total = precoComDesconto * quantidade;


            String recibo = emitirRecibo(remedios, quantidade, precoOriginal, precoComDesconto, total, cliente, descontoExtra);

            cliente.adicionarComprasAoHistorico(recibo);

            System.out.println("\n--- RECIBO DE VENDA ---");
            System.out.println(recibo);

            inventario.reduzirEstoque(remedios, quantidade);
        } else {
            System.out.println("Estoque insuficiente para completar a venda.");
        }
    }

    private static String emitirRecibo(Remedios remedios, int quantidade, double precoOriginal, double precoComDesconto, double total, Cliente cliente, double descontoExtra) {
        return "Cliente: " + cliente.getNome() +
                "\nCPF: " + cliente.getCpf() +
                "\nRegistrado: " + (cliente.isRegistrado() ? "Sim" : "Não") +
                "\nProduto: " + remedios.getNome() +
                "\nQuantidade: " + quantidade +
                "\nPreço original: R$" + String.format("%.2f", precoOriginal) +
                "\nDesconto aplicado: " + descontoExtra + "%" +
                "\nPreço final unitário: R$" + String.format("%.2f", precoComDesconto) +
                "\nValidade: " + remedios.getValidade() +
                "\nTotal da venda: R$" + String.format("%.2f", total);
    }
}
