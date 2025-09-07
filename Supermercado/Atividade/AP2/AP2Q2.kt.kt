package SuperMercado.Atividade.AP2

import SuperMercado.Classes.SupermercadoWeb


class AP2Q2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()

            println("###### ESTOQUE POR GÊNERO ######")
            println("CÓD | NOME | GENERO | MARCA | PREÇO | VALIDADE | VÁLIDO?")
            println("---")

            val itensPorGenero = estoque.getItens().groupBy { it.getProduto().getGenero().nome }

            var totalGeral = 0
            for ((genero, itens) in itensPorGenero) {
                println("\n-- $genero --")
                itens.forEach { util.imprimirItemCompleto(it) }
                println("TOTAL $genero: ${itens.size} itens\n")
                totalGeral += itens.size
            }

            println("TOTAL GERAL: $totalGeral itens")
        }
    }
}