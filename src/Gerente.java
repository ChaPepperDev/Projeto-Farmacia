public class Gerente extends Caixa {
    public Gerente(String nome, String cargo, double salario, Inventario inventario) {
        super(nome, cargo, salario, inventario);
    }

    @Override
    public void processarVendas(Remedios remedios, int quantidade, Cliente cliente, double descontoGerenteOuCaixa) {
        if (descontoGerenteOuCaixa > 30.0) {
            System.out.println("GERENTE NÃO PODE APLIACAR MAIS DE 30% DE DESCONTO.");
            return;
        }

        Venda.processarVendas(this, inventario, remedios, quantidade, cliente, descontoGerenteOuCaixa);
    }

    public void aplicarDesconto(Remedios remedios, double percentual) {
        remedios.aplicarDesconto(percentual);
        System.out.println("Desconto de " + percentual + "% aplicado ao remedio: " + remedios.getNome());
    }

}


