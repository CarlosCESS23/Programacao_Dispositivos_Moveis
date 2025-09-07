package SuperMercado.Classes


class Carrinho {
    private val itens = mutableListOf<ItemProduto>()

    fun adicionaItem(item: ItemProduto, estoque: Estoque) {
        val removido = estoque.saiItem(item)
        if (removido != null) itens.add(removido)
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itens.remove(item)) estoque.entraItem(item)
    }

    fun totalAPagar(): Double = itens.sumOf { it.getProduto().getPreco().toDouble() }
    fun getItens(): List<ItemProduto> = itens
}

