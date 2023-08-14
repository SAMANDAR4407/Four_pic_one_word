package uz.gita.fourpicsoneword

import android.app.Application
import uz.gita.fourpicsoneword.model.PreferenceHelper

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.init(this)
    }
}