fun abastecimentoDeAutomoveis() {
    println("\nQual o valor do álcool no posto Wayne Oil?")
    val alcWayne = readln().toDoubleOrNull() ?: return println("Valor inválido!")

    println("Qual o valor da gasolina no posto Wayne Oil?")
    val gasWayne = readln().toDoubleOrNull() ?: return println("Valor inválido!")

    println("Qual o valor do álcool no posto Stark Petrol?")
    val alcStark = readln().toDoubleOrNull() ?: return println("Valor inválido!")

    println("Qual o valor da gasolina no posto Stark Petrol?")
    val gasStark = readln().toDoubleOrNull() ?: return println("Valor inválido!")

    // Determinar se o álcool é mais vantajoso em cada posto
    val vantajosoWayne = alcWayne <= gasWayne * 0.7
    val vantajosoStark = alcStark <= gasStark * 0.7

    // Calculo do custo de abastecimento de 42 litros em cada situação
    val custoWayne = if (vantajosoWayne) alcWayne * 42 else gasWayne * 42
    val custoStark = if (vantajosoStark) alcStark * 42 else gasStark * 42

    val postoMaisBarato = if (custoWayne < custoStark) "Wayne Oil" else "Stark Petrol"
    val combustivelMaisBarato = if (postoMaisBarato == "Wayne Oil") {
        if (vantajosoWayne) "álcool" else "gasolina"
    } else {
        if (vantajosoStark) "álcool" else "gasolina"
    }

    println("${nome}, é mais barato abastecer com $combustivelMaisBarato no posto $postoMaisBarato.")
}
