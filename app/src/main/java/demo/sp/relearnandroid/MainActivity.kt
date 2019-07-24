package demo.sp.relearnandroid

import android.app.LauncherActivity
import android.app.job.JobInfo
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate
import android.view.Menu
import android.view.MenuItem
import demo.sp.relearnandroid.service.LocalService

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()

//            startService(Intent(this, LocalService::class.java))

            var bitmap1 = BitmapFactory.decodeResource(resources, R.mipmap.test)
            var bitmap2 = BitmapFactory.decodeResource(resources, R.mipmap.test)
            var bitmap3 = BitmapFactory.decodeResource(resources, R.mipmap.test)

        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
