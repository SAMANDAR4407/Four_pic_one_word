package uz.gita.fourpicsoneword.ui.game

import android.util.Log

class GamePresenter(private val view: GameContract.View) : GameContract.Presenter {

    private val model: GameContract.Model = GameModel()

    init {
        loadQuestion()
    }

    override fun btnVariantClicked(text: String, pos: Int) {
        view.showValueToAnswer(text, pos)
    }

    override fun btnAnswerClicked(text: String, pos: Int, tag: Int) {
        view.showValueToVariant(text, pos, tag)
    }

    override fun checkUserAnswer(answer: String) {
        if (model.getAnswer().equals(answer, false)) {
            Log.d("TTT", "checkUserAnswer: $answer")
            view.showWinDialog(answer)
        }
        Log.d("TTT", "checkUserAnswer: actual: ${model.getAnswer()} , coming: $answer")
    }

    override fun btnNextClicked(): Boolean {
        if (model.hasQuestion()) {
            model.savePos(model.getCurrentPosition())
            loadQuestion()
            return true
        }
        model.savePos(0)
        return false
    }

    override fun saveLastPos(pos: Int) {
        model.savePos(pos)
    }

    private fun loadQuestion(){
        val data = model.getNextQuestion()
        view.describeQuestion(data, model.getCurrentPosition()-1, model.getQuestionAmount())
        view.resizeAnswerButtons(data.answer.length)
    }
}

