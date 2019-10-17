package android.imd.intentserviceexample

import android.app.IntentService
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import com.example.exemplointentservice.NotificationUtils

class ContadorService: IntentService("myService") {

    private var count: Int = 0
    private var running: Boolean = false

    private val MAX = 10
    private val TAG = "MyTag"

    override fun onHandleIntent(p0: Intent?) {
        Log.d(TAG, ">> ContadorService.onHandleIntent()")

        running = true

        while (running && count < MAX){
            SystemClock.sleep(1000)
            Log.d(TAG, "ContadorService executando ... $count")
            count++
        }

        Log.d(TAG, "<< ContadorService.onHandleIntent()")
        NotificationUtils.notificationSimple(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ContadorService.onDestroy()")
        running = false
    }
}