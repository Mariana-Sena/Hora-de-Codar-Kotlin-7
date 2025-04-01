fun hospedagens() {
    var opcao: Int

    do {
        println("\nSelecione uma opção:\n 1. Cadastrar Hóspedes\n 2. Pesquisar\n 3. Listar\n 4. Voltar ao início")
        opcao = readln().toIntOrNull() ?: 0

        when (opcao) {
            1 -> cadastrarHospedes()
            2 -> pesquisarHospede()
            3 -> listarHospedes()
            4 -> inicio()
            else -> println("Opção inválida, tente novamente.")
        }
    } while (opcao != 4)
}

val hospedes = mutableListOf<String>()

fun cadastrarHospedes(){
    println("\nQual o valor padrão da diária?")
    val diaria = readln().toDoubleOrNull() ?: return

    var gratuidade = 0
    var meias = 0
    var total = 0.0

    while (true) {
        println("\nQual o nome do Hóspede?")
        val nome = readln()
        if (nome == "PARE") break

        hospedes.add(nome) // Adiciona o nome à lista de hóspedes

        println("\nQual a idade do Hóspede?")
        val idade = readln().toIntOrNull() ?: continue

        print("$nome cadastrada(o) com sucesso.\n")

        if (idade < 6) {
            println("$nome possui gratuidade.")
            gratuidade++
        } else if (idade > 60) {
            println("$nome paga meia.")
            meias++
            total += diaria / 2
        } else {
            total += diaria
        }
    }
    println("\n${nome}, o valor total das hospedagens é: ${total}, ${gratuidade} gratuidade(s); ${meias} meia(s).\n")
}

fun pesquisarHospede() {
    println("Qual o nome do Hóspede?")
    val nome = readln()
    if (hospedes.contains(nome)) { //verifica se na lista hospede contém o nome inserido
        println("\nHóspede $nome foi encontrada(o)!")
    } else {
        println("\nHóspede $nome não foi encontrada(o)!")
    }
}

fun listarHospedes() {
    if (hospedes.isEmpty()) {
        println("\nNenhum hóspede cadastrado.")
    } else {
        println("\nLista de hóspedes:")
        hospedes.forEach { println(it) }
    }
}
