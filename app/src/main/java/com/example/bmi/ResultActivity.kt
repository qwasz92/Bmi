package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
//複雜取得資料Bundle
        val bundle = intent.extras
        val bmi = bundle?.getFloat("BMI_EXTRA",0f)
        val testing = bundle?.getString("EXTRA_TESTING")
        result.setText(bmi.toString())
/*//複雜取得資料Bundle方式一
val bmi = intent.extras?.getFloat("BMI_EXTRA",0f)
val testing = intent.extras?.getString("EXTRA_TESTING")*/

    /*單筆簡略取得資料
        val bmi = intent.getFloatExtra("BMI_EXTRA",0f)
        result.setText(bmi.toString())
         */
    }
}
