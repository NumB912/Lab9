package com.example.lab9_3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var btnShowDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tvName)
        btnShowDialog = findViewById(R.id.btnShowDialog)

        btnShowDialog.setOnClickListener {
            showNameInputDialog()
        }
    }

    private fun showNameInputDialog() {
        val input = EditText(this)
        input.hint = "Nhập tên của bạn"
        input.setBackgroundResource(R.drawable.rounded_edittext)  // Nền và viền của EditText
        input.setPadding(24, 24, 24, 24)  // Padding cho EditText
        input.setHintTextColor(resources.getColor(android.R.color.darker_gray))  // Màu chữ cho Hint

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Nhập tên")
            .setMessage("Vui lòng nhập tên của bạn:")
            .setView(input)
            .setPositiveButton("Lưu") { dialog, _ ->
                val name = input.text.toString()
                if (name.isNotEmpty()) {
                    tvName.text = "Tên người dùng: $name"
                } else {
                    tvName.text = "Tên người dùng chưa được nhập"
                }
                dialog.dismiss()
            }
            .setNegativeButton("Hủy") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
