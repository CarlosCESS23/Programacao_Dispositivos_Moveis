package SuperMercado.Classes

import SuperMercado.Util.Utilidade

class SupermercadoWeb {
    private val util = Utilidade()
    private val estoque = Estoque()
    private val carrinho = Carrinho()
    private val carrinhoA = Carrinho()
    private val carrinhoB = Carrinho()

    init {
        iniciaSupermercado()
    }

    private fun iniciaSupermercado() {
        // Aqui criaria os produtos, marcas e itens, e adicionaria ao estoque

        val itens = util.gerarItens()
        for (i in itens) {
            estoque.entraItem(i)
        }
    }

    fun getEstoque() = estoque
    fun getCarrinho() = carrinho
    fun getCarrinhoA() = carrinhoA
    fun getCarrinhoB() = carrinhoB
}