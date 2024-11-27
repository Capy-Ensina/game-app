package br.com.capyensina.main.components

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import ktx.assets.disposeSafely

data class Clickable(
    var texture: Texture,
    var collider: Rectangle,
    var action: () -> Unit = {}
)

fun Clickable.dispose(){
    texture.dispose()
}

fun Clickable.disposeSafely(){
    texture.disposeSafely()
}
