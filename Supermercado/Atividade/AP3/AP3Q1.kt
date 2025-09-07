package SuperMercado.Atividade.AP3

import SuperMercado.Classes.SupermercadoWeb
import SuperMercado.Util.Utilidade

val util = Utilidade()

class AFQuestao1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()

            // Entrada do usuário

            // Identificar o gênero (não pode instanciar Genero diretamente)
            val nomeGenero = util.lerString("Digite o nome do gênero desejado: ")

            val itensGenero = estoque.getItens().filter {
                it.getProduto().getGenero().nome.equals(nomeGenero, ignoreCase = true)
            }


            // Buscar itens pelo gênero


            // Impressão no formato pedido

            itensGenero.forEach { util.imprimirItemCompleto(it) }

            // Total
            println("TOTAL: ${itensGenero.size} itens.")
        }
    }
}

fun lerInt(prompt: String): Int {
    while (true) {
        print(prompt)

        val entrada = readlnOrNull()

        val valor = entrada?.toIntOrNull()
        if (valor != null) {
            return valor
        }
        println("Entrada inválida. Por favor, digite um número.")
    }
}
