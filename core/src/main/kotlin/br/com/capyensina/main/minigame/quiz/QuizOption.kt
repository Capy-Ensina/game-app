package br.com.capyensina.main.minigame.quiz

import br.com.capyensina.main.ui.screens.layout
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class QuizOption(
    val textureUnselected: Texture,
    val textureSelected: Texture,
    var collider: Rectangle,
    var isSelected: Boolean = false,
    val text: String,
    private val font: BitmapFont,
){
    private var textWidth: Float = collider.width * 0.7f
    private var textPos: Vector2 = Vector2(collider.x + 160f, collider.y + 160f)

    fun draw(batch: MySpriteBatch){
        // Desenhar Texto

        layout.setText(font, text, Color.BLACK, textWidth, -1, true)
        font.draw(batch, layout, textPos.x, textPos.y)
    }

    fun onClick(){
        isSelected = !isSelected
    }
}

object layout{
    val glyphLayout = GlyphLayout()
}
