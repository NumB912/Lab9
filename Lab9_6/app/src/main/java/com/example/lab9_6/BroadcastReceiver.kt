package com.example.networkstatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo

        // Kiểm tra xem thiết bị có đang kết nối mạng không
        if (networkInfo != null && networkInfo.isConnected) {
            // Nếu có kết nối mạng
            Toast.makeText(context, "Đã kết nối mạng", Toast.LENGTH_SHORT).show()
        } else {
            // Nếu không có kết nối mạng
            Toast.makeText(context, "Không có kết nối mạng", Toast.LENGTH_SHORT).show()
        }
    }
}