package br.com.capyensina.main.util

import br.com.capyensina.main.minigame.quiz.QuizQuestion
import br.com.capyensina.main.minigame.quiz.QuizQuestions

object TextManager {

    lateinit var actualTextActivity: TextActivity

    val financeLessonOne = TextActivity (
        subject = "INTRODUÇÃO I",
        title = "Capivaras do Tesouro",
        lesson = "A educação financeira é essencial para o desenvolvimento de habilidades que permitem gerenciar recursos de forma consciente e eficiente. Ela envolve a compreensão de conceitos fundamentais, como planejamento financeiro, controle de gastos, investimentos, e a importância de poupar para o futuro. Ao adquirir conhecimentos sobre como lidar com o dinheiro, as pessoas podem tomar decisões mais informadas, evitando dívidas excessivas e aproveitando melhor suas oportunidades econômicas.",
        setOfQuestions = QuizQuestions.financeQuestions
    )

    // todo Alterar este placeholder
    val financeLessonTwo = TextActivity (
        subject = "INTRODUÇÃO I",
        title = "Mensagem motivacional",
        lesson = "O Naruto pode ser um pouco rude às vezes, talvez você não saiba disso, mas o Naruto também cresceu sem pai. Na verdade, ele nunca conheceu nenhum de seus pais, e nunca teve nenhum amigo em nossa aldeia. Mesmo assim, eu nunca vi ele chorar, ficar zangado ou se dar por vencido, ele está sempre disposto a melhorar, ele quer ser respeitado, é o sonho dele e o Naruto daria a vida por isso sem hesitar. Meu palpite é que ele se cansou de chorar e decidiu fazer alguma coisa a respeito!",
        setOfQuestions = QuizQuestions.economyQuestions
    )

    val debugLesson = TextActivity (
        subject = "INTRODUÇÃO I",
        title = "Mensagem motivacionalaaaaaaaaaaaaaaaaaaaaa",
        lesson = "O Naruto pode ser um pouco rude às vezes, talvez você não saiba disso, mas o Naruto também cresceu sem pai. Na verdade, ele nunca conheceu nenhum de seus pais, e nunca teve nenhum amigo em nossa aldeia. Mesmo assim, eu nunca vi ele chorar, ficar zangado ou se dar por vencido, ele está sempre disposto a melhorar, ele quer ser respeitado, é o sonho dele e o Naruto daria a vida por isso sem hesitar. Meu palpite é que ele se cansou de chorar e decidiu fazer alguma coisa a respeito!",
        setOfQuestions = QuizQuestions.debugQuestions
    )
}

data class TextActivity (
    var subject: String,
    var title: String,
    var lesson: String,
    var setOfQuestions: List<QuizQuestion>
)
