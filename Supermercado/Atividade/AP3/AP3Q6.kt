package SuperMercado.Atividade.AP3

import SuperMercado.Classes.SupermercadoWeb

class AFQuestao6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()
            val estoque = supermercado.getEstoque()
            val carrinhoA = supermercado.getCarrinhoA()
            val carrinhoB = supermercado.getCarrinhoB()

            val itensValidos = estoque.getItens().filter { it.valido() }.toList()
            itensValidos.forEach { item ->
                carrinhoA.adicionaItem(item, estoque)
            }

            val itensInvalidos = estoque.getItens().filter { !it.valido() }.toList()
            itensInvalidos.forEach { item ->
                carrinhoB.adicionaItem(item, estoque)
            }


            println("--- Situação do Estoque ---")
            if (estoque.qtdItens() > 0) {
                println("Total de itens no estoque: ${estoque.qtdItens()}")
                estoque.getItens().forEach { println(it) }
            } else {
                println("O estoque está vazio.")
            }

            println("\n--- Conteúdo do Carrinho A (Itens Válidos) ---")
            if (carrinhoA.getItens().isNotEmpty()) {
                println("Total de itens no carrinho A: ${carrinhoA.getItens().size}")
                carrinhoA.getItens().forEach { println(it) }
                println("Total a pagar no carrinho A: R$ %.2f".format(carrinhoA.totalAPagar()))
            } else {
                println("O carrinho A está vazio.")
            }


            println("\n--- Conteúdo do Carrinho B (Itens Inválidos) ---")
            if (carrinhoB.getItens().isNotEmpty()) {
                println("Total de itens no carrinho B: ${carrinhoB.getItens().size}")
                carrinhoB.getItens().forEach { println(it) }
                println("Total a pagar no carrinho B: R$ %.2f".format(carrinhoB.totalAPagar()))
            } else {
                println("O carrinho B está vazio.")
            }
        }
    }
}