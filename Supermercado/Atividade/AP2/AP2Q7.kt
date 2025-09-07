package SuperMercado.Atividade.AP2

import SuperMercado.Classes.Marca
import SuperMercado.Classes.SupermercadoWeb


class AP2Questao7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()

            val entrada = util.lerString("Digite o nome da marca para busca:")

            if (entrada.isEmpty()) {
                println("Nenhuma marca informada. Encerrando.")
                return
            }

            val marcaBuscada = Marca(entrada)

            val itensMarca = estoque.getItens().filter {
                it.getProduto().getMarca().getNome().equals(marcaBuscada.getNome(), ignoreCase = true)
                        && it.valido()
            }

            println("\n###### ITENS VÁLIDOS DA MARCA '${entrada}' ######")
            if (itensMarca.isEmpty()) {
                println("Nenhum item válido encontrado para a marca '${entrada}'.")
            } else {
                println("CÓD | NOME | MARCA | PREÇO | VALIDADE | VÁLIDO?")
                println("---")
                itensMarca.forEach { util.imprimirItemCompleto(it) }
                println("TOTAL ENCONTRADO: ${itensMarca.size} itens")
            }
        }
    }
}