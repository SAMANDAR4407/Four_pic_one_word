package uz.gita.fourpicsoneword.repository

import uz.gita.forpicsoneword.R
import uz.gita.fourpicsoneword.model.QuestionData

class AppRepository private constructor() {
    companion object {
        private lateinit var instance: AppRepository

        fun getInstance(): AppRepository {
            if (!(Companion::instance.isInitialized))
                instance = AppRepository()
            return instance
        }
    }

    private val list = ArrayList<QuestionData>()

    init {
        loadData()
    }

    private fun loadData() {
        list.add(QuestionData(R.drawable.chair1,R.drawable.chair2,R.drawable.chair3,R.drawable.chair4,"IHCGETUADRYN","CHAIR"))
        list.add(QuestionData(R.drawable.black1,R.drawable.black2,R.drawable.black3,R.drawable.black4,"ADKRBEVCXMLN","BLACK"))
        list.add(QuestionData(R.drawable.duck1,R.drawable.duck2,R.drawable.duck3,R.drawable.duck4,"RKCLAUDMIGSO","DUCK"))
        list.add(QuestionData(R.drawable.eraser1,R.drawable.eraser2,R.drawable.eraser3,R.drawable.eraser4,"REACEAURMISO","ERASER"))
        list.add(QuestionData(R.drawable.blue1,R.drawable.blue2,R.drawable.blue3,R.drawable.blue4,"LQTUBEEGWMIN","BLUE"))
        list.add(QuestionData(R.drawable.ferrari_1,R.drawable.ferrari_2,R.drawable.ferrari_3,R.drawable.ferrari_4,"FLLEROFRJRAI","FERRARI"))
        list.add(QuestionData(R.drawable.bugatti_chiron1,R.drawable.bugatti_chiron2,R.drawable.bugatti_chiron3,R.drawable.bugatti_chiron4,"AUTCBEAIGYTL","BUGATTI"))
        list.add(QuestionData(R.drawable.android1,R.drawable.android2,R.drawable.android3,R.drawable.android4,"DNAUVOREAMID","ANDROID"))
        list.add(QuestionData(R.drawable.panda1,R.drawable.panda2,R.drawable.panda3,R.drawable.panda4,"AEDNCPALSAUD","PANDA"))
        list.add(QuestionData(R.drawable.student1,R.drawable.student2,R.drawable.student3,R.drawable.student4,"NBEAGUTTISDO","STUDENT"))
        list.add(QuestionData(R.drawable.bag1,R.drawable.bag2,R.drawable.bag3,R.drawable.bag4,"AEBEAIRCPFUG","BAG"))
        list.add(QuestionData(R.drawable.success1,R.drawable.success2,R.drawable.success3,R.drawable.success4,"UCSAUSCBEXSL","SUCCESS"))
        list.add(QuestionData(R.drawable.desk1,R.drawable.desk2,R.drawable.desk3,R.drawable.desk4,"GEHKDRXSTBYN","DESK"))
        list.add(QuestionData(R.drawable.white1,R.drawable.white2,R.drawable.white3,R.drawable.white4,"THDTESVEWMIN","WHITE"))
        list.add(QuestionData(R.drawable.green1,R.drawable.green2,R.drawable.green3,R.drawable.green4,"TRDESVEGWMIN","GREEN"))
        list.add(QuestionData(R.drawable.ananas,R.drawable.apple,R.drawable.banana,R.drawable.pomegranate,"AKFDPRUOGHIT","FRUIT"))
        list.add(QuestionData(R.drawable.orange1,R.drawable.orange2,R.drawable.orange3,R.drawable.orange4,"NBEAGAURGYOL","ORANGE"))
        list.add(QuestionData(R.drawable.yellow1,R.drawable.yellow2,R.drawable.yellow3,R.drawable.yellow4,"WBELCRMIGLYO","YELLOW"))
        list.add(QuestionData(R.drawable.finger1,R.drawable.finger2,R.drawable.finger3,R.drawable.finger4,"NABEAIRUGCXF","FINGER"))
        list.add(QuestionData(R.drawable.pencil1,R.drawable.pencil2,R.drawable.pencil3,R.drawable.pencil4,"NAIRUGEBVCPL","PENCIL"))
        list.add(QuestionData(R.drawable.board1,R.drawable.board2,R.drawable.board3,R.drawable.board4,"RIOXTUADBYNF","BOARD"))
        list.add(QuestionData(R.drawable.camel1,R.drawable.camel2,R.drawable.camel3,R.drawable.camel4,"HSCOLAKUEDMI","CAMEL"))
        list.add(QuestionData(R.drawable.shark1,R.drawable.shark2,R.drawable.shark3,R.drawable.shark4,"HCOLASAKUDER","SHARK"))
        list.add(QuestionData(R.drawable.scissor1,R.drawable.scissor2,R.drawable.scissor3,R.drawable.scissor4,"RSELASCLSRIO","SCISSOR"))
        list.add(QuestionData(R.drawable.sleep1,R.drawable.sleep2,R.drawable.sleep3,R.drawable.sleep4,"ELAGLARMIESP","SLEEP"))
        list.add(QuestionData(R.drawable.ice1,R.drawable.ice2,R.drawable.ice3,R.drawable.ice4,"REAGCLAURMIG","ICE"))
        list.add(QuestionData(R.drawable.box1,R.drawable.box2,R.drawable.box3,R.drawable.box4,   "XGTVOREBIHYN","BOX"))
        list.add(QuestionData(R.drawable.husky1,R.drawable.husky2,R.drawable.husky3,R.drawable.husky4,"EYLASCKUIGHO","HUSKY"))
        list.add(QuestionData(R.drawable.mouse1,R.drawable.mouse2,R.drawable.mouse3,R.drawable.mouse4,"OGCLAURMIESP","MOUSE"))
        list.add(QuestionData(R.drawable.game1,R.drawable.game2,R.drawable.game3,R.drawable.game4,"WELAGCLAMIGY","GAME"))

    }

    fun getListOfData(): List<QuestionData> {
        return list
    }
}






