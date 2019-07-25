package demo.sp.relearnandroid.customIPC.server

import android.os.IBinder
import android.os.Parcel

class Proxy(private var remote: IBinder) : IBookManager {

    override fun asBinder(): IBinder {
        return remote
    }

    override fun add(bookName: String) {
        var data = Parcel.obtain()
        var reply = Parcel.obtain()

        data.writeInterfaceToken(Stub.DESCRIPTOR)

        data.writeString(bookName)

        remote.transact(Stub.TRANSACTION_add, data, reply, 0)
        reply.readException()

        data.recycle()
        reply.recycle()
    }
}