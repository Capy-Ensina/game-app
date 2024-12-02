package br.com.capyensina.main.minigame.quiz

object QuizQuestions {

    val questions = listOf(
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
                answerB = "É específico, mensurável, atingível, relevante e com prazo.",
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
}
