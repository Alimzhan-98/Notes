package com.alim.notes.navigation

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alim.notes.R
import com.alim.notes.notes.NotesListFragment
import com.alim.notes.tasks.TasksListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivyty : AppCompatActivity() {



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->


        when(item.itemId){

            R.id.navigation_task ->{
                replaceFragment(TasksListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_note ->{
                replaceFragment(NotesListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }


        }



        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_activyty)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        replaceFragment(TasksListFragment.newInstance())
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.
                beginTransaction()
                .replace(R.id.fragmentHolder,fragment)
                .commit()
    }


    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)


    }
}
