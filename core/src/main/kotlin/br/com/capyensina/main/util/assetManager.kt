package br.com.capyensina.main.util

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
import ktx.assets.toInternalFile

object AssetManager {
    val logo = Texture("logo.png".toInternalFile(), true)
        .apply { setFilter(Linear, Linear) }
    val btn_confirm = Texture("confirm.png".toInternalFile(), true)
        .apply { setFilter(Linear, Linear) }
}
