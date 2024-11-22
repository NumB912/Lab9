package com.example.lab9_1

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnSelectDateTime: Button
    private lateinit var tvDateTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSelectDateTime = findViewById(R.id.btnSelectDateTime)
        tvDateTime = findViewById(R.id.tvDateTime)

        // Lắng nghe sự kiện click vào nút
        btnSelectDateTime.setOnClickListener {
            // Mở DatePicker khi người dùng nhấn nút
            showDatePicker()
        }
    }

    // Hiển thị DatePickerDialog để người dùng chọn ngày
    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year1, month1, dayOfMonth ->
                // Sau khi người dùng chọn ngày, hiển thị TimePickerDialog
                showTimePicker(year1, month1, dayOfMonth)
            },
            year, month, day
        )

        datePickerDialog.show()
    }

    // Hiển thị TimePickerDialog để người dùng chọn giờ
    private fun showTimePicker(year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute1 ->
                // Sau khi người dùng chọn giờ, cập nhật TextView với ngày giờ đã chọn
                updateDateTime(year, month, dayOfMonth, hourOfDay, minute1)
            },
            hour, minute, true
        )

        timePickerDialog.show()
    }

    // Cập nhật TextView với ngày và giờ đã chọn
    private fun updateDateTime(year: Int, month: Int, day: Int, hour: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        val formattedDateTime = sdf.format(calendar.time)

        tvDateTime.text = "Ngày và giờ đã chọn: $formattedDateTime"
    }
}
