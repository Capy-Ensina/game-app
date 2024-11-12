package br.com.capyensina.main.util

import br.com.capyensina.main.components.Clickable
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MySpriteBatch : SpriteBatch() {

    fun draw(clickable: Clickable){
        draw(clickable.texture, clickable.collider.x, clickable.collider.y, clickable.collider.width, clickable.collider.height)
    }

}
