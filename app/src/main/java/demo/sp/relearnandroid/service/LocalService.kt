package demo.sp.relearnandroid.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class LocalService : Service() {

    private val TAG: String = javaClass.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStart")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}