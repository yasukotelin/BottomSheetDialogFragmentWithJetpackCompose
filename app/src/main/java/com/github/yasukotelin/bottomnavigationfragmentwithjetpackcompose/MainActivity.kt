package com.github.yasukotelin.bottomnavigationfragmentwithjetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.yasukotelin.bottomnavigationfragmentwithjetpackcompose.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}