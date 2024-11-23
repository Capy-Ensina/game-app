package br.com.capyensina.main.ui

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.TextBox
import br.com.capyensina.main.components.Textable
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.ui.screens.TextScreen
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.BoxSize
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class TextBoxManager(mainGame: Main) {
    val main = mainGame

    val configTextBox = TextBox(BoxSize.BIGGEST)
    val loreTextBox = TextBox(BoxSize.BIGGEST)
    val moduleOneTextBox  = TextBox(BoxSize.MEDIUM)

    init {
        /* NOTA 17/11/2024 20:23 - Malcoln
         * Esse é um exemplo de como configurar o conteúdo que irá aparecer dentro do TextBox, não
         * adicione nada relevante dentre a "tag" exemplo, pois esta será apagada posteriormente.
         */

        configTextBox.content = arrayOf(
            Clickable(
                AssetManager.soundOn,
                Rectangle(950f, 1890f, 150f, 150f)
            ) {
                changeConfigTextBoxSoundIcon(0)
            },
            Clickable(
                AssetManager.soundOn,
                Rectangle(950f, 1690f, 150f, 150f)
            ) {
                changeConfigTextBoxSoundIcon(1)
            }
        )

        configTextBox.textContent = arrayOf(
            Textable(
                "SOM",
                AssetManager.getFont(),
                Vector2(300f, 2000f)
            ),
            Textable(
                "MÚSICA",
                AssetManager.getFont(),
                Vector2(300f, 1800f)
            )
        )

        moduleOneTextBox.content = arrayOf(
            // Finanças I
            Clickable(
                AssetManager.redButton,
                Rectangle(200f, 1350f, 950f, 400f)
            ) { mainGame.setScreen<TextScreen>() },
            // Economia I
            Clickable(
                AssetManager.redButton,
                Rectangle(200f, 1100f, 950f, 400f)
            ),
            // Investimento I
            Clickable(
                AssetManager.redButton,
                Rectangle(200f, 850f, 950f, 400f)
            )
        )

        moduleOneTextBox.textContent = arrayOf(
            Textable(
                "MÓDULO I",
                AssetManager.getFont(),
                Vector2(400f, 1790f)
            ),
            Textable(
                "Finanças I",
                AssetManager.getFontTextBold(),
                Vector2(500f, 1590f)
            ),
            Textable(
                "Economia I",
                AssetManager.getFontTextBold(),
                Vector2(500f, 1350f)
            ),
            Textable(
                "Investimento I",
                AssetManager.getFontTextBold(),
                Vector2(400f, 1090f)
            )

        )
    }

    fun input(clickPos: Vector2){
        if (configTextBox.isActive) configTextBox.input(clickPos)
        if (moduleOneTextBox.isActive) moduleOneTextBox.input(clickPos)
    }

    fun draw(batch: MySpriteBatch){
        if (configTextBox.isActive) configTextBox.draw(batch)
        if (moduleOneTextBox.isActive) moduleOneTextBox.draw(batch)
    }

    private fun changeConfigTextBoxSoundIcon(index: Int){
        if (main.textBoxManager.configTextBox.content[index].texture == AssetManager.soundOn){
            main.textBoxManager.configTextBox.content[index].texture = AssetManager.soundOff
        } else  {
            main.textBoxManager.configTextBox.content[index].texture = AssetManager.soundOn
        }

    }

}
