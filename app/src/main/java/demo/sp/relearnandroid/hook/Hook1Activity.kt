package demo.sp.relearnandroid.hook

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import demo.sp.relearnandroid.R
import kotlinx.android.synthetic.main.activity_hook1.*
import java.lang.reflect.Method
import java.util.*

class Hook1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hook1)

        btn.setOnClickListener {
            Log.i(javaClass.simpleName, "click btn")
        }

//        getAllMethod()
        hookClick(btn)

        //放app
        var service: IService = ServiceImpl()

        //@autoWire()
        //IService service
    }

    //放lib
    interface IService {
        fun add()
    }

    //放组件
    class ServiceImpl : IService {
        override fun add() {
            println("add")
        }
    }

    @SuppressLint("DiscouragedPrivateApi")
    fun hookClick(view: View) {
        //reflect view->ClickListener

        //寻找到View中的getListenerInfo方法
        var getListenerInfo = View::class.java.getDeclaredMethod("getListenerInfo")
        getListenerInfo.isAccessible = true

        var listener: Any = getListenerInfo.invoke(view)//获取到ListenerInfo

        var field = listener.javaClass.getDeclaredField("mOnClickListener")//获取属性

        field.isAccessible = true

        field.set(listener, HookClickListener(field.get(listener) as View.OnClickListener))//修改属性
    }

    fun getAllMethod() {

        var methods = View::class.java.declaredMethods

        Log.i(javaClass.simpleName, "-----")
    }

    class HookClickListener(var mClick: View.OnClickListener) : View.OnClickListener {

        override fun onClick(v: View?) {

            Toast.makeText(v?.context, "hook start", Toast.LENGTH_LONG).show()

            mClick.onClick(v)

        }

    }
}
