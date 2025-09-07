package SuperMercado.Util

import SuperMercado.Classes.*


class Utilidade {
    fun gerarItens(): List<ItemProduto> {
        // Marcas
        val nestle = Marca("Nestlé")
        val itambe = Marca("Itambé")
        val duleite = Marca("Duleite")
        val parm = Marca("Parmalat")
        val abf = Marca("ABF")
        val pepsico = Marca("Pepsico do Brasil")
        val bretzke = Marca("Bretzke")
        val perdigao = Marca("Perdigão")
        val sadia = Marca("Sadia")

        // Gêneros
        val leite = Leite()
        val achoco = Achocolatado()
        val presunto = Presunto()

        // Produtos
        val p1 = Produto(1, "Leite Ninho", 10.35f, nestle, leite)
        val p2 = Produto(2, "Molico", 11.50f, nestle, leite)
        val p3 = Produto(3, "Farinha Láctea", 9.75f, nestle, leite)
        val p4 = Produto(4, "Leite em Pó", 8.90f, itambe, leite)
        val p5 = Produto(5, "Leite em Caixa", 6.50f, duleite, leite)
        val p6 = Produto(6, "Leite Parmalat", 7.20f, parm, leite)

        val p7 = Produto(7, "Nescau", 12.50f, nestle, achoco)
        val p8 = Produto(8, "Ovomaltine", 15.00f, abf, achoco)
        val p9 = Produto(9, "Toddy", 13.00f, pepsico, achoco)
        val p10 = Produto(10, "Muky", 11.00f, bretzke, achoco)
        val p11 = Produto(11, "Chocolate em Pó", 14.50f, nestle, achoco)

        val p12 = Produto(12, "Presunto Delícia", 5.50f, perdigao, presunto)
        val p13 = Produto(13, "Presunto Salsichon", 7.50f, sadia, presunto)
        val p14 = Produto(14, "Presunto Fatiado", 6.20f, perdigao, presunto)

        // Itens (35 no total)
        return listOf(
            ItemProduto(101, p1, Data(11, 4, 2026)),
            ItemProduto(102, p1, Data(23, 9, 2023)), // vencido
            ItemProduto(103, p1, Data(1, 12, 2025)),
            ItemProduto(104, p2, Data(15, 7, 2026)),
            ItemProduto(105, p2, Data(1, 3, 2024)), // vencido
            ItemProduto(106, p3, Data(20, 10, 2025)),
            ItemProduto(107, p3, Data(30, 11, 2024)), // vencido
            ItemProduto(108, p4, Data(25, 12, 2025)),
            ItemProduto(109, p4, Data(5, 5, 2026)),
            ItemProduto(110, p5, Data(1, 1, 2026)),
            ItemProduto(111, p5, Data(8, 8, 2025)),
            ItemProduto(112, p6, Data(1, 9, 2024)), // vencido
            ItemProduto(113, p6, Data(12, 12, 2025)),

            ItemProduto(114, p7, Data(15, 10, 2025)),
            ItemProduto(115, p7, Data(20, 2, 2024)), // vencido
            ItemProduto(116, p8, Data(5, 3, 2026)),
            ItemProduto(117, p8, Data(11, 10, 2025)),
            ItemProduto(118, p8, Data(1, 11, 2024)), // vencido
            ItemProduto(119, p9, Data(20, 6, 2026)),
            ItemProduto(120, p9, Data(10, 1, 2025)),
            ItemProduto(121, p9, Data(2, 2, 2024)), // vencido
            ItemProduto(122, p10, Data(7, 7, 2026)),
            ItemProduto(123, p10, Data(3, 5, 2025)),
            ItemProduto(124, p11, Data(1, 12, 2026)),
            ItemProduto(125, p11, Data(4, 4, 2025)),

            ItemProduto(126, p12, Data(26, 11, 2025)),
            ItemProduto(127, p12, Data(1, 8, 2024)), // vencido
            ItemProduto(128, p12, Data(2, 2, 2026)),
            ItemProduto(129, p13, Data(23, 7, 2025)),
            ItemProduto(130, p13, Data(9, 9, 2026)),
            ItemProduto(131, p13, Data(15, 5, 2024)), // vencido
            ItemProduto(132, p14, Data(10, 10, 2025)),
            ItemProduto(133, p14, Data(1, 3, 2026)),
            ItemProduto(134, p14, Data(11, 11, 2024)), // vencido
            ItemProduto(135, p14, Data(1, 3, 2026)),
        )
    }

    fun lerString(prompt: String): String {
        print(prompt)
        return readlnOrNull() ?: ""
    }

    fun imprimirItemCompleto(item: ItemProduto) {
        val produto = item.getProduto()
        println(
            "${item.getCodigo()} | " +
                    "${produto.getNome()} | " +
                    "${produto.getGenero().nome} | " +   // <-- agora imprime o gênero
                    "${produto.getMarca().getNome()} | " +
                    "R$${"%.2f".format(produto.getPreco())} | " +
                    "${item.getValidade()} | " +
                    if (item.valido()) "sim" else "não"
        )
    }
}