import kotlin.system.exitProcess

fun cadastrarQuartos() {
    val listaQuartos = mutableListOf(
        "101 - Solteiro - R$150,00",
        "102 - Casal - R$250,00",
        "103 - Família - R$400,00"
    )

    while (true) {
        println("""Cadastro de Quartos
        Selecione uma opção:
        1. Cadastrar
        2. Pesquisar
        3. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarNovoQuarto(listaQuartos)
            2 -> pesquisarQuarto(listaQuartos)
            3 -> sairCadastroDeQuartos()
            else -> erroCadastroDeQuartos()
        }
    }
}

fun cadastrarNovoQuarto(listaQuartos: MutableList<String>) {
    println("Cadastro de Quartos.\nInforme o número do quarto:")
    val numero = readln()
    println("Informe o tipo do quarto:")
    val tipo = readln()
    println("Informe o preço do quarto:")
    val preco = readln()

    val novoQuarto = "$numero - $tipo - R$$preco"
    listaQuartos.add(novoQuarto)

    println("Quarto $numero cadastrado com sucesso!")
    println("Lista de Quartos atuais: $listaQuartos")
}

fun pesquisarQuarto(listaQuartos: MutableList<String>) {
    println("Pesquisa de Quartos.\nInforme o número ou tipo do quarto:")
    val busca = readln()

    val encontrados = listaQuartos.filter { it.contains(busca, ignoreCase = true) }

    if (encontrados.isNotEmpty()) {
        println("\nQuartos encontrados:")
        encontrados.forEach { println(it) }
    } else {
        println("Nenhum quarto encontrado.")
    }
}

fun sairCadastroDeQuartos() {
    println("Deseja sair? S/N")
    val escolha = readln().uppercase()

    when (escolha) {
        "S" -> {
            println("Saindo do sistema de quartos.")
            exitProcess(0)
        }
        "N" -> {
            println("Voltando ao menu principal.")
            cadastrarQuartos()
        }
        else -> {
            println("Opção inválida.")
            sairCadastroDeQuartos()
        }
    }
}

fun erroCadastroDeQuartos() {
    println("Por favor, informe um número entre 1 e 3.")
}

fun main() {
    cadastrarQuartos()
}
