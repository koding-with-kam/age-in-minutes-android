package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
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
        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, selectedYear, selectedMonth, selectedDay ->
                // Create selected date string
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"

                // Format date
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val formattedDate = sdf.parse(selectedDate)

                // Set Date Text in UI
                val selectedDateText = findViewById<TextView>(R.id.selectedDate)
                selectedDateText.text = selectedDate

                // Get time of selected date in minutes
                val selectedDateInMinutes = formattedDate!!.time / 60000

                // Get current date
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate!!.time / 60000
                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                // Set Time Text in UI
                val ageInMinutes = findViewById<TextView>(R.id.ageInMinutes)
                ageInMinutes.text = "$differenceInMinutes"

            }, year, month, day)

        dpd.datePicker.maxDate = Date().time - 86400000
        dpd.show()
    }
}