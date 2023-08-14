package uz.gita.fourpicsoneword.model

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper private constructor(context: Context) {
    private var pref : SharedPreferences
    private var editor : SharedPreferences.Editor

    companion object{
        private var instance : PreferenceHelper? = null
        fun init(context: Context){
            if (instance == null)
                instance = PreferenceHelper(context)
        }
        fun getInstance() : PreferenceHelper {
            return instance!!
        }
    }

    init {
        pref = context.getSharedPreferences("SHARED",Context.MODE_PRIVATE)
        editor = pref.edit()
    }

    fun getLastPos() : Int = pref.getInt("LAST_POS",0)

    fun setLastPos(pos: Int){
        editor.putInt("LAST_POS",pos).commit()
    }

}