package br.com.capyensina.main.ui

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.TextBox
import br.com.capyensina.main.components.Textable
import br.com.capyensina.main.ui.screens.ByeScreen
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.ui.screens.TextScreen
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.BoxSize
import br.com.capyensina.main.util.MySpriteBatch
import br.com.capyensina.main.util.TextManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import ktx.assets.toInternalFile

class TextBoxManager(mainGame: Main) {
    val main = mainGame

    val configTextBox = TextBox(BoxSize.BIGGEST)
    val loreTextBox = TextBox(BoxSize.BIGGEST)
    val moduleOneTextBox  = TextBox(BoxSize.MEDIUM)
    val scoreTextBox  = TextBox(BoxSize.BIGGEST)

    init {
        /* NOTA 17/11/2024 20:23 - Malcoln
         * Esse é um exemplo de como configurar o conteúdo que irá aparecer dentro do TextBox, não
         * adicione nada relevante dentre a "tag" exemplo, pois esta será apagada posteriormente.
         *
         * NOTA 03/12/2024 19:48 - Malcoln
         * eh, apaguei e acho que ninguém viu, mas vida que segue, enfim, vou explicar como funciona
         * mais ou menos essa classe:
         * Um textBox precisa ter seu conteúdo configurado aqui, e ele é um Array de Clickables
         * e se ele tiver TEXTO é muito importante que este seja separado no TEXTCONTENT, pois é
         * essa função que tem capacidade de lidar com escrever o texto na tela
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
            ) {
                TextManager.actualTextActivity = TextManager.financeLessonOne
                mainGame.setScreen<TextScreen>()
                moduleOneTextBox.isActive = false
              },
            // Economia I
            Clickable(
                AssetManager.redButton,
                Rectangle(200f, 1100f, 950f, 400f)
            ){
                TextManager.actualTextActivity = TextManager.economyLessonOne
                mainGame.setScreen<TextScreen>()
                moduleOneTextBox.isActive = false
             },
            // Investimento I
            Clickable(
                AssetManager.redButton,
                Rectangle(200f, 850f, 950f, 400f)
            ) {
                TextManager.actualTextActivity = TextManager.investmentLessonOne
                mainGame.setScreen<TextScreen>()
                moduleOneTextBox.isActive = false
            }
        )

        moduleOneTextBox.textContent = arrayOf(
            Textable(
                "MATÉRIAS",
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
                Vector2(500f, 1335f)
            ),
            Textable(
                "Investimento I",
                AssetManager.getFontTextBold(),
                Vector2(400f, 1090f)
            )
        )

        scoreTextBox.content = arrayOf(
            Clickable(
                Texture("button/continuarbutton.png".toInternalFile()),
                Rectangle(200f, 950f, 900f, 450f)
            ) { main.setScreen<ByeScreen>(); scoreTextBox.isActive = false }
        )

        updateScoreText() // O texto é feito nesta função, pois ele precisa ser atualizado depois
    }

    fun input(clickPos: Vector2){
        if (configTextBox.isActive) configTextBox.input(clickPos)
        if (moduleOneTextBox.isActive) moduleOneTextBox.input(clickPos)
        if (scoreTextBox.isActive) scoreTextBox.input(clickPos)
    }

    fun draw(batch: MySpriteBatch){
        if (configTextBox.isActive) configTextBox.draw(batch)
        if (moduleOneTextBox.isActive) moduleOneTextBox.draw(batch)
        if (scoreTextBox.isActive) scoreTextBox.draw(batch)
    }

    private fun changeConfigTextBoxSoundIcon(index: Int){
        if (main.textBoxManager.configTextBox.content[index].texture == AssetManager.soundOn){
            main.textBoxManager.configTextBox.content[index].texture = AssetManager.soundOff
            if (index == 0) main.audioManager.isSoundOn = false
            else if (index == 1) main.audioManager.stopMusic()
        } else  {
            main.textBoxManager.configTextBox.content[index].texture = AssetManager.soundOn
            if (index == 0) main.audioManager.isSoundOn = true
            else if (index == 1) main.audioManager.startMusic()
        }

    }

    fun updateScoreText() {
        scoreTextBox.textContent = arrayOf(
            Textable(
                "Fim do Quiz!",
                AssetManager.getFont(),
                Vector2(400f, 2030f)
            ),
            Textable(
                "Pontuação: ${main.playerScoreManager.lastScore}",
                AssetManager.getFont(),
                Vector2(240f, 1700f)
            ),
            Textable(
                "Tempo: ${main.playerScoreManager.lastTime.toInt()}s",
                AssetManager.getFont(),
                Vector2(240f, 1600f)
            )
        )
    }

    fun closeAll(){
        configTextBox.close()
        loreTextBox.close()
        moduleOneTextBox.close()
        scoreTextBox.close()
    }
}
