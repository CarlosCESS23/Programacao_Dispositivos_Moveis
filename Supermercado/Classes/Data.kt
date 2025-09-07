package SuperMercado.Classes

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {

    fun getDia(): Int = dia
    fun getMes(): Int = mes
    fun getAno(): Int = ano

    fun setData(d: Int, m: Int, a: Int) {
        dia = d; mes = m; ano = a
    }

    fun antes(data: Data): Boolean =
        (ano < data.ano) || (ano == data.ano && mes < data.mes) || (ano == data.ano && mes == data.mes && dia < data.dia)

    fun depois(data: Data): Boolean = data.antes(this)

    fun igual(data: Data): Boolean = (dia == data.dia && mes == data.mes && ano == data.ano)

    override fun toString(): String = "%02d/%02d/%04d".format(dia, mes, ano)

    companion object {
        fun dataHoje(): Data {
            val hoje = java.time.LocalDate.now()
            return Data(hoje.dayOfMonth, hoje.monthValue, hoje.year)
        }
    }
}