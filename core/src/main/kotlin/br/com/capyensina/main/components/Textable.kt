package br.com.capyensina.main.components

import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.math.Vector2

data class Textable(
    var text: String,
    val font: BitmapFont,
    val position: Vector2
)
