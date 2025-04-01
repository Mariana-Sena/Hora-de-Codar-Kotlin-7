fun agendarEventos() {
    println("\nEtapa 1: Quantidade de convidados")
    println("Qual o número de convidados para o seu evento?")
    val convidados = readln().toInt()

    while (convidados > 350 || convidados < 0) {
        println("Número de convidados inválido")
        agendarEventos()
    }

    var auditorio = "Auditório Colorado"
    var cadeirasExtras = 0
    if (convidados <= 150) {
        auditorio = "Auditório Laranja"
    } else if (convidados <= 220) {
        auditorio = "Auditório Laranja"
        cadeirasExtras = convidados - 150
    }

    println("Use o $auditorio${if (cadeirasExtras > 0) " (inclua mais $cadeirasExtras cadeiras)" else ""}")
    println("Agora vamos ver a agenda do evento.")

    println("\nEtapa 2: Agenda")
    println("Caro cliente, o auditório está disponível para reservas de segunda a sexta das 7hs às 23hs; sábados e domingos das 7hs às 15hs. ")

    println("\nQual o dia do evento?")
    val diaSemana = readln().lowercase()

    println("Qual a hora do evento?")
    val hora = readln().toInt()

    val disponivel = when (diaSemana) {
        "segunda", "terca", "quarta", "quinta", "sexta" -> hora in 7..23
        "sabado", "domingo" -> hora in 7..15
        else -> false
    }

    while (disponivel == false) {
        println("Auditorio indisponivel")
        println("Deseja agendar um novo evento? S/N")
        val resp = readln()
        if (resp.equals("S", ignoreCase = true)) {
            agendarEventos()
        } else {
            println("Reserva não efetuada.")
            inicio()
        }
    }

    println("\nQual o nome da empresa?")
    val empresa = readln()
    println("Auditório reservado para $empresa: ${diaSemana} às ${hora}hs.")

    println("\nEtapa 2: Quantidade de funcionários necessários")
    println("\nQual a duração do evento em horas?")
    val duracao = readln().toInt()

    val garconsPorConvidados = (convidados / 12.0).toInt()
    val garconsExtrasPorTempo = duracao / 2
    val garcons = garconsPorConvidados + garconsExtrasPorTempo
    val custoGarcons = garcons * 10.50 * duracao
    println("São necessários $garcons garçons.")
    println("Custo: R$ ${"%.2f".format(custoGarcons)}") //formata o valor para 2 casas decimais

    println("\nAgora vamos calcular o buffet do hotel para o evento.\n")

    println("Etapa 4: Buffet")
    val cafe = convidados * 0.2
    val agua = convidados * 0.5
    val salgados = convidados * 7
    val custoCafe = cafe * 0.80
    val custoAgua = agua * 0.40
    val custoSalgados = (salgados / 100.0) * 34.0
    val custoBuffet = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de %.1f litros de café, %.1f litros de água, ${salgados} salgados.".format(cafe, agua))

    val custoTotal = custoGarcons + custoBuffet

println("\n=============== RESUMO DA RESERVA ===============")
    println("Evento no $auditorio.")
    println("Nome da Empresa: $empresa.")
    println("Data: ${diaSemana}, ${hora}h às ${hora + duracao}h.")
    println("Duração do evento: ${duracao}H.")
    println("Quantidade de garçons: $garcons.")
    println("Quantidade de convidados: $convidados")
    println("\nCusto dos garcons: R$ ${"%.2f".format(custoGarcons)}")
    println("Custo do Buffet: R$ ${"%.2f".format(custoBuffet)}")
    println("\nValor total do Evento: R$ ${"%.2f".format(custoTotal)}")

    println("\nGostaria de efetuar a reserva? S/N")
    val resposta = readln()
    if (resposta.equals("S", ignoreCase = true)) {
        println("$empresa, reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
        println("Deseja iniciar uma nova reserva? S/N")
        val respFinal = readln()
        if (respFinal.equals("S", ignoreCase = true)) {
            agendarEventos()
        } else {
            inicio()
        }
    }
}