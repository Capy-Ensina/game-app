package br.com.capyensina.main.ui.layout

import br.com.capyensina.main.Main
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import ktx.style.skin

class HomeLayout(main: Main) {

    lateinit var table: Table

    init {
        val skin = main.skinManager.skin

        val nameLabel = Label("Name:", skin)
        val nameText = TextField("", skin)

        table = Table()

        table.add(nameLabel)
        table.add(nameText).width(100f)
        table.row()
        table.add(nameLabel).width(100f)
    }
}
