package br.com.capyensina.main.util

import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.TextBox
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MySpriteBatch : SpriteBatch() {

    fun draw(arg: Clickable) {
        draw(arg.texture, arg.collider.x, arg.collider.y, arg.collider.width, arg.collider.height)
    }

}
