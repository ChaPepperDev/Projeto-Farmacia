import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<Remedios, Integer> estoque = new HashMap<>();

    public void adicionarRemedios(Remedios remedios, int quantidade) {
        estoque.put(remedios, estoque.getOrDefault(remedios, 0) + quantidade);
        System.out.println("Adicionado: " +quantidade + "x " + remedios.getNome());
    }

    public boolean verificarDisponibilidade(Remedios remedios, int quantidade) {
        return estoque.getOrDefault(remedios, 0) >= quantidade;
    }

    public void reduzirEstoque(Remedios remedios, int quantidade){
        if (verificarDisponibilidade (remedios, quantidade)) {
            estoque.put(remedios, estoque.get(remedios) - quantidade);
            System.out.println("Venda realizada: " + quantidade + "x " + remedios.getNome());
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }
    public void listarEstoque() {
        System.out.println("\n=== INVENTARIO ATUALIZADO ===");

        for (Map.Entry<Remedios, Integer> entry : estoque.entrySet()) {
            Remedios r = entry.getKey();
            int qtd = entry.getValue();
            System.out.println(r.getNome() + " | Preço: R$" + r.getPreco() + " | Validade: " + r.getValidade() + "| Quantidade: " + qtd);
        }

        System.out.println("==========================\n");
    }
}
