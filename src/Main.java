import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Criar o inventário da farmácia
        Inventario inventario = new Inventario();

        // Criar alguns remédios
        Remedios dorflex = new Remedios("Dorflex", 15.0, LocalDate.of(2026, 6, 30));
        dorflex.adicionarMarcas("Sanofi");

        Remedios paracetamol = new Remedios("Paracetamol", 10.0, LocalDate.of(2025, 12, 31));
        paracetamol.adicionarMarcas("Neo Química");
        paracetamol.adicionarMarcas("EMS");

        Remedios ibuprofeno = new Remedios("Ibuprofeno", 12.5, LocalDate.of(2025, 10, 20));
        ibuprofeno.adicionarMarcas("Medley");

        // Adicionar ao inventário
        inventario.adicionarRemedios(dorflex, 50);
        inventario.adicionarRemedios(paracetamol, 80);
        inventario.adicionarRemedios(ibuprofeno, 60);

        // Criar funcionários: Gerente (Batman), Caixa (Homem-Aranha)
        Gerente gerente = new Gerente("Bruce Wayne", "Gerente", 10000.0, inventario);
        Caixa caixa = new Caixa("Peter Parker", "Caixa", 3000.0, inventario);

        // Criar clientes: Superman (registrado), Mulher-Maravilha (não registrada)
        Cliente superman = new Cliente("Clark Kent", "123.456.789-00", true);
        Cliente mulherMaravilha = new Cliente("Diana Prince", "987.654.321-00", false);

        // Caixa realiza uma venda com pequeno desconto para cliente registrado
        System.out.println("\nVENDA 1 - Caixa (Homem-Aranha) vendendo para Superman:");
        caixa.processarVendas(paracetamol, 3, superman, 3.0);

        // Gerente realiza uma venda com maior desconto
        System.out.println("\nVENDA 2 - Gerente (Batman) vendendo para Mulher-Maravilha:");
        gerente.processarVendas(ibuprofeno, 2, mulherMaravilha, 25.0);

        // Gerente aplica desconto direto a um produto
        System.out.println("\nDesconto direto aplicado por Gerente (Batman):");
        gerente.aplicarDesconto(dorflex, 10.0);

        // Venda após desconto aplicado ao produto
        System.out.println("\nVENDA 3 - Caixa vendendo Dorflex com preço já alterado:");
        caixa.processarVendas(dorflex, 5, superman, 2.0);

        // Listar histórico de vendas do cliente
        System.out.println("\nHistórico de compras do Superman:");
        for (String compra : superman.getHistoricoDeCompras()) {
            System.out.println("\n" + compra);
        }

        System.out.println("\nInventário atualizado:");
        inventario.listarEstoque();
    }
}
