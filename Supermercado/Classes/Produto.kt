package SuperMercado.Classes


class Produto(
    private val codigo: Int,
    private var nome: String,
    private var preco: Float,
    private val marca: Marca,
    private val genero: Genero
) {
    fun getCodigo(): Int = codigo
    fun getNome(): String = nome
    fun setNome(novoNome: String) {
        nome = novoNome
    }

    fun getPreco(): Float = preco
    fun getMarca(): Marca = marca
    fun getGenero(): Genero = genero
}