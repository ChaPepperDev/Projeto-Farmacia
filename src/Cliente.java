import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private boolean registrado;
    private List<String> historicoDeCompras;

    public Cliente(String nome, String cpf, boolean registrado) {
        this.nome = nome;
        this.cpf = cpf;
        this.registrado = registrado;
        this.historicoDeCompras = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void adicionarComprasAoHistorico(String recibo) {
        historicoDeCompras.add(recibo);
    }

    public void exibirHistorico() {
        System.out.println("\n=== HISTORICO DE COMPRAS DE " + nome + " ===");
        if (historicoDeCompras.isEmpty()) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            for(String compra : historicoDeCompras) {
                System.out.println("\n" + compra);
            }
        }
    }

    public double obterDescontoCliente() {
        return registrado ? 5.0 : 0.0; // desconto de 5%
    }

    public List<String> getHistoricoDeCompras() {
        return historicoDeCompras;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
