package SuperMercado.Classes


class ItemProduto(
    private val codigo: Int,
    private val produto: Produto,
    private val validade: Data
) {
    fun getCodigo(): Int = codigo
    fun getProduto(): Produto = produto
    fun getValidade(): Data = validade

    fun valido(): Boolean = validade.depois(Data.dataHoje())

    override fun toString(): String {
        return "$codigo ${produto.getNome()} ${produto.getGenero().nome} ${produto.getMarca().getNome()} " +
                "R$${"%.2f".format(produto.getPreco())} $validade ${if (valido()) "sim" else "não"}"
    }
}

