public class Gerente extends Caixa {
    public Gerente(String nome, String cargo, double salario) {
        super(nome, cargo, salario);
    }

    @Override
    public void processarVenda(Inventario inventario, Remedios remedios, int quantidade, Cliente cliente, double descontoGerenteOuCaixa) {
        if (descontoGerenteOuCaixa > 30.0) {
            System.out.println("GERENTE NÃO PODE APLIACAR MAIS DE 30% DE DESCONTO.");
            return;
        }

        realizarVenda(inventario, remedios, quantidade, cliente, descontoGerenteOuCaixa);
    }

    public void aplicarDesconto(Remedios remedios, double percentual) {
        remedios.aplicarDesconto(percentual);
        System.out.println("Desconto de " + percentual + "% aplicado ao remedio: " + remedios.getNome());
    }

}


