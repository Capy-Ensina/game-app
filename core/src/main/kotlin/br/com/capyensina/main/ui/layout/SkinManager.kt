package br.com.capyensina.main.ui.layout

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import ktx.assets.toInternalFile

class SkinManager {
    val skin: Skin

    init {
        //val atlas = TextureAtlas("Skin/default.atlas".toInternalFile())
        /*
        * TODO - MALCOLN
        *  arrumar essa função, pois o arquivo "Skin/default.atlas" não tá sendo encontrado
        *  nem quando tá puxando o debug.atlas.
        *  Isso não funcionar implica em falhas na hora de carregar textFields e a table
        * */
        skin = Skin()
    }
}
