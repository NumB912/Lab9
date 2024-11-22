package com.example.lab9_5
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var namesList: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        // Khởi tạo danh sách tên và ArrayAdapter
        namesList = mutableListOf("John", "Anna", "Peter", "Marie", "David")
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesList)
        listView.adapter = adapter

        // Đăng ký ContextMenu cho ListView
        registerForContextMenu(listView)

        // Thêm sự kiện chọn item trong ListView
        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Bạn đã chọn: ${namesList[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    // Tạo ContextMenu khi người dùng nhấn giữ vào một phần tử trong ListView
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: android.view.View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        // Chỉ hiển thị ContextMenu khi người dùng nhấn vào ListView
        if (v == listView) {
            val inflater = menuInflater
            inflater.inflate(R.menu.context_menu, menu)
        }
    }

    // Xử lý sự kiện khi người dùng chọn một mục trong ContextMenu
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val position = info.position // Vị trí của item được chọn trong danh sách

        return when (item.itemId) {
            R.id.action_edit -> {
                // Hiển thị AlertDialog cho phép chỉnh sửa tên
                showEditDialog(position)
                true
            }
            R.id.action_delete -> {
                // Xóa tên khỏi danh sách và cập nhật lại ListView
                namesList.removeAt(position)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Đã xóa tên", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    // Hiển thị AlertDialog để chỉnh sửa tên
    private fun showEditDialog(position: Int) {
        val currentName = namesList[position]
        val editText = EditText(this)
        editText.setText(currentName)

        // Tạo AlertDialog để chỉnh sửa tên
        val dialog = AlertDialog.Builder(this)
            .setTitle("Chỉnh sửa tên")
            .setMessage("Vui lòng nhập tên mới:")
            .setView(editText)
            .setPositiveButton("Lưu") { _, _ ->
                val newName = editText.text.toString()
                if (newName.isNotEmpty()) {
                    namesList[position] = newName
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "Tên đã được cập nhật", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Tên không thể trống", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Hủy", null)
            .create()
        dialog.show()
    }
}
