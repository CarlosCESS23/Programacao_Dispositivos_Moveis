package SuperMercado.Atividade.AP2

import SuperMercado.Classes.SupermercadoWeb
import kotlin.random.Random

class AP2Questao6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val carrinho = supermercado.getCarrinho()
            val itensValidos = estoque.getItens().filter { it.valido() }

            println("Itens válidos disponíveis no estoque: ${itensValidos.size}\n")

            val numItensParaAdicionar = Random.nextInt(1, itensValidos.size + 1)
            val itensParaAdicionar = itensValidos.shuffled().take(numItensParaAdicionar)

            println("Adicionando ${itensParaAdicionar.size} itens aleatórios válidos ao carrinho:\n")
            itensParaAdicionar.forEach { item ->
                carrinho.adicionaItem(item, estoque)
                println("- ${item.getProduto().getNome()} (Código: ${item.getCodigo()})")
            }

            println("\n--- Resumo da Compra ---")

            println("## Itens no Carrinho de Compras (${carrinho.getItens().size} itens):")
            carrinho.getItens().forEachIndexed { index, item ->
                println("${index + 1}. $item")
            }

            println("\n## Itens Restantes no Estoque (${estoque.qtdItens()} itens):")
            estoque.getItens().forEachIndexed { index, item ->
                println("${index + 1}. $item")
            }
        }
    }
}