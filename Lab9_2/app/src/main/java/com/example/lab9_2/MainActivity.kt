package com.example.lab9_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnDeleteAll: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDeleteAll = findViewById(R.id.btnDeleteAll)

        // Lắng nghe sự kiện click vào nút "Xóa tất cả"
        btnDeleteAll.setOnClickListener {
            showDeleteConfirmationDialog()
        }
    }

    // Hiển thị AlertDialog xác nhận
    private fun showDeleteConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Xóa tất cả")
        builder.setMessage("Bạn có chắc chắn muốn xóa toàn bộ dữ liệu không?")

        // Nút "Xác nhận"
        builder.setPositiveButton("Xác nhận") { dialog, _ ->
            Toast.makeText(this, "Đã xóa dữ liệu", Toast.LENGTH_SHORT).show()
            dialog.dismiss()  // Đóng Dialog sau khi xác nhận
        }

        // Nút "Hủy"
        builder.setNegativeButton("Hủy") { dialog, _ ->
            dialog.dismiss()  // Đóng Dialog khi người dùng chọn Hủy
        }

        // Tạo và hiển thị AlertDialog
        val alertDialog = builder.create()
        alertDialog.show()
    }
}
