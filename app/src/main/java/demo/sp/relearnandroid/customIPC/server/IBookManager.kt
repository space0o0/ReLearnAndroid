package demo.sp.relearnandroid.customIPC.server

import android.os.IInterface

interface IBookManager : IInterface {

    //添加书名
    fun add(bookName: String)
}