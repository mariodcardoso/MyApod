package br.com.myapod.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.myapod.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
    }
}
