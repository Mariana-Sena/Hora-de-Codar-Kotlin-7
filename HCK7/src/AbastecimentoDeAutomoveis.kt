import kotlin.system.exitProcess

fun abastecimentoDeAutomoveis() {
    val listaAutomoveis = mutableMapOf(
        "ABC-1234" to 10.0,
        "DEF-5678" to 25.5,
        "GHI-9012" to 40.0
    )

    while (true) {
        println("""Gestão de Abastecimento
        Selecione uma opção:
        1. Cadastrar Automóvel
        2. Abastecer
        3. Exibir Frota
        4. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarAutomovel(listaAutomoveis)
            2 -> abastecerAutomovel(listaAutomoveis)
            3 -> listarAutomoveis(listaAutomoveis)
            4 -> sairAbastecimento()
            else -> erroAbastecimento()
        }
    }
}

fun cadastrarAutomovel(listaAutomoveis: MutableMap<String, Double>) {
    println("Cadastro de Automóvel.\nInforme a placa do veículo:")
    val placa = readln()
    println("Informe a quantidade de combustível atual:")
    val combustivel = readln().toDoubleOrNull()

    if (combustivel != null) {
        listaAutomoveis[placa] = combustivel
        println("Automóvel de placa $placa cadastrado com $combustivel litros.")
    } else {
        println("Quantidade inválida.")
    }
}

fun abastecerAutomovel(listaAutomoveis: MutableMap<String, Double>) {
    println("Abastecimento de Automóveis.\nInforme a placa do veículo:")
    val placa = readln()

    if (listaAutomoveis.containsKey(placa)) {
        println("Informe a quantidade de litros a abastecer:")
        val litros = readln().toDoubleOrNull()

        if (litros != null) {
            listaAutomoveis[placa] = listaAutomoveis[placa]!! + litros
            println("Abastecimento concluído. O carro de placa $placa agora tem ${listaAutomoveis[placa]} litros.")
        } else {
            println("Quantidade inválida.")
        }
    } else {
        println("Carro não encontrado.")
    }
}

fun listarAutomoveis(listaAutomoveis: MutableMap<String, Double>) {
    if (listaAutomoveis.isEmpty()) {
        println("Nenhum automóvel registrado.")
    } else {
        println("Automóveis registrados:")
        listaAutomoveis.forEach { (placa, combustivel) -> println("Placa: $placa, Combustível: ${combustivel}L") }
    }
}

fun sairAbastecimento() {
    println("Deseja sair? S/N")
    val escolha = readln().uppercase()

    when (escolha) {
        "S" -> {
            println("Saindo do sistema de abastecimento.")
            exitProcess(0)
        }
        "N" -> {
            println("Voltando ao menu principal.")
            abastecimentoDeAutomoveis()
        }
        else -> {
            println("Opção inválida.")
            sairAbastecimento()
        }
    }
}

fun erroAbastecimento() {
    println("Por favor, informe um número entre 1 e 4.")
}

fun main() {
    abastecimentoDeAutomoveis()
}
