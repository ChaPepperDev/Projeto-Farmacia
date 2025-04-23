public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    protected Inventario inventario;

    public Funcionario(String nome, String cargo, double salario, Inventario inventario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.inventario = inventario;
    }

    public  String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public Inventario getInventario() { return inventario; }

    @Override
    public String toString() {
        return super.toString();
    }
}
