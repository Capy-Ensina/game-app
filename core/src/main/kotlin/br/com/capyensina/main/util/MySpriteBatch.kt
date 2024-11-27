package br.com.capyensina.main.util

import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.TextBox
import br.com.capyensina.main.components.Textable
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MySpriteBatch : SpriteBatch() {

    /* NOTA 17/11/2024 20:02 - Malcoln
     * Essa classe aqui serve somente para facilitar o comando de desenhar componentes, e por isso
     * que coloquei como obrigatório o Rectangle na data class Clicable, para receber as informações
     * de localização e desenhar facilmente os componentes, por isso sempre que for usar um
     * spriteBatch, usa o MySpriteBatch
     */

    fun draw(arg: Clickable) {
        draw(arg.texture, arg.collider.x, arg.collider.y, arg.collider.width, arg.collider.height)
    }

    fun draw(arg: Clickable, tint: Color) {
        this.color = tint
        draw(arg.texture, arg.collider.x, arg.collider.y, arg.collider.width, arg.collider.height)
        this.color = Color.WHITE
    }

    fun draw(arg: TextBox) {
        draw(arg.background)
        draw(arg.exitButton)
    }

    fun draw(arg: Textable) {
        arg.font.draw(this, arg.text, arg.position.x, arg.position.y)
    }

}
