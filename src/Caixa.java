import java.util.ArrayList;
import java.util.List;

public class Caixa extends Funcionario {
    private List<String> vendas = new ArrayList<>();

    public Caixa(String nome, String cargo, double salario) {

        super(nome, cargo, salario);
    }

    public void processarVenda(Inventario inventario, Remedios remedios, int quantidade, Cliente cliente, double descontoGerenteOuCaixa) {
       if (descontoGerenteOuCaixa > 5.0) {
           System.out.println("Desconto não permitido.");
           return;
       }

       realizarVenda(inventario, remedios, quantidade, cliente, descontoGerenteOuCaixa);
    }

    protected void realizarVenda(Inventario inventario, Remedios remedios, int quantidade, Cliente cliente, double descontoExtra) {
        if (inventario.verificarDisponibilidade(remedios, quantidade)) {
            double descontoCliente = cliente.obterDescontoCliente();
            double precoOriginal = remedios.getPreco();
            double precoComDesconto = precoOriginal * (1 - (descontoCliente + descontoExtra) / 100.0);
            double total = precoComDesconto * quantidade;

            String recibo = emitirRecibo(remedios, quantidade, precoOriginal, precoComDesconto, total, cliente, descontoCliente, descontoExtra);
            vendas.add(recibo);
            cliente.adicionarComprasAoHistorico(recibo);

            System.out.println("\n ---RECIBO---");
            System.out.println(recibo);

            inventario.reduzirEstoque(remedios, quantidade);
        } else {
            System.out.println("PRODUTO INDISPONIVEL OU QUANTIDADE INSUFICIENTE.");
        }
    }

    protected String emitirRecibo(Remedios remedios, int quantidade, double precoOriginal, double precoComDesconto, double total,
                                  Cliente cliente, double descontoCliente, double descontoExtra) {
        return "Cliente: " + cliente.getNome() +
                "\nCPF: " + cliente.getCpf() +
                "\nRegistrado: " + (cliente.isRegistrado() ? "Sim" : "Não") +
                "\nProduto: " + remedios.getNome() +
                "\nQuantidade: " + quantidade +
                "\nPreço original: R$" + String.format("%.2f", precoOriginal) +
                "\nDesconto cliente: " + descontoCliente + "%" +
                "\nDesconto aplicado pelo funcionário: " + descontoExtra + "%" +
                "\nPreço final unitário: R$" + String.format("%.2f", precoComDesconto) +
                "\nValidade: " + remedios.getValidade() +
                "\nTotal da venda: R$" + String.format("%.2f", total);
    }

    public void listarVendas() {
        System.out.println("\n=== HISTÓRICO DE VENDAS ===");
        for (String v : vendas) {
            System.out.println("\n" + v);
        }
    }
}
