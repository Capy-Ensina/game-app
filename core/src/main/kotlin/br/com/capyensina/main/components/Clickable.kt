package br.com.capyensina.main.components

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle

data class Clickable(
    var texture: Texture,
    var collider: Rectangle
)
