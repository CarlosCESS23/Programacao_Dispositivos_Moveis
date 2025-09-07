package SuperMercado.Atividade.AP3

import SuperMercado.Classes.SupermercadoWeb

class AFQuestao3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val todosOsItens = estoque.getItens()

            // Aqui agrupa os itens por gênero (Leite, Achocolatado e Presunto)
            val itensPorGenero = todosOsItens.groupBy { it.getProduto().getGenero().nome }

            println("--- Produtos Mais Baratos por Gênero ---")

            itensPorGenero.forEach { (genero, itens) ->
                // Aqui ele procura item por item, procurando qual é o item mais barato
                val itemMaisBarato = itens.minByOrNull { it.getProduto().getPreco() }

                // Mostrando no final quais são item mais barato para cada gênero
                if (itemMaisBarato != null) {
                    println("\n## Gênero: $genero")
                    println("Produto mais barato: ${itemMaisBarato.getProduto().getNome()}")
                    println("Preço: R$ %.2f".format(itemMaisBarato.getProduto().getPreco()))
                }
            }
        }
    }
}
