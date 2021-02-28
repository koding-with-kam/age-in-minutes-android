package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener {
            clickDatePicker(it)
        }
    }

    fun clickDatePicker(view: View) {
        // Using calendar class to create object
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        // Open Date picker dialog
        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, day ->

            }, year, month, day).show()
    }
}