package com.alim.notes.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alim.notes.R
import com.alim.notes.navigation.NavigationActivyty
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)


        intent.getStringExtra(NavigationActivyty.FRAGMENT_TYPE_KEY).run {


            textView.text = if(this == NavigationActivyty.FRAGMENT_VALUE_TASK){
                "this is task!"
            }else if (this == NavigationActivyty.FRAGMENT_VALUE_NOTE){
                "this is note!"
            }else{
                "something went wrong!"
            }

        }

    }
}
