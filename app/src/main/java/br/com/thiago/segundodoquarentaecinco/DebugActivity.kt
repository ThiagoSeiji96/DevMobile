package br.com.thiago.segundodoquarentaecinco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class DebugActivity : AppCompatActivity() {

    private val TAG = "LMSApp"
    private val className: String
        get() {
            val s = javaClass.name // br.com.thiago.segundodoquarentaecinco.DebugActivity
            return s.substring(s.lastIndexOf(".")) // .DebugActivity
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className.onCreate() Chamado")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className.Onstart() chamado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$className.onResume() Chamado")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$className.onPause() Chamado")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$className.onStop() Chamado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$className.onDestroy() Chamado")
    }
}