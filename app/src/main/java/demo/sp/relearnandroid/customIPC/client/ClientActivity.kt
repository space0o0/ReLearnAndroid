package demo.sp.relearnandroid.customIPC.client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import demo.sp.relearnandroid.R
import demo.sp.relearnandroid.customIPC.server.BookRemoteService
import demo.sp.relearnandroid.customIPC.server.IBookManager
import demo.sp.relearnandroid.customIPC.server.Stub
import kotlinx.android.synthetic.main.activity_client.*

class ClientActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    var remote: IBookManager? = null

    var serviceConn = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder) {
            Log.d(TAG, "onServiceConnected")

            remote = Stub.asInterface(service)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        button.setOnClickListener {
            bindService(
                Intent(this@ClientActivity, BookRemoteService::class.java),
                serviceConn,
                Context.BIND_AUTO_CREATE
            )
        }

        button2.setOnClickListener {
            remote?.add("boooooooooknnnnname")
        }

    }
}
