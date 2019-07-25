package demo.sp.relearnandroid.aidl

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import demo.sp.relearnandroid.R
import kotlinx.android.synthetic.main.activity_aidl.*

class AIDLActivity : AppCompatActivity() {

    val TAG = "AIDLActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aidl)

        start.setOnClickListener {
            // todo bind ReomteService

//            startService(Intent(this@AIDLActivity, RemoteService::class.java))

            bindService(Intent(this@AIDLActivity, RemoteService::class.java), sc, Context.BIND_AUTO_CREATE)
        }

    }

    var sc = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG,"onServiceDisconnected")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(TAG,"onServiceConnected")
        }
    }
}
