package br.com.capyensina.main.ui

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.disposeSafely
import br.com.capyensina.main.ui.screens.BooksScreen
import br.com.capyensina.main.ui.screens.EditScreen
import br.com.capyensina.main.ui.screens.InvestimentoScreen
import br.com.capyensina.main.ui.screens.LojaScreen
import br.com.capyensina.main.ui.screens.RpgScreen
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2

class HudManager(mainGame: Main) {
    private val main = mainGame

    //imagens e botao da hud superior
    private val capicoinInfo = Clickable(
        AssetManager.capicoinInfo,
        Rectangle(20f, main.WORLD_HEIGHT - 250f, 400f, 250f)
    ) { }
    private val hudInfoOne = Clickable(
        AssetManager.hudInfo,
        Rectangle(200f, main.WORLD_HEIGHT - 600f, 1000f, 1000f)
    ) { }
    private val hudInfoTwo = Clickable(
        AssetManager.hudInfo,
        Rectangle(500f, main.WORLD_HEIGHT - 600f, 1000f, 1000f)
    ) { }

    private val configButton = Clickable(
        AssetManager.configButton,
        Rectangle(1020f, main.WORLD_HEIGHT - 280f, 300f, 300f)
    ) { main.textBoxManager.configTextBox.isActive = true }

    private val backgroundTop = Clickable(
        AssetManager.whiteRectBg,
        Rectangle(0f, main.WORLD_HEIGHT - 220f, main.WORLD_WIDTH, 300f)
    ) { }

    private val textBackgroundTop = Clickable(
        AssetManager.whiteRectBg,
        Rectangle(-100f, main.WORLD_HEIGHT - 220f, main.WORLD_WIDTH + 200f, 300f)
    ) { }

    // Imagens dos botões inferiores
    private val editButton = Clickable(
        AssetManager.editButtonLocked,
        Rectangle(300f, 50f, 200f, 200f)
    ) { }

    private val shopButton = Clickable(
        AssetManager.shopButtonLocked,
        Rectangle(80f, 50f, 200f, 200f)
    ) { }

    private val booksButton = Clickable(
        AssetManager.booksButton,
        Rectangle(520f, 50f, 300f, 300f)
    ) { main.textBoxManager.moduleOneTextBox.isActive = true }

    private val investimentButton = Clickable(
        AssetManager.investimentButtonLocked,
        Rectangle(850f, 50f, 200f, 200f)
    ) { }

    private val rpgButton = Clickable(
        AssetManager.rpgButtonLocked,
        Rectangle(1070f, 50f, 200f, 200f)
    ) { }

    private val backgroundBottom = Clickable(
        AssetManager.whiteRectBg,
        Rectangle(0f, 0f, mainGame.WORLD_WIDTH, 300f)
    ) { }


    fun input(clickPos: Vector2){
        //  botão "Configuração"
        if (configButton.collider.contains(clickPos)) configButton.action()

        //  botão "Loja"
        if (shopButton.collider.contains(clickPos)) shopButton.action()

        // botão "Editar"
        if (editButton.collider.contains(clickPos)) editButton.action()

        // botão "Livros"
        if (booksButton.collider.contains(clickPos)) booksButton.action()

        //  botão "Investimentos"
        if (investimentButton.collider.contains(clickPos)) investimentButton.action()

        //  botão "RPG de texto"
        if (rpgButton.collider.contains(clickPos)) rpgButton.action()
    }

    fun draw(batch: MySpriteBatch, color: Color = ColorTheme.BACKGROUND_COLOR){
        batch.color = color
        batch.draw(backgroundTop)
        batch.draw(backgroundBottom)
        batch.color = Color.WHITE

        batch.draw(capicoinInfo)
        batch.draw(hudInfoOne)
        batch.draw(hudInfoTwo)

        batch.draw(configButton)

        batch.draw(shopButton)
        batch.draw(editButton)
        batch.draw(booksButton)
        batch.draw(investimentButton)
        batch.draw(rpgButton)
    }

    fun drawTextScreen(batch: MySpriteBatch, color: Color = ColorTheme.ORANGE){
        batch.color = color
        batch.draw(textBackgroundTop)
        batch.color = Color.WHITE
    }

    @Deprecated(
        "Using phone size",
        replaceWith = ReplaceWith("drawBackground"),
        DeprecationLevel.WARNING
    )
    fun drawLegacyShape(shapeRenderer: ShapeRenderer){
        // Retângulo superior
        shapeRenderer.color = ColorTheme.BLUE
        shapeRenderer.rect(0f, Gdx.graphics.height - 220f, Gdx.graphics.width.toFloat(), 300f)

        // Retângulo inferior
        shapeRenderer.color = ColorTheme.BLUE
        shapeRenderer.rect(0f, 0f, Gdx.graphics.width.toFloat(), 300f)
    }

    fun drawShape(shapeRenderer: ShapeRenderer){
        // Retângulo superior
        shapeRenderer.color = ColorTheme.BLUE
        shapeRenderer.rect(0f, main.WORLD_HEIGHT - 220f, main.WORLD_WIDTH, 300f)

        // Retângulo inferior
        shapeRenderer.color = ColorTheme.BLUE
        shapeRenderer.rect(0f, 0f, main.WORLD_WIDTH, 300f)
    }

    fun drawDebugShape(batch: MySpriteBatch){
    }

    fun drawBackground(batch: MySpriteBatch){
        batch.draw(AssetManager.mainBg, 0f, 0f, main.WORLD_WIDTH, main.WORLD_HEIGHT)
    }

    fun drawDebugBackground(batch: MySpriteBatch){
        batch.draw(AssetManager.mainBg, 0f, 0f, main.WORLD_WIDTH, main.WORLD_HEIGHT)
    }

    @Deprecated(
        "Using phone size",
        replaceWith = ReplaceWith("drawBackground"),
        DeprecationLevel.WARNING
    )
    fun drawLegacyBackground(batch: MySpriteBatch){
        batch.draw(AssetManager.mainBg, 0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
    }

    fun dispose(){
        capicoinInfo.disposeSafely()
        hudInfoOne.disposeSafely()
        hudInfoTwo.disposeSafely()
        configButton.disposeSafely()
        shopButton.disposeSafely()
        editButton.disposeSafely()
        booksButton.disposeSafely()
        investimentButton.disposeSafely()
        rpgButton.disposeSafely()
    }
}
