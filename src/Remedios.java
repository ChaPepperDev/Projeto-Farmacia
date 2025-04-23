import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Remedios {
    private String nome;
    private double preco;
    private LocalDate validade;
    private List<String> marcas;

    public Remedios(String nome, double preco, LocalDate validade) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.marcas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return  preco;
    }
    public LocalDate getValidade() {
        return validade;
    }
    public List<String> getMarcas() {
        return marcas;
    }

    public void adicionarMarcas(String marcas) {
        if (!this.marcas.contains(marcas)) {
            this.marcas.add(marcas);
        }
    }

    public void aplicarDesconto(double percentual) {
        if (percentual > 0 && percentual <= 100) {
            preco -= preco * (percentual / 100);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }
}
