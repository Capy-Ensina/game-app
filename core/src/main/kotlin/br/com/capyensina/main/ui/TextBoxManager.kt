package br.com.capyensina.main.ui

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.TextBox
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.BoxSize
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class TextBoxManager(mainGame: Main) {

    val configTextBox = TextBox(BoxSize.BIGGEST)

    init {
        /* NOTA 17/11/2024 20:23 - Malcoln
         * Esse é um exemplo de como configurar o conteúdo que irá aparecer dentro do TextBox, não
         * adicione nada relevante dentre a "tag" exemplo, pois esta será apagada posteriormente.
         */

        // COMEÇO DO EXEMPLO
        configTextBox.content = arrayOf(
            Clickable(
                AssetManager.rpgButton,
                Rectangle(870f, 1050f, 200f, 200f)
            ) { // Ação que será executada pelo botão
                mainGame.setScreen<HomeScreen>()
            },
            Clickable(
                AssetManager.investimentButton,
                Rectangle(1070f, 1050f, 200f, 200f)
            ) // O botão pode ou não conter uma ação, este por exemplo não faz nada :)
        )
        // FIM DO EXEMPLO
    }

    fun input(clickPos: Vector2){
        if (configTextBox.isActive) configTextBox.input(clickPos)
    }

    fun draw(batch: MySpriteBatch){
        if (configTextBox.isActive) configTextBox.draw(batch)
    }
}
