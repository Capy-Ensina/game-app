@file:JvmName("Lwjgl3Launcher")

package br.com.capyensina.main.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import br.com.capyensina.main.Main

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(Main(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Capy-Ensina")
        val WORLD_HEIGHT = 2992/4
        val WORLD_WIDTH = 1344/4
        setWindowedMode(WORLD_WIDTH, WORLD_HEIGHT)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
