package SuperMercado.Atividade.AP2

import SuperMercado.Classes.ItemProduto
import SuperMercado.Classes.SupermercadoWeb

class AP2Questao3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val spw = SupermercadoWeb()
            val estoque = spw.getEstoque()

            println("###### ESTOQUE POR GÊNERO E NOME ######")
            println("CÓD  NOME                GENERO         MARCA           PREÇO     VALIDADE    VÁLIDO?")
            println("---  ------------------  -------------  --------------  -------   ----------  -------")

            val itensValidos = estoque.getItens().filter { it.valido() }

            val itensOrdenados = itensValidos.sortedWith(
                compareBy<ItemProduto> { it.getProduto().getGenero().nome }
                    .thenBy { it.getProduto().getNome() }
            )

            var total = 0
            for (item in itensOrdenados) {
                val produto = item.getProduto()
                println(
                    "%-4d %-18s %-13s %-14s R$%-7.2f %-10s %-7s".format(
                        item.getCodigo(),
                        produto.getNome(),
                        produto.getGenero().nome,
                        produto.getMarca().getNome(),
                        produto.getPreco(),
                        item.getValidade(),
                        if (item.valido()) "sim" else "não"
                    )
                )
                total++
            }

            println("\nTOTAL: $total itens.")
        }
    }
}