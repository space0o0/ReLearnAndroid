package demo.sp.relearnandroid.customIPC.server

import android.os.Binder
import android.os.IBinder
import android.os.IInterface
import android.os.Parcel

abstract class Stub : Binder(), IBookManager {

    init {
        this.attachInterface(this, DESCRIPTOR)
    }

    companion object {

        val DESCRIPTOR = "customIPC.server.stub"
        val TRANSACTION_add = android.os.IBinder.FIRST_CALL_TRANSACTION + 0

        fun asInterface(binder: IBinder): IBookManager? {
            if (binder == null) {
                return null
            }

            var iInterface: IInterface? = binder.queryLocalInterface(DESCRIPTOR)
            if (iInterface != null && iInterface is IBookManager) {
                return iInterface
            }

            return Proxy(binder)
        }

    }

    override fun asBinder(): IBinder {
        return this
    }

    override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
        when (code) {
            IBinder.INTERFACE_TRANSACTION -> {
                reply?.writeString(DESCRIPTOR)
            }
            TRANSACTION_add -> {
                data.enforceInterface(DESCRIPTOR)
                var _arg0 = data.readString()
                add(_arg0)
                reply?.writeNoException()
                return true
            }
        }

        return true
    }
}