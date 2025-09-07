package SuperMercado.Atividade.AP2

import SuperMercado.Classes.SupermercadoWeb

class AP2Questao4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()

            // Contar itens válidos e vencidos
            val itensValidos = estoque.getItens().count { it.valido() }
            val itensVencidos = estoque.getItens().count { !it.valido() }
            val total = estoque.qtdItens()

            // Verificar se soma confere
            val soma = itensValidos + itensVencidos
            val confere = soma == total

            // Exibir resultados
            println("###### CONTAGEM DE ITENS ######")
            println("Itens válidos (não vencidos): $itensValidos")
            println("Itens vencidos: $itensVencidos")
            println("Total no estoque: $total")
            println("Soma (válidos + vencidos): $soma")
            println("Conferência: ${if (confere) "OK" else "ERRO "}")
        }
    }
}