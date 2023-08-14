package uz.gita.fourpicsoneword.ui.game

import uz.gita.fourpicsoneword.model.QuestionData

interface GameContract {
    interface Model {
        fun getNextQuestion(): QuestionData
        fun getAnswer():String
        fun hasQuestion():Boolean
        fun getCurrentPosition() : Int
        fun getQuestionAmount() : Int
        fun savePos(pos: Int)
    }

    interface Presenter{
        fun btnVariantClicked(text:String,pos:Int)
        fun btnAnswerClicked(text: String,pos: Int,tag:Int)
        fun checkUserAnswer(answer: String)
        fun btnNextClicked():Boolean
        fun saveLastPos(pos: Int)
    }

    interface View {
        fun describeQuestion(data: QuestionData, currentPos : Int, totalCount : Int)
        fun resizeAnswerButtons(length:Int)
        fun showValueToAnswer(text: String,pos: Int)
        fun showValueToVariant(text: String,pos: Int,tag: Int)
        fun showWinDialog(answer: String)
        fun showToast(toast:String)
    }
}