package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_help.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("BMI說明")
                .setMessage("體重(kg)/身高的平方(m)")
                .setPositiveButton("OK",null)
                .show()
        }
    }
    fun bmi(view:View){
        val weight = ed_weight.text.toString().toFloat()
        val height = ed_height.text.toString().toFloat()
        val bmi = weight/(height*height)
        Log.d("BMI",bmi.toString())
//        複雜方式Bundle
        Intent(this,ResultActivity::class.java).apply {
            val bag = Bundle()
            bag.putFloat("BMI_EXTRA",bmi)
            bag.putString("TEST_EXTRA","Testing")
            putExtras(bag)
            startActivity(this)
        }
/*
//第一種單筆資料傳遞方式
        Intent(this,ResultActivity::class.java).apply {
            putExtra("BMI_EXTRA",bmi)
            startActivity(this)
        }
// 第二種單筆資料傳遞方式
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("BMI_EXTRA",bmi)
          startActivity(intent)
         */

     /*提示訊息註解
        Toast.makeText(this,bmi.toString(),Toast.LENGTH_SHORT).show()
        AlertDialog.Builder(this)
            .setTitle("Your BMI")
            .setMessage(bmi.toString())
            .setPositiveButton("OK",null)
            .setNegativeButton("Cancel",null)
            .show()*/
    }
}
