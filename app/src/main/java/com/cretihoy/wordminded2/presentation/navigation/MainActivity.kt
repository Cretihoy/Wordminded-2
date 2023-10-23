package com.cretihoy.wordminded2.presentation.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.cretihoy.wordminded2.data.Storage
import com.cretihoy.wordminded2.presentation.theme.Wordminded2Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var storage: Storage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            storage.loadSettings(this)
            Wordminded2Theme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    RouterScreen()
                }
            }
        }
    }

    override fun onPause() {
        storage.saveSettings()
        super.onPause()
    }
}