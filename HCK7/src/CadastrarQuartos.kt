fun cadastrarQuartos() {
    val quartos = BooleanArray(20) { false }
    var dias:Int = 0
    var diaria:Double = 0.0


    print("Qual o valor padrão da diária? ")
        diaria = readln().toDouble()
        if (diaria < 0) {
            println("Valor inválido.")
        }

        print("Quantas diárias serão necessárias? ")
        dias = readln().toInt()
        if (dias == null || dias < 0 || dias > 30) {
            println("Valor inválido.")
        }

        val valorTotal = diaria * dias
        println("Total: R$$valorTotal")

        print("Nome do hóspede: ")
        val nomeHospede = readln()

        println("Número do quartos (1-20):")
    while (true) {
        // Exibe a lista de quartos e seus status
        println("Lista de quartos e suas ocupações:")
        for (i in quartos.indices) {
            val status = if (quartos[i]) "ocupado" else "livre"
            print("${i + 1} - $status; ")
        }
        println("\n")

        val quarto = readln().toIntOrNull()
        if (quarto == null || quarto !in 1..20 || quartos[quarto - 1]) {
            println("Quarto inválido ou ocupado.")
            continue
        }

        quartos[quarto - 1] = true
        println("Reserva confirmada para $nomeHospede, no quarto $quarto.")

        // Adiciona a opção de reservar mais um quarto
        print("Deseja reservar mais um quarto? (sim/não): ")
        val resposta = readln().lowercase()
        if (resposta == "sim") {
            cadastrarQuartos()
        }else{
            inicio()
        }
    }
}
