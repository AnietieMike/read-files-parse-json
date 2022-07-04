package com.example.jsonfromassetparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jsonfromassetparser.models.BillMerchantsItem
import com.example.jsonfromassetparser.utils.FileUtil
import com.example.jsonfromassetparser.utils.gsonToKotlinObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonString = FileUtil.readFileToString("bill-merchants.json", applicationContext)

        val billItemsFromGson = jsonString?.gsonToKotlinObject<List<BillMerchantsItem>>()
        billItemsFromGson?.forEachIndexed { idx, billItem -> Log.i("From Gson", "> Item $idx:\n$billItem") }

    }
}