package br.com.capyensina.main.components

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.BoxSize
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import ktx.assets.Asset
import ktx.assets.toInternalFile

open class TextBox(size: Int) {
    var background: Clickable
    var exitButton: Clickable
    var content = emptyArray<Clickable>()
    var textContent = emptyArray<Textable>()

    var isActive = false

    init {
        when(size){
            BoxSize.MEDIUM -> {
                background = Clickable (
                    AssetManager.infoBoxMedium,
                    Rectangle(5f, 700f, 1350f, 1350f)
                )
                exitButton = Clickable (
                    AssetManager.closeButton,
                    Rectangle(1000f, 1660f, 400f, 400f)
                )
            }
            BoxSize.BIGGEST -> {
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
        for (clickable in content){
            if(clickable.collider.contains(clickPos)) clickable.action()
        }
    }

    fun logic(){
        if (!isActive) return
        for (clickable in content){
            clickable.action()
        }
    }

    fun draw(batch: MySpriteBatch){
        if (!isActive) return
        batch.draw(background)
        batch.draw(exitButton)
        for (clickable in content){
            batch.draw(clickable)
        }
        for (textAble in textContent){
            batch.draw(textAble)
        }
    }


}
