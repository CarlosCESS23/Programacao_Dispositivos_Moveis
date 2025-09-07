package SuperMercado.Atividade.AP2

import SuperMercado.Classes.SupermercadoWeb

class AP2Questao5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()
            val carrinho = spw.getCarrinho()

            val itensEstoque = estoque.getItens().toList()

            for (item in itensEstoque) {
                if (item.getCodigo() % 2 != 0) {
                    carrinho.adicionaItem(item, estoque)
                }
            }

            println("###### CARRINHO ######")
            println("CÓD | NOME | MARCA | PREÇO | VALIDADE | VÁLIDO?")
            println("---")
            carrinho.getItens().forEach { util.imprimirItemCompleto(it) }
            println("TOTAL DE ITENS NO CARRINHO: ${carrinho.getItens().size}")
            println("TOTAL A PAGAR: R$${"%.2f".format(carrinho.totalAPagar())}\n")

            println("###### ESTOQUE RESTANTE ######")
            println("CÓD | NOME | MARCA | PREÇO | VALIDADE | VÁLIDO?")
            println("---")
            estoque.getItens().forEach { util.imprimirItemCompleto(it) }
            println("TOTAL DE ITENS NO ESTOQUE: ${estoque.qtdItens()}")
        }
    }
}
