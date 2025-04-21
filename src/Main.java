import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // === PRODUTOS ===
        Remedios dipirona = new Remedios("Dipirona", 6.50, LocalDate.of(2025, 5, 10));
        Remedios buscopan = new Remedios("Buscopan", 20.00, LocalDate.of(2026, 1, 1));
        Remedios neosoro = new Remedios("Neosoro", 15.00, LocalDate.of(2025, 8, 25));

        // === INVENTÁRIO ===
        Inventario inventario = new Inventario();
        inventario.adicionarRemedios(dipirona, 30);
        inventario.adicionarRemedios(buscopan, 50);
        inventario.adicionarRemedios(neosoro, 40);

        // === FUNCIONÁRIOS ===
        Caixa caixa = new Caixa("Superman", "Caixa", 3000.00);
        Gerente gerente = new Gerente("Caçador de Marte", "Gerente", 9000.00);

        // === CLIENTES ===
        Cliente cliente1 = new Cliente("Batman", "12345678900", true); // registrado e CPF válido
        Cliente cliente2 = new Cliente("Pato Donald", "1251235486", false);    // não registrado
        Cliente cliente3 = new Cliente("Clodovil", "7512399854226", true); // registrado e válido

        // === TESTES DE VENDA ===
        System.out.println("\n[VENDA 1] Caixa tenta aplicar 6% → falha");
        caixa.processarVenda(inventario, dipirona, 2, cliente1, 6.0);

        System.out.println("\n[VENDA 2] Caixa aplica 5% → sucesso");
        caixa.processarVenda(inventario, dipirona, 2, cliente1, 5.0);

        System.out.println("\n[VENDA 3] Gerente aplica 25% → sucesso");
        gerente.processarVenda(inventario, buscopan, 3, cliente2, 25.0);

        System.out.println("\n[VENDA 4] Gerente tenta aplicar 35% → falha");
        gerente.processarVenda(inventario, neosoro, 1, cliente3, 35.0);

        System.out.println("\n[VENDA 5] Gerente aplica 10% para cliente registrado");
        gerente.processarVenda(inventario, neosoro, 2, cliente3, 10.0);

        // === HISTÓRICO DE COMPRAS DOS CLIENTES ===
        System.out.println("\n=== HISTÓRICO DE COMPRAS DE CLIENTES ===");
        cliente1.exibirHistorico();
        cliente2.exibirHistorico();
        cliente3.exibirHistorico();

        // === ESTOQUE ATUAL ===
        System.out.println("\n=== ESTOQUE FINAL ===");
        inventario.listarEstoque();
    }
}
