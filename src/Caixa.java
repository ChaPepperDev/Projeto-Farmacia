public class Caixa extends Funcionario {

    public Caixa(String nome, String cargo, double salario, Inventario inventario) {
        super(nome, cargo, salario, inventario);
    }

    public void processarVendas(Remedios remedios, int quantidade, Cliente cliente, double descontoFuncionario) {
        Venda.processarVendas(this, getInventario(), remedios, quantidade, cliente, descontoFuncionario);
    }
}
