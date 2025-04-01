fun cadastrarQuartos() {
    val quartos = BooleanArray(20) { false }
    var dias: Int
    var diaria: Double

    while (true) {
        print("\nQual o valor padrão da diária? ")
        diaria = readln().toDouble()
        if (diaria >= 0) break
        println("Valor inválido. Por favor, insira um valor positivo.")
    }

    while (true) {
        print("Quantas diárias serão necessárias? ")
        dias = readln().toInt()
        if (dias in 1..30) break
        println("Valor inválido. Por favor, insira um número entre 1 e 30.")
    }

    val valorTotal = diaria * dias
    println("Total: R$$valorTotal")

    print("Nome do hóspede: ")
    val nomeHospede = readln()

    while (true) {
        // Exibe a lista de quartos e seus status
        println("Lista de quartos e suas ocupações:")
        for (i in quartos.indices) {
            val status = if (quartos[i]) "ocupado" else "livre"
            println("${i + 1} - $status")
        // como os indices dos elementos de um array iniciam a contagem a partir do 0, para que a numeração dos quartos fique correta, é necessário somar 1
        }

        // Solicita e valida o número do quarto
        println("Número do quarto desejado (1-20):")
        val quarto = readln().toIntOrNull()

        if (quarto == null || quarto !in 1..20 || quartos[quarto - 1]) {
            println("Quarto inválido ou já ocupado.")
            continue
        }

        // Marca o quarto como ocupado
        quartos[quarto - 1] = true
        println("Reserva confirmada para $nomeHospede, no quarto $quarto.")

        // Pergunta se deseja realizar outra reserva
        print("Deseja efetuar outra reserva? (S/N): ")
        val resposta = readln()
        if (resposta == "S" || resposta == "s") {
            cadastrarQuartos()
        }else if(resposta == "N" || resposta == "n"){
            println("Obrigado! Até a próxima.")
            inicio()
        }else{
            println("Por favor, insira uma opção válida.")
        }
    }
}
