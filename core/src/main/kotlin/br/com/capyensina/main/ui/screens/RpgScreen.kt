package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.ColorTheme
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class RpgScreen (main: Main) : KtxScreen {
    private val batch = SpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val background = Texture("background.png".toInternalFile())

    val mainGame = main

    //hud retangulos
    private val hudTopColor = ColorTheme.BLUE
    private val hudBottomColor = ColorTheme.BLUE
    private val hudHeight = 50f
    private val screenWidth = 800f

    //imagens e botao da hud superior
    private val infocapicoin = Texture("infocapicoin.png".toInternalFile())
    private val infohud = Texture("infohud.png".toInternalFile())
    private val configbutton = Texture("configbutton.png".toInternalFile())

    //imagens dos botoes inferiores
    private val editbutton = Texture("editbutton.png".toInternalFile())
    private val lojabutton = Texture("lojabutton.png".toInternalFile())
    private val booksbutton = Texture("booksbutton.png".toInternalFile())
    private val investimentobutton = Texture("investimentobutton.png".toInternalFile())
    private val rpgbutton = Texture("rpgbutton.png".toInternalFile())

    //imagens para a interface
    private val infoboxquatro = Texture("infoboxquatro.png".toInternalFile())
    private val closebutton = Texture("closebutton.png".toInternalFile())

    override fun render(delta: Float) {

        input()
        logic()
        draw()
    }

    private fun checkButtonClick() {
        if (Gdx.input.justTouched()) {
            val x = Gdx.input.x.toFloat()
            val y = Gdx.graphics.height - Gdx.input.y.toFloat()

            //  botão "Configuração"
            if (x in 550f..1550f && y in (Gdx.graphics.height - 3270f)..(Gdx.graphics.height - 2270f)) {
                mainGame.setScreen<ConfigScreen>()
            }

            //  botão "Loja"
            if (x in 80f..280f && y in (Gdx.graphics.height - 270f)..(Gdx.graphics.height - 70f)) {
                mainGame.setScreen<LojaScreen>()
            }

            // botão "Editar"
            if (x in 300f..500f && y in (Gdx.graphics.height - 270f)..(Gdx.graphics.height - 70f)) {
                mainGame.setScreen<EditScreen>()
            }

            // botão "Livros"
            if (x in 520f..820f && y in (Gdx.graphics.height - 270f)..(Gdx.graphics.height - 70f)) {
                mainGame.setScreen<BooksScreen>()
            }

            //  botão "Investimentos"
            if (x in 850f..1050f && y in (Gdx.graphics.height - 270f)..(Gdx.graphics.height - 70f)) {
                mainGame.setScreen<InvestimentoScreen>()
            }

            //  botão "RPG de texto"
            if (x in 1070f..1270f && y in (Gdx.graphics.height - 270f)..(Gdx.graphics.height - 70f)) {
                mainGame.setScreen<RpgScreen>()
            }

            // botao de fechar
            if (x in 1000f..1400f && y in (Gdx.graphics.height - 2520f)..(Gdx.graphics.height - 2120f)) {
                mainGame.setScreen<HomeScreen>()
            }

        }
    }

    override fun dispose() {
        infocapicoin.disposeSafely()
        infohud.disposeSafely()
        configbutton.disposeSafely()
        batch.disposeSafely()
        shapeRenderer.dispose()
        lojabutton.disposeSafely()
        editbutton.disposeSafely()
        booksbutton.disposeSafely()
        investimentobutton.disposeSafely()
        rpgbutton.disposeSafely()
        infoboxquatro.disposeSafely()
        closebutton.disposeSafely()
    }

    private fun input(){
        checkButtonClick()
    }

    private fun logic(){

    }

    private fun draw() {
        //ScreenUtils.clear(ColorTheme.YELLOW)

        val screenWidth = Gdx.graphics.width.toFloat()
        val screenHeight = Gdx.graphics.height.toFloat()

        batch.use {
            it.draw(background, 0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        }

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            // Retângulo superior
            it.color = ColorTheme.BLUE
            it.rect(0f, Gdx.graphics.height - 220f, Gdx.graphics.width.toFloat(), 300f)

            // Retângulo inferior
            it.color = ColorTheme.BLUE
            it.rect(0f, 0f, Gdx.graphics.width.toFloat(), 300f)
        }

        batch.use {

            it.draw(infocapicoin, 20f, 2595f, 400f, 250f)
            it.draw(infohud, 200f, 2235f, 1000f, 1000f)
            it.draw(infohud, 500f, 2235f, 1000f, 1000f)

            it.draw(configbutton, 1020f, 2565f, 300f, 300f)

            it.draw(lojabutton, 80f, 50f, 200f, 200f)
            it.draw(editbutton, 300f, 50f, 200f, 200f)
            it.draw(booksbutton, 520f, 50f, 300f, 300f)
            it.draw(investimentobutton, 850f, 50f, 200f, 200f)
            it.draw(rpgbutton, 1070f, 50f, 200f, 200f)

            it.draw(infoboxquatro, 5f, 420f, 1350f, 2000f)
            it.draw(closebutton, 1000f, 2120f, 400f, 400f)


        }
    }
    }
