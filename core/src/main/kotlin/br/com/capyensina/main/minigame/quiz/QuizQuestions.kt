package br.com.capyensina.main.minigame.quiz

object QuizQuestions {

    val financeQuestions = listOf(
        QuizQuestion(
            id = 1,
            subject = "finanças",
            questionText = "Por que educação financeira é importante?",
            answerTable = QuizAnswerTable(
                answerA = "Porque capivaras gostam de dinheiro.",
                answerB = "Para aprender a gerir o próprio dinheiro.",
                answerC = "Porque capivaras são capitalistas.",
                answerD = "Porque o apocapivaras está chegando.",
                correctIndex = 1
            ),
            difficulty = 1
        ),QuizQuestion(
            id = 2,
            subject = "finanças",
            questionText = "Qual é a primeira etapa do planejamento financeiro?",
            answerTable = QuizAnswerTable(
                answerA = "Definir objetivos financeiros.",
                answerB = "Investir em ações de risco.",
                answerC = "Comprar uma casa.",
                answerD = "Gastar todo o salário.",
                correctIndex = 0
            ),
            difficulty = 1
        ),QuizQuestion(
            id = 3,
            subject = "finanças",
            questionText = "O que significa criar um orçamento pessoal?",
            answerTable = QuizAnswerTable(
                answerA = "Registrar e planejar receitas e despesas.",
                answerB = "Investir em criptomoedas.",
                answerC = "Evitar qualquer tipo de dívida.",
                answerD = "Gastar sem se preocupar.",
                correctIndex = 0
            ),
            difficulty = 1
        ),QuizQuestion(
            id = 4,
            subject = "finanças",
            questionText = "Qual é a importância de um fundo de emergência?",
            answerTable = QuizAnswerTable(
                answerA = "Permite gastar mais em lazer.",
                answerB = "Ajuda a lidar com imprevistos financeiros.",
                answerC = "Serve para aumentar o limite do cartão de crédito.",
                answerD = "É desnecessário se você já tem dívidas.",
                correctIndex = 1
            ),
            difficulty = 1
        ),QuizQuestion(
            id = 5,
            subject = "finanças",
            questionText = "O que é um objetivo financeiro SMART?",
            answerTable = QuizAnswerTable(
                answerA = "Objetivo baseado em sorte.",
                answerB = "específico, mensurável, atingível, relevante e com prazo.",
                answerC = "Objetivo que depende de empréstimos.",
                answerD = "Objetivo focado exclusivamente em investimentos de risco.",
                correctIndex = 1
            ),
            difficulty = 2
        ),QuizQuestion(
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
        QuizQuestion(
            id = 1,
            subject = "Naruto",
            questionText = "Qual é o principal desejo de Naruto, segundo o texto?",
            answerTable = QuizAnswerTable(
                answerA = "Ser o mais forte da aldeia.",
                answerB = "Ser respeitado.",
                answerC = "Nunca mais chorar.",
                answerD = "Fazer muitos amigos.",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 2,
            subject = "Naruto",
            questionText = "O que caracteriza a atitude de Naruto diante das dificuldades?",
            answerTable = QuizAnswerTable(
                answerA = "Ele chora e fica zangado frequentemente.",
                answerB = "Ele desiste facilmente.",
                answerC = "Ele está sempre disposto a melhorar.",
                answerD = "Ele evita lidar com problemas.",
                correctIndex = 2
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 3,
            subject = "Naruto",
            questionText = "Qual é o contexto familiar de Naruto mencionado no texto?",
            answerTable = QuizAnswerTable(
                answerA = "Ele foi criado por seus pais.",
                answerB = "Ele cresceu sem pai e sem conhecer sua mãe.",
                answerC = "Ele tem muitos amigos desde a infância.",
                answerD = "Ele viveu em outra aldeia.",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 4,
            subject = "Naruto",
            questionText = "Por que Naruto decidiu agir em vez de continuar chorando?",
            answerTable = QuizAnswerTable(
                answerA = "Porque ele quer impressionar seus amigos.",
                answerB = "Porque ele se cansou de chorar e decidiu fazer algo a respeito.",
                answerC = "Porque ele foi forçado pela aldeia.",
                answerD = "Porque ele deseja ser o líder imediatamente.",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 5,
            subject = "Naruto",
            questionText = "O que Naruto estaria disposto a fazer para alcançar seu sonho?",
            answerTable = QuizAnswerTable(
                answerA = "Desistir facilmente.",
                answerB = "Dar a vida sem hesitar.",
                answerC = "Isolar-se da aldeia.",
                answerD = "Esconder suas emoções.",
                correctIndex = 1
            ),
            difficulty = 2
        )
    )

    val debugQuestions = listOf(
        QuizQuestion(
            id = 1,
            subject = "Naruto",
            questionText = "Qual é o principal desejo de Naruto, segundo o texto?",
            answerTable = QuizAnswerTable(
                answerA = "M".repeat(18),
                answerB = "M".repeat(15),
                answerC = "<".repeat(25),
                answerD = "Fazer uma quantidade grotesca, absurda e tremenda de amigos",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 1,
            subject = "Naruto",
            questionText = "Qual é o principal desejo de Naruto, segundo o texto?",
            answerTable = QuizAnswerTable(
                answerA = "Ser o mais forte da aldeia.",
                answerB = "Ser respeitado.",
                answerC = "Nunca mais chorar.",
                answerD = "Fazer uma quantidade grotesca, absurda e tremenda de amigos",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 1,
            subject = "Naruto",
            questionText = "Qual é o principal desejo de Naruto, segundo o texto?",
            answerTable = QuizAnswerTable(
                answerA = "Ser o mais forte da aldeia.",
                answerB = "Ser respeitado.",
                answerC = "Nunca mais chorar.",
                answerD = "Fazer uma quantidade grotesca, absurda e tremenda de amigos",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 1,
            subject = "Naruto",
            questionText = "Qual é o principal desejo de Naruto, segundo o texto?",
            answerTable = QuizAnswerTable(
                answerA = "Ser o mais forte da aldeia.",
                answerB = "Ser respeitado.",
                answerC = "Nunca mais chorar.",
                answerD = "Fazer uma quantidade grotesca, absurda e tremenda de amigos",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 1,
            subject = "Naruto",
            questionText = "Qual é o principal desejo de Naruto, segundo o texto?",
            answerTable = QuizAnswerTable(
                answerA = "Ser o mais forte da aldeia.",
                answerB = "Ser respeitado.",
                answerC = "Nunca mais chorar.",
                answerD = "Fazer uma quantidade grotesca, absurda e tremenda de amigos",
                correctIndex = 1
            ),
            difficulty = 1
        ),
    )
}
