package br.com.capyensina.main.minigame.quiz

object QuizQuestions {

    val financeQuestions = listOf(
        QuizQuestion( //atualizada - elas tem no maximo 35 caracteres
            id = 1,
            subject = "finanças",
            questionText = "Título de Renda Fixa isento de IR:",
            answerTable = QuizAnswerTable(
                answerA = "CDB.",
                answerB = "Debêntures comuns.",
                answerC = "LCI (Letra de Crédito Imobiliário).",
                answerD = "Tesouro Prefixado.",
                correctIndex = 3
            ),
            difficulty = 1
        ),QuizQuestion( // atualizada
            id = 2,
            subject = "finanças",
            questionText = "Título emitido pelo governo:",
            answerTable = QuizAnswerTable(
                answerA = "CDB (Certificado de Depósito Bancário).",
                answerB = "Tesouro Selic.",
                answerC = " LCI (Letra de Crédito Imobiliário).",
                answerD = "Debêntures.",
                correctIndex = 2
            ),
            difficulty = 1
        ),QuizQuestion( //atualizada
            id = 3,
            subject = "finanças",
            questionText = "Característica de Renda Fixa:",
            answerTable = QuizAnswerTable(
                answerA = "Rentabilidade fixa.",
                answerB = "Risco maior que ações.",
                answerC = "Rentabilidade variável.",
                answerD = "Sem liquidez diária.",
                correctIndex = 1
            ),
            difficulty = 1
        ),QuizQuestion(  //atualizada
            id = 4,
            subject = "finanças",
            questionText = "Com garantia do FGC:",
            answerTable = QuizAnswerTable(
                answerA = "Tesouro Direto.",
                answerB = "Debêntures incentivadas.",
                answerC = "CDB (Certificado de Depósito Bancário).",
                answerD = "Ações.",
                correctIndex = 3
            ),
            difficulty = 1
        ),QuizQuestion( // atualizada
            id = 5,
            subject = "finanças",
            questionText = "Vantagem do CDB com liquidez:",
            answerTable = QuizAnswerTable(
                answerA = "Taxas superiores.",
                answerB = "Resgate sem perda.",
                answerC = "Isenção de Imposto de Renda.",
                answerD = "Proteção contra a inflação.",
                correctIndex = 2
            ),
            difficulty = 2
        ),QuizQuestion( // apagar a sexta
            id = 6,
            subject = "finanças",
            questionText = "Qual a principal vantagem de controlar despesas mensais?",
            answerTable = QuizAnswerTable(
                answerA = "Saber exatamente para onde vai seu dinheiro.",
                answerB = "Evitar pagar impostos.",
                answerC = "Aumentar dívidas rapidamente.",
                answerD = "Ficar mais confuso com suas finanças.",
                correctIndex = 0
            ),
            difficulty = 1
        )
    )

    // todo trocar esse placeholder
    val economyQuestions = listOf(
        QuizQuestion( // atualizada
            id = 1,
            subject = "Economia",
            questionText = "Característica de Renda Variável:",
            answerTable = QuizAnswerTable(
                answerA = "Rentabilidade fixa.",
                answerB = "Alta volatilidade.",
                answerC = "Garantia acima da inflação.",
                answerD = "Sem taxas de corretagem.",
                correctIndex = 2
            ),
            difficulty = 1
        ),
        QuizQuestion( // atualizada
            id = 2,
            subject = "Economia",
            questionText = "Exemplo de Renda Variável:",
            answerTable = QuizAnswerTable(
                answerA = "CDB (Certificado de Depósito Bancário).",
                answerB = "Tesouro Selic.",
                answerC = "Ações.",
                answerD = "LCI (Letra de Crédito Imobiliário).",
                correctIndex = 3
            ),
            difficulty = 1
        ),
        QuizQuestion( // atualizada
            id = 3,
            subject = "Economia",
            questionText = "Significado de 'dividendo':",
            answerTable = QuizAnswerTable(
                answerA = "Taxa de corretagem.",
                answerB = "Lucro pago ao acionista.",
                answerC = "Garantia pelo FGC.",
                answerD = "Rentabilidade fixa,",
                correctIndex = 2
            ),
            difficulty = 1
        ),
        QuizQuestion( // atualizada
            id = 4,
            subject = "Economia",
            questionText = "Ganhos em ações:",
            answerTable = QuizAnswerTable(
                answerA = "Apenas dividendos.",
                answerB = "Apenas valorização.",
                answerC = "Dividendos e valorização.",
                answerD = "Compra no mercado primário.",
                correctIndex = 3
            ),
            difficulty = 1
        ),
        QuizQuestion( // atualizada
            id = 5,
            subject = "Economia",
            questionText = "Risco de ações em recuperação:",
            answerTable = QuizAnswerTable(
                answerA = "Falta de liquidez.",
                answerB = "Fim dos dividendos.",
                answerC = "Perda total.",
                answerD = "Altas taxas.",
                correctIndex = 3
            ),
            difficulty = 2
        )
    )

    val debugQuestions = listOf(
        QuizQuestion( // atualizada
            id = 1,
            subject = "Investimento",
            questionText = "Rendimento principal de FIIs:",
            answerTable = QuizAnswerTable(
                answerA = "Valorização das cotas.",
                answerB = "Aluguéis.",
                answerC = "Juros do governo.",
                answerD = "Rendimentos fixos.",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion( // atualizada
            id = 2,
            subject = "Investimento",
            questionText = "Vantagem dos FIIs:",
            answerTable = QuizAnswerTable(
                answerA = "Proteção do mercado.",
                answerB = "Sem custos de imóvel.",
                answerC = "Retorno fixo mensal.",
                answerD = "Controle administrativo.",
                correctIndex = 2
            ),
            difficulty = 1
        ),
        QuizQuestion( // atualizada
            id = 3,
            subject = "Investimento",
            questionText = "Prazo mínimo da poupança:",
            answerTable = QuizAnswerTable(
                answerA = "15 dias.",
                answerB = "30 dias.",
                answerC = "90 dias.",
                answerD = "180 dias.",
                correctIndex = 2
            ),
            difficulty = 1
        ),
        QuizQuestion( // atualizada
            id = 4,
            subject = "Investimento",
            questionText = "Vantagem da poupança:",
            answerTable = QuizAnswerTable(
                answerA = "Alta rentabilidade.",
                answerB = "Isenção de IR.",
                answerC = "Garantia ilimitada.",
                answerD = "Proteção da inflação.",
                correctIndex = 2
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 5,
            subject = "Investimento",
            questionText = "Quem garante a poupança:",
            answerTable = QuizAnswerTable(
                answerA = "O Fundo Monetário Internacional (FMI).",
                answerB = "O Fundo Garantidor de Créditos (FGC).",
                answerC = "O Banco Central Europeu.",
                answerD = " A corretora.",
                correctIndex = 2
            ),
            difficulty = 1
        ),
    )
}
