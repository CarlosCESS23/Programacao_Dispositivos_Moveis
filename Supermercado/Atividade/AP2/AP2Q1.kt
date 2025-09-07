package SuperMercado.Atividade.AP2

import SuperMercado.Classes.SupermercadoWeb
import SuperMercado.Util.Utilidade

internal val util = Utilidade()

class AP2Q1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()

            println("###### ESTOQUE ######")
            println("CÓD | NOME | GENERO | MARCA | PREÇO | VALIDADE | VÁLIDO?")
            println("---")

            estoque.getItens().forEach { item -> util.imprimirItemCompleto(item) }


            println("TOTAL: ${estoque.qtdItens()} itens.")
        }
    }
}