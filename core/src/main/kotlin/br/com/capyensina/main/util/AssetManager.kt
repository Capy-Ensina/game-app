package br.com.capyensina.main.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import ktx.assets.toInternalFile

object AssetManager {
    // Backgrounds
    val mainBg = Texture("bg/background.png".toInternalFile())

    // Buttons
    val editButton = Texture("button/editbutton.png".toInternalFile())
    val shopButton = Texture("button/lojabutton.png".toInternalFile())
    val booksButton = Texture("button/booksbutton.png".toInternalFile())
    val investimentButton = Texture("button/investimentobutton.png".toInternalFile())
    val rpgButton = Texture("button/rpgbutton.png".toInternalFile())
    val configButton = Texture("button/configbutton.png".toInternalFile())
    val closeButton = Texture("button/closebutton.png".toInternalFile())

    // Hud
    val capicoinInfo = Texture("hud/infocapicoin.png".toInternalFile())
    val hudInfo = Texture("hud/infohud.png".toInternalFile())

    // Text Box
    val infoBoxBiggest = Texture("text-box/infoboxquatro.png".toInternalFile())
    val infoBoxBig = Texture("text-box/infoboxtres.png".toInternalFile())
    val infoBoxMedium = Texture("text-box/infoboxdois.png".toInternalFile())
    val infoBoxSmall = Texture("text-box/infoboxum.png".toInternalFile())

    // Fontes
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
}


