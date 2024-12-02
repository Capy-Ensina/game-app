package br.com.capyensina.main.minigame.quiz

import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.ui.screens.layout
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class QuizQuestion(
    val id: Int,
    val subject: String,
    private val questionText: String,
    private val answerTable: QuizAnswerTable,
    val difficulty: Int
) {
    private val answerTablePosition = Vector2(-100f, -200f)
    private val answerTableSize = Vector2(100f, 0f)
    private val answerWidth = 840f
    private val questionWidth = 900f

    private val textPosition = Vector2(430f, 2180f)
    private val textSpace = 310f

    private val selectedColor = ColorTheme.PEACH_YELLOW

    private val customFont = AssetManager.getFont()
    private val customFontBold = AssetManager.getFontTextBold()

    // Definir onde estão as questões
    private val questionBox = Clickable(
        AssetManager.question,
        Rectangle(120f + answerTablePosition.x,2200f + answerTablePosition.y,
               1320f,480f)
    ) {  }

    private val answerABox = Clickable(
        AssetManager.answerA,
        Rectangle(160f + answerTablePosition.x, 1900f + answerTablePosition.y,
               1130f + answerTableSize.x, 420f + answerTableSize.y)
    ) { answerTable.selectAnswer(0) }

    private val answerBBox = Clickable(
        AssetManager.answerB,
        Rectangle(160f + answerTablePosition.x, 1580f + answerTablePosition.y,
               1080f+ answerTableSize.x, 420f + answerTableSize.y)
    ) { answerTable.selectAnswer(1) }

    private val answerCBox = Clickable(
        AssetManager.answerC,
        Rectangle(160f + answerTablePosition.x, 1260f + answerTablePosition.y,
               1080f + answerTableSize.x, 420f + answerTableSize.y)
    ) { answerTable.selectAnswer(2) }

    private val answerDBox = Clickable(
        AssetManager.answerD,
        Rectangle(160f + answerTablePosition.x, 1000f + answerTablePosition.y,
               1100f + answerTableSize.x, 360f + answerTableSize.y)
    ) { answerTable.selectAnswer(3) }

    private val answerBoxes = listOf(answerABox, answerBBox, answerCBox, answerDBox)

    fun input(clickPos: Vector2){
        for (answer in answerBoxes) if (answer.collider.contains(clickPos)) answer.action()
    }

    fun draw(batch: MySpriteBatch){

        // DESENHAR FUNDOS
        batch.draw(questionBox)
        for ((index, answer) in answerBoxes.withIndex()) {
            batch.draw(answer, if (answerTable.selected[index]) selectedColor else Color.WHITE)
        }

        // Questão
        layout.setText(customFontBold, questionText, Color.BLACK, questionWidth, -1, true)
        customFontBold.draw(batch, layout,
            450f + answerTablePosition.x,
            2520f + answerTablePosition.y
        )

        // Textos das respostas
        for ((index, answer) in answerTable.getAnswerList().withIndex()) {
            layout.setText(customFontBold, answer, Color.BLACK, answerWidth,
                -1,
                true)
            customFontBold.draw(batch, layout,
                textPosition.x + answerTablePosition.x,
                (textPosition.y - (textSpace * index)) + answerTablePosition.y)
        }
    }

    fun getScore(): Double{ return if (answerTable.isCorrect()) 1.0 else 0.0 }

    fun unselectAnswer(){
        answerTable.unselectAnswer()
    }
}
