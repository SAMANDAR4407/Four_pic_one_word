package uz.gita.fourpicsoneword.ui.game

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import uz.gita.forpicsoneword.R
import uz.gita.fourpicsoneword.model.QuestionData
import uz.gita.fourpicsoneword.ui.info.InfoActivity


class GameActivity : AppCompatActivity(), GameContract.View {
    private val images = ArrayList<ImageView>(4)
    private var variants = ArrayList<TextView>()
    private var answers = ArrayList<TextView>()
    private var currentPos = 0
    private lateinit var textPos: AppCompatTextView
    private lateinit var presenter: GameContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        loadViews()
        presenter = GamePresenter(this)
        attachClickListeners()
    }

    private fun loadViews() {
        images.add(findViewById(R.id.imageOne))
        images.add(findViewById(R.id.imageTwo))
        images.add(findViewById(R.id.imageThree))
        images.add(findViewById(R.id.imageFour))

        textPos = findViewById(R.id.currentPos)

        val variantLine1: LinearLayoutCompat = findViewById(R.id.variantLine1)
        val variantLine2: LinearLayoutCompat = findViewById(R.id.variantLine2)

        for (i in 0 until variantLine1.childCount) {
            variants.add(variantLine1.getChildAt(i) as TextView)
        }
        for (i in 0 until variantLine2.childCount) {
            variants.add(variantLine2.getChildAt(i) as TextView)
        }

        val answerLine: LinearLayoutCompat = findViewById(R.id.answerLine)

        for (i in 0 until answerLine.childCount) {
            answers.add(answerLine.getChildAt(i) as TextView)
        }

    }

    override fun describeQuestion(data: QuestionData, currentPos: Int, totalCount: Int) {
        this.currentPos = currentPos
        textPos.text = "Level: ${currentPos + 1} / $totalCount"

        images[0].setImageResource(data.image1ResID)
        images[1].setImageResource(data.image2ResID)
        images[2].setImageResource(data.image3ResID)
        images[3].setImageResource(data.image4ResID)

        for (i in variants.indices) {
            variants[i].text = data.variant[i].toString()
            variants[i].isEnabled = true
        }

        for (i in answers.indices) {
            answers[i].text = ""
            answers[i].isEnabled = false
        }
    }

    override fun resizeAnswerButtons(length: Int) {
        for (i in 0 until length) {
            answers[i].visibility = View.VISIBLE
        }

        for (i in length until answers.size) {
            answers[i].visibility = View.GONE
        }
    }

    override fun showValueToAnswer(text: String, pos: Int) {
        val index = getFirstEmptyPos()
        if (index != -1) {
            answers[index].text = text
            answers[index].tag = pos
            variants[pos].text = ""
            variants[pos].isEnabled = false
            answers[index].isEnabled = true
        }
    }

    override fun showValueToVariant(text: String, pos: Int, tag: Int) {
        variants[tag].text = text
        variants[tag].isEnabled = true
        answers[pos].text = ""
        answers[pos].isEnabled = false
    }

    override fun showWinDialog(answer: String) {

        val view = layoutInflater.inflate(R.layout.dialog, null)
        val btnNext: TextView = view.findViewById(R.id.btn_next)
        val finalAnswer: TextView = view.findViewById(R.id.finalAnswer)
        val animZoomIn: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)

        val builder = AlertDialog.Builder(
            this,
            android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen
        )
            .setView(view)
            .setCancelable(false)
        val dialog: AlertDialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        finalAnswer.text = answer
        view.startAnimation(animZoomIn).apply {
            finalAnswer.animate().apply {
                duration = 1200
                rotationXBy(720f)
            }.start()
        }

        btnNext.setOnClickListener {
            if (presenter.btnNextClicked()) {
                dialog.dismiss()
            } else {
                val intent = Intent(this, InfoActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                dialog.dismiss()
            }
        }
    }

    override fun showToast(toast: String) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
    }

    private fun getUserFullAnswer(): String {
        val sb = StringBuilder()
        for (i in answers.indices) {
            sb.append(answers[i].text.toString())
        }
        return sb.toString()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun attachClickListeners() {
        findViewById<AppCompatImageView>(R.id.buttonBack).setOnClickListener {
            presenter.saveLastPos(currentPos)
            finish()
        }
        for (i in variants.indices) {
            variants[i].setOnClickListener {
                variants[i].animate().apply {
                    duration = 400
                    rotationYBy(360f)
                }.start()
                presenter.btnVariantClicked(variants[i].text.toString(), i)
                presenter.checkUserAnswer(getUserFullAnswer())
            }
        }
        for (i in answers.indices) {
            answers[i].setOnClickListener {
                answers[i].animate().apply {
                    duration = 400
                    rotationYBy(360f)
                }.start()
                val tagPos = answers[i].tag as Int
                presenter.btnAnswerClicked(answers[i].text.toString(), i, tagPos)
            }
        }
    }

    private fun getFirstEmptyPos(): Int {
        for (i in answers.indices) {
            if (answers[i].text.toString().isEmpty() && answers[i].visibility == View.VISIBLE) {
                return i
            }
        }
        return -1
    }

    override fun onStart() {
        super.onStart()
        Log.d("TTT", "onStart: called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TTT", "onPause: called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TTT", "onResume: called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TTT", "onRestart: called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TTT", "onDestroy: called")
    }
}