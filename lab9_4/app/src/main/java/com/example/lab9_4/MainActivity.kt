package com.example.lab9_4

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }


    // Phương thức này được gọi để tạo menu khi Activity tạo ra
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate menu từ XML vào menu (ta sẽ tạo file menu ở bước sau)
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    // Phương thức này xử lý sự kiện khi người dùng chọn một mục trong menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                // Hiển thị thông báo khi chọn "Tìm kiếm"
                Toast.makeText(this, "Chức năng Tìm kiếm đang được thực thi", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_settings -> {
                // Hiển thị thông báo khi chọn "Cài đặt"
                Toast.makeText(this, "Chức năng Cài đặt đang được thực thi", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_share -> {
                // Hiển thị thông báo khi chọn "Chia sẻ"
                Toast.makeText(this, "Chức năng Chia sẻ đang được thực thi", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
