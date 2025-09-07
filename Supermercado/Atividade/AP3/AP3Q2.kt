package SuperMercado.Atividade.AP3

import SuperMercado.Classes.Data
import SuperMercado.Classes.SupermercadoWeb

class AFQuestao2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()

            // Aqui é a entrada de dados onde o usuário vai inserir
            val dia = lerInt("Digite o dia: ")
            val mes = lerInt("Digite o mês: ")
            val ano = lerInt("Digite o ano: ")

            val dataReferencia = Data(ano, mes, dia)


            // Impressão que mostra quais são itens que foram vencidos
            println("###### ITENS VENCIDOS ######")
            println("CÓD | NOME | GENERO | MARCA | PREÇO | VALIDADE | VÁLIDO?")
            println("---")

            val itensVencidos = estoque.getItens().filter { item ->
                val validade = item.getValidade()
                val resultado = validade.depois(dataReferencia)
                println("Item: ${item.getCodigo()} | Validade: $validade | DataRef: $dataReferencia | Venceu? $resultado")
                resultado
            }

            println("TOTAL: ${itensVencidos.size} itens.")
        }
    }
}
