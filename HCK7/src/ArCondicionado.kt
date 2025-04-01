fun arCondicionado() {
    var continuar = true
    var primeiroOrcamento = true
    var menorValor = 0.0
    var empresaMenorValor = ""

    while (continuar) {
        println("\nQual o nome da empresa?")
        val nomeEmpresa = readln()

        println("Qual o valor por aparelho?")
        val valorAparelho = readln().toDoubleOrNull() ?: 0.0

        println("Qual a quantidade de aparelhos?")
        val quantidadeAparelhos = readln().toIntOrNull() ?: 0

        println("Qual a porcentagem de desconto?")
        val percentualDesconto = readln().toDoubleOrNull() ?: 0.0

        println("Qual o número mínimo de aparelhos para conseguir o desconto?")
        val minimoAparelhos = readln().toIntOrNull() ?: 0

        var valorTotal = valorAparelho * quantidadeAparelhos
        if (quantidadeAparelhos >= minimoAparelhos) {
            val desconto = valorTotal * (percentualDesconto / 100)
            valorTotal -= desconto
        }

        println("O serviço da $nomeEmpresa custará R$ $valorTotal")

        if (primeiroOrcamento || valorTotal < menorValor) {
            menorValor = valorTotal
            empresaMenorValor = nomeEmpresa
            primeiroOrcamento = false
        }

        println("\nDeseja informar novos dados, $nome? (S/N)")
        val resposta = readln().uppercase()
        if (resposta == "N") continuar = false
    }

    println("O orçamento de menor valor é o da $empresaMenorValor, por R$ $menorValor")
}
