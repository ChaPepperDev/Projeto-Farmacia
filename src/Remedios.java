import java.time.LocalDate;

public class Remedios {
    private String nome;
    private double preco;
    private LocalDate validade;

    public Remedios(String nome, double preco, LocalDate validade) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
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
