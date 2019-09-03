package demo.sp.relearnandroid.autoProxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class AutoProxyHandler(var obj: Any) : InvocationHandler {

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {

        println("the proxy method is ${method?.name}")

        val result = method?.invoke(obj, args)

        return result!!
    }
}