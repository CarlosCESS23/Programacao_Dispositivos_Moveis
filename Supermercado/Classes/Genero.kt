package SuperMercado.Classes

abstract class Genero(val nome: String)

class Leite : Genero("Leite")
class Presunto : Genero("Presunto")
class Achocolatado : Genero("Achocolatado")


class Marca(private var nome: String) {
    fun getNome(): String = nome
    fun setNome(novoNome: String) {
        nome = novoNome
    }
}