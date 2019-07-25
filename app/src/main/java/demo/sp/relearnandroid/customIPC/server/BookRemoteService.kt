package demo.sp.relearnandroid.customIPC.server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class BookRemoteService : Service() {

    val TAG = javaClass.simpleName

    private val bookBinder = object : Stub() {
        override fun add(bookName: String) {
            Log.d(TAG, "add $bookName")
        }
    }

    override fun onBind(intent: Intent?): IBinder? {

        return bookBinder
    }
}