package uz.gita.fourpicsoneword.ui.game

import android.util.Log
import uz.gita.fourpicsoneword.model.PreferenceHelper
import uz.gita.fourpicsoneword.model.QuestionData
import uz.gita.fourpicsoneword.repository.AppRepository
import uz.gita.fourpicsoneword.ui.game.GameContract

class GameModel : GameContract.Model {

    private val repository = AppRepository.getInstance()
    private var list = ArrayList<QuestionData>()
    private val helper = PreferenceHelper.getInstance()
    private var position = helper.getLastPos()

    init {
        loadListOfQuestions()
    }

    private fun loadListOfQuestions() {
        list.addAll(repository.getListOfData())
    }

    override fun getCurrentPosition(): Int {
        Log.d("TTT", "getCurrentPosition: ${helper.getLastPos()}")
        return position
    }

    override fun getQuestionAmount(): Int = list.size

    override fun savePos(pos: Int) {
        Log.d("TTT", "savePos: $pos")
        helper.setLastPos(pos)
    }

    override fun getNextQuestion(): QuestionData {
//        if (helper.getLastPos() != 0) {
//            return list[helper.getLastPos()]
//        }
        return list[position++]
    }

    override fun getAnswer(): String = list[position-1].answer

    override fun hasQuestion(): Boolean = position < list.size
}
