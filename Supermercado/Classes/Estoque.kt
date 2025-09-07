package SuperMercado.Classes

class Estoque {
    private val itens = mutableListOf<ItemProduto>()

    fun entraItem(item: ItemProduto) {
        itens.add(item)
    }

    fun saiItem(item: ItemProduto): ItemProduto? {
        return if (itens.remove(item)) item else null
    }

    fun getItens(): List<ItemProduto> = itens
    fun getItens(marca: Marca): List<ItemProduto> = itens.filter { it.getProduto().getMarca() == marca }
    fun getItens(produto: Produto): List<ItemProduto> = itens.filter { it.getProduto() == produto }
    fun getItens(genero: Genero): List<ItemProduto> = itens.filter { it.getProduto().getGenero() == genero }

    fun qtdItens(): Int = itens.size


}
