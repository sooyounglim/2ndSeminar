package com.stellar1198gmail.secondstagram

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            btn_main_home -> {
                clearSelected()
                btn_main_home.isSelected = true
                replaceFragment(HomePage())
            }
            btn_main_mine -> {
                clearSelected()
                btn_main_mine.isSelected = true
                replaceFragment(MineTab())
            }
            btn_main_add -> {
                val intent = Intent(applicationContext, AddActivity::class.java)
                intent.putExtra("add_image", R.drawable.add_image)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        addFragment(HomePage())

        btn_main_home.isSelected = true
        btn_main_home.setOnClickListener(this)
        btn_main_mine.isSelected = true
        btn_main_mine.setOnClickListener(this)
        btn_main_add.setOnClickListener(this)
    }

    fun addFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun clearSelected(){
        btn_main_home.isSelected = false
        btn_main_mine.isSelected = false
    }
}
