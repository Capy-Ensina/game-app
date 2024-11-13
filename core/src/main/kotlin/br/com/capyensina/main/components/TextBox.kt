package br.com.capyensina.main.components

import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.BoxSize
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import ktx.assets.Asset
import ktx.assets.toInternalFile

class TextBox(size: Int) {
    lateinit var background: Clickable
    lateinit var exitButton: Clickable

    var isActive = false

    init {
        when(size){
            BoxSize.SMALL -> {
                background = Clickable (
                    AssetManager.infoBoxBiggest,
                    Rectangle(5f, 700f, 1350f, 1700f)
                )
                exitButton = Clickable (
                    AssetManager.closeButton,
                    Rectangle(1000f, 2120f, 400f, 400f)
                )
            }
            else -> {
                background = Clickable (
                    AssetManager.infoBoxBiggest,
                    Rectangle(5f, 700f, 1350f, 1700f)
                )
                exitButton = Clickable (
                    AssetManager.closeButton,
                    Rectangle(1000f, 2120f, 400f, 400f)
                )
            }
        }
    }

    fun input(clickPos: Vector2){
        if (!isActive) return
        if (exitButton.collider.contains(clickPos)) isActive = false
    }

    fun logic(){
        if (!isActive) return
    }

    fun draw(batch: MySpriteBatch){
        if (!isActive) return
        batch.draw(background)
        batch.draw(exitButton)
    }


}
