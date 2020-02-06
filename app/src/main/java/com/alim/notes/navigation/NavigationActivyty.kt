package com.alim.notes.navigation

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View

import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.alim.notes.R
import kotlinx.android.synthetic.main.activity_navigation_activyty.*

class NavigationActivyty : AppCompatActivity() {



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->


        when(item.itemId){

            R.id.navigation_task ->{
                messageTextView.setText(getText(R.string.title_task))
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_note ->{
                messageTextView.setText(getText(R.string.title_note))
                return@OnNavigationItemSelectedListener true
            }


        }



        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_activyty)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)


        messageTextView.setText(getText(R.string.title_task))
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)


    }
}
