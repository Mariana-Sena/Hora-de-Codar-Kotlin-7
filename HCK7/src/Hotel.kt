var nomeHotel = "Maison Royale"
var senhaCorreta = 2678
var nome:String = ""

fun main() {
    print("Bem vindo ao Hotel $nomeHotel!\n\n")
    print("Por favor, informe seu nome: ")
    nome = readln()

    verificarSenha()
    println("==============================================")
    inicio()
}

fun verificarSenha(): Boolean {
    print("Por favor, insira sua senha: ")
    val senha = readln().toInt()
    if (senha != senhaCorreta) {
        println("Senha incorreta ou inválida. Tente novamente.")
        verificarSenha()
    }
    return true
}

fun inicio() {
    print("Bem vindo ao Hotel $nomeHotel, $nome. É um imenso prazer ter você por aqui!\n\n")
    println("Escolha uma opção:")
    println("1. Cadastrar Quartos")
    println("2. Cadastrar Hóspedes")
    println("3. Abastecer Automóveis")
    println("4. Sair do Hotel ${nomeHotel}")

    val escolha = readln().toIntOrNull()
    when (escolha) {
        1 -> cadastrarQuartos()
        2 -> cadastrarHospedes()
        3 -> abastecimentoDeAutomoveis()
        4 -> sairDoHotel(nome)
        else -> erro()
    }
}

fun sairDoHotel(nome: String) {
    println("\nVocê deseja sair?\nInforme 1 para \"sim\" e 0 para \"não\"")
    val confirma = when (readln()) {
        "1" -> true
        "0" -> false
        else -> null
    }
    when (confirma) {
        true -> println("\nMuito obrigado e até logo, $nome!")
        false -> inicio()
        null -> {
            println("\nEntrada inválida. Tente novamente.")
            sairDoHotel(nome)
        }
    }
}

fun erro(){
    println("Por favor, informe um número entre 1 e 4.")
    inicio()
}
