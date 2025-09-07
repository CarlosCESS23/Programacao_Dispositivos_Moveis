package SuperMercado.Atividade.AP3

import SuperMercado.Classes.SupermercadoWeb

class AFQuestao4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()
            val todosOsItens = estoque.getItens()

            //Aqui faz a soma de todos os preços dos produtos, antes de remover os produtos vencidos
            val lucroPotencial = todosOsItens.sumOf { it.getProduto().getPreco().toDouble() }
            println("--- Situação Inicial do Estoque ---")
            println("Total de itens no estoque: ${estoque.qtdItens()}")
            println("Lucro potencial com a venda de todos os itens: R$ %.2f\n".format(lucroPotencial))

            // Criando variavel item vencido para fazer: O total do prejuizo, e quanto no final fica
            val itensVencidos = todosOsItens.filter { !it.valido() }
            val prejuizo = itensVencidos.sumOf { it.getProduto().getPreco().toDouble() }
            itensVencidos.forEach { estoque.saiItem(it) }

            println("--- Remoção de Itens Vencidos ---")
            println("Itens vencidos jogados no lixo:")
            if (itensVencidos.isNotEmpty()) {
                itensVencidos.forEach { println("- ${it.getProduto().getNome()} (Código: ${it.getCodigo()})") }
            } else {
                println("- Nenhum item vencido encontrado.")
            }
            println("\nPrejuízo total com itens vencidos: R$ %.2f\n".format(prejuizo))

            // Aqui mostra o resumo final de pós-remoção dos estoques
            println("--- Situação Após a Remoção ---")
            println("Total de itens restantes no estoque: ${estoque.qtdItens()}")
            println("Itens restantes no estoque:")
            estoque.getItens().forEachIndexed { index, item ->
                println("${index + 1}. $item")
            }

            //Lucro final: LucroPotencial - prejuizo
            val lucroReal = lucroPotencial - prejuizo
            println("\n--- Lucro Final ---")
            println("Lucro potencial: R$ %.2f".format(lucroPotencial))
            println("Prejuízo com itens vencidos: R$ %.2f".format(prejuizo))
            println("Lucro real final: R$ %.2f".format(lucroReal))
        }
    }
}
