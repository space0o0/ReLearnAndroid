package demo.sp.relearnandroid.handler

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import demo.sp.relearnandroid.R
import kotlinx.android.synthetic.main.activity_example_h.*

class ExampleHActivity : AppCompatActivity() {

    val Tag = javaClass.simpleName

    lateinit var mainHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_h)

    }

    override fun onResume() {
        super.onResume()

        button3.setOnClickListener {

            otherThreadsendMessage()
        }
    }

    /**
     * 1.新建handler
     */
    fun initHandler() {
        mainHandler = @SuppressLint("HandlerLeak")
        object : Handler() {
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                //接收不同的消息，做不同的处理
            }
        }
    }

    /**
     * 2.发送消息
     */
    fun sendMessage(){
        mainHandler.sendMessage(Message())
    }

    private fun otherThreadsendMessage() {

        Thread(Runnable {
            Log.d(Tag, "子线程：" + Thread.currentThread().name)
//            textView.text = "thread change view success"

//            Looper.prepare()
            val threadHandler = object : Handler(Looper.getMainLooper()) {
                override fun handleMessage(msg: Message?) {
//                    textView.text = "thread change view success"
//                    textView.text = "thread change view success"


                    var newTV = TextView(this@ExampleHActivity)
                    newTV.text = "hohohooooooh~"
                    this@ExampleHActivity.addContentView(
                        newTV,
                        ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    )

//                    Toast.makeText(this@ExampleHActivity,"ccccc",Toast.LENGTH_LONG).show()
                    Log.d(Tag, "handlerMessage：" + Thread.currentThread().name)
                }
            }

            threadHandler.sendEmptyMessage(0)
//            Looper.loop()

        }).start()
    }
}
