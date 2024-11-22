package com.example.lab9_6
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.networkstatus.NetworkChangeReceiver

class MainActivity : AppCompatActivity() {
    private var networkChangeReceiver: NetworkChangeReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo BroadcastReceiver
        networkChangeReceiver = NetworkChangeReceiver()
    }

    override fun onResume() {
        super.onResume()
        // Đăng ký BroadcastReceiver khi Activity hiển thị
        val filter = IntentFilter()
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        registerReceiver(networkChangeReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        // Hủy đăng ký BroadcastReceiver khi Activity không còn hiển thị
        unregisterReceiver(networkChangeReceiver)
    }
}