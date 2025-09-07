package SuperMercado.Atividade.AP3


import SuperMercado.Classes.SupermercadoWeb

class AFQuestao5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()
            val carrinho = spw.getCarrinho()

            // Mostrando a quantidade que tem no estoque
            fun mostrarEstoque(titulo: String) {
                println("###### $titulo ######")
                println("CÓD | NOME | MARCA | PREÇO | VALIDADE | VÁLIDO?")
                println("---")
                estoque.getItens().forEach { util.imprimirItemCompleto(it) }
                println("TOTAL DE ITENS NO ESTOQUE: ${estoque.qtdItens()}\n")
            }

            //Carrinho, que está vazio
            fun mostrarCarrinho(titulo: String) {
                println("###### $titulo ######")
                if (carrinho.getItens().isEmpty()) {
                    println("CARRINHO VAZIO\n")
                } else {
                    println("CÓD | NOME | MARCA | PREÇO | VALIDADE | VÁLIDO?")
                    println("---")
                    carrinho.getItens().forEach { util.imprimirItemCompleto(it) }
                    println("TOTAL DE ITENS NO CARRINHO: ${carrinho.getItens().size}")
                    println("TOTAL A PAGAR: R$${"%.2f".format(carrinho.totalAPagar())}\n")
                }
            }

            mostrarEstoque("ESTOQUE INICIAL")
            mostrarCarrinho("CARRINHO (vazio)")

            // Adição dos produtos que estão no estoque para este carrinho
            val itensAleatorios = estoque.getItens().shuffled().take(10)
            for (item in itensAleatorios) {
                carrinho.adicionaItem(item, estoque)
            }

            //
            mostrarEstoque("ESTOQUE APÓS RETIRADA")
            mostrarCarrinho("CARRINHO COM 10 ITENS")

            // Removendo os itens no carrinho
            val aux = carrinho.getItens().toList()
            for (item in aux) {
                carrinho.removeItem(item, estoque)
            }


            mostrarEstoque("ESTOQUE FINAL")
            mostrarCarrinho("CARRINHO VAZIO (FINAL)")
        }
    }
}
