package br.com.capyensina.main.android

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Toolbar
import androidx.annotation.RequiresApi

import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import br.com.capyensina.main.Main

/** Launches the Android application. */
class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize(Main(), AndroidApplicationConfiguration().apply {
            useImmersiveMode = true // Recommended, but not required.
            renderUnderCutout = false
        })
    }
}
