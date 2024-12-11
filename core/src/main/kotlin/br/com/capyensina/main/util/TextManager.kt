package br.com.capyensina.main.util

import br.com.capyensina.main.minigame.quiz.QuizQuestion
import br.com.capyensina.main.minigame.quiz.QuizQuestions

object TextManager {

    lateinit var actualTextActivity: TextActivity

    val financeLessonOne = TextActivity (
        subject = "INTRODUÇÃO I",
        title = "Capivaras do Tesouro",
        lesson = "Renda Fixa oferece previsibilidade, com regras claras de rendimento. Títulos como LCI são isentos de IR para pessoa física, sendo atrativos. Títulos do Tesouro, como o Tesouro Selic, são emitidos pelo Governo Federal e seguros. CDBs têm garantia do FGC para valores até R\$250 mil. CDBs com liquidez diária permitem resgates rápidos sem perda de rentabilidade, ideais para emergências.",
        setOfQuestions = QuizQuestions.financeQuestions
    )

    val economyLessonOne = TextActivity (
        subject = "INTRODUÇÃO I",
        title = "Mensagem motivacional",
        lesson = "Investimentos de Renda Variável, como ações, têm alta volatilidade e risco, mas oferecem chance de altos retornos. Dividendos são parte do lucro de empresas distribuídas aos acionistas. Ganhos vêm da valorização e dos dividendos. Porém, empresas em crise, como em recuperação judicial, podem não se recuperar, causando perdas totais. Renda Variável exige cuidado e análise.",
        setOfQuestions = QuizQuestions.economyQuestions
    )

    val investmentLessonOne = TextActivity (
        subject = "INTRODUÇÃO I",
        title = "Mensagem motivacional",
        lesson = "FIIs permitem investir em imóveis sem custos como IPTU ou manutenção. O rendimento vem de alugueis e lucros. Já a poupança, isenta de IR, tem liquidez simples, mas só paga juros completos após 30 dias. O Fundo Garantidor de Créditos (FGC) assegura valores na poupança até R\$250 mil. FIIs e poupança são boas opções, cada uma com suas vantagens e limitações.",
        setOfQuestions = QuizQuestions.investmentQuestions
    )

    val debugLesson = TextActivity (
        subject = "INTRODUÇÃO I",
        title = "Mensagem motivacional",
        lesson = "DEBUGANDO ".repeat(50),
        setOfQuestions = QuizQuestions.debugQuestions
    )
}

data class TextActivity (
    var subject: String,
    var title: String,
    var lesson: String,
    var setOfQuestions: List<QuizQuestion>
)
