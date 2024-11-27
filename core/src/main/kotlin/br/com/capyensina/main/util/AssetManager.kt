package br.com.capyensina.main.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import ktx.assets.toInternalFile

object AssetManager {
    // Backgrounds
    val mainBg = Texture("bg/background.png".toInternalFile())
    val loadBg = Texture("bg/carregandoscreen.png".toInternalFile())
    val yellowBg = Texture("bg/backgroundamarelo.png".toInternalFile())
    val blueRectBg = Texture("hud/rect-blue.png".toInternalFile())
    val whiteRectBg = Texture("hud/rect-white.png".toInternalFile())

    // Icons
    val capicoinIcon = Texture("capicoin.png".toInternalFile())
    val loadingOneIcon = Texture("loadingum.png".toInternalFile())
    val starIcon = Texture("stars/estrela.png".toInternalFile())

    // Buttons
    val editButton = Texture("button/editbutton.png".toInternalFile())
    val editButtonLocked = Texture("button/locked/editbutton.png".toInternalFile())
    val shopButton = Texture("button/lojabutton.png".toInternalFile())
    val shopButtonLocked = Texture("button/locked/lojabutton.png".toInternalFile())
    val booksButton = Texture("button/booksbutton.png".toInternalFile())
    val investimentButton = Texture("button/investimentobutton.png".toInternalFile())
    val investimentButtonLocked = Texture("button/locked/investimentobutton.png".toInternalFile())
    val rpgButton = Texture("button/rpgbutton.png".toInternalFile())
    val rpgButtonLocked = Texture("button/locked/rpgbutton.png".toInternalFile())
    val configButton = Texture("button/configbutton.png".toInternalFile())
    val closeButton = Texture("button/closebutton.png".toInternalFile())
    val startButton = Texture("button/startbutton.png".toInternalFile())
    val skipButton = Texture("button/skipbutton.png".toInternalFile())
    val continueButton = Texture("button/continuarbutton.png".toInternalFile())
    val redButton = Texture("button/redbutton.png".toInternalFile())
    val finishButton = Texture("button/finalizarbutton.png".toInternalFile())

    // Hud
    val capicoinInfo = Texture("hud/infocapicoin.png".toInternalFile())
    val hudInfo = Texture("hud/infohud.png".toInternalFile())

    // Text Box
    val infoBoxBiggest = Texture("text-box/infoboxquatro.png".toInternalFile())
    val infoBoxBig = Texture("text-box/infoboxtres.png".toInternalFile())
    val infoBoxMedium = Texture("text-box/infoboxdois.png".toInternalFile())
    val infoBoxSmall = Texture("text-box/infoboxum.png".toInternalFile())

    // Glyph Layout
    val layout = GlyphLayout()

    // Sound
    val soundOn = Texture("icons/soundon.png".toInternalFile())
    val soundOff = Texture("icons/soundoff.png".toInternalFile())

    // QUIZ
    val question = Texture("button/redquestion.png".toInternalFile())
    val answerA = Texture("button/blueanswerA.png".toInternalFile())
    val answerB = Texture("button/blueanswerB.png".toInternalFile())
    val answerC = Texture("button/blueanswerC.png".toInternalFile())
    val answerD = Texture("button/blueanswerD.png".toInternalFile())

    // Fontes TITULOS MAIS IMPORTANTES
    fun getFont(): BitmapFont {
        val fontGenerator = FreeTypeFontGenerator(Gdx.files.internal("font/PixelOperatorHB8.ttf"))
        val fontParameter = FreeTypeFontGenerator.FreeTypeFontParameter().apply {
            this.color = ColorTheme.BLACK
            this.size = 70
        }
        val customFont = fontGenerator.generateFont(fontParameter)
        fontGenerator.dispose()
        return customFont
    }

    // TITULOS NORMAIS
    fun getFontTextBold(): BitmapFont {
        val fontGenerator = FreeTypeFontGenerator(Gdx.files.internal("font/PixelOperator-Bold.ttf"))
        val fontParameter = FreeTypeFontGenerator.FreeTypeFontParameter().apply {
            this.color = ColorTheme.BLACK
            this.size = 80
        }
        val customFont = fontGenerator.generateFont(fontParameter)
        fontGenerator.dispose()
        return customFont
    }

   // TEXTOS
    fun getFontText(): BitmapFont {
        val fontGenerator = FreeTypeFontGenerator(Gdx.files.internal("font/PixelOperator.ttf"))
        val fontParameter = FreeTypeFontGenerator.FreeTypeFontParameter().apply {
            this.color = ColorTheme.BLACK
            this.size = 90
        }
        val customFont = fontGenerator.generateFont(fontParameter)
        fontGenerator.dispose()
        return customFont
    }
}


