package br.com.capyensina.main.util

import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.TextBox
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

    fun draw(arg: TextBox) {
        draw(arg.background)
        draw(arg.exitButton)
    }

}
