package uz.gita.fourpicsoneword.model

data class QuestionData(
    val image1ResID: Int,
    val image2ResID: Int,
    val image3ResID: Int,
    val image4ResID: Int,
    val variant: String,
    val answer: String
)


