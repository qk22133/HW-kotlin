package com.example.lab2_paperscissor

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioButton
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private var ed_name: EditText = findViewById(R.id.ed_name)
    private var tv_text: TextView = findViewById(R.id.tv_text)
    private var tv_name: TextView = findViewById(R.id.tv_name)
    private var tv_winner: TextView = findViewById(R.id.tv_winner)
    private var tv_mmora: TextView = findViewById(R.id.tv_mmora)
    private var tv_cmora: TextView = findViewById(R.id.tv_cmora)
    private var btn_scissor: RadioButton = findViewById(R.id.btn_scissor)
    private var btn_stone: RadioButton = findViewById(R.id.btn_stone)
    private var btn_paper: RadioButton = findViewById(R.id.btn_paper)
    private var btn_mora: Button = findViewById(R.id.btn_mora)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_mora.setOnClickListener() {
            if (ed_name.length() < 1) tv_text.text = "請輸入玩家姓名"
            else {
                tv_name.text =  "名字\n%s" + ed_name.text
                if (btn_scissor.isChecked) tv_mmora.text = "我方出拳\n剪刀"

                else if (btn_stone.isChecked) tv_mmora.text = "我方出拳\n石頭"

                else tv_mmora.text = "我方出拳\n布"
                val computer = (Math.random() * 3).toInt()
                if (computer == 0) tv_cmora.text = "電腦出拳\n剪刀"
                else if (computer == 1) tv_cmora.text = "電腦出拳\n石頭"
                else tv_cmora.text = "電腦出拳\n布"
                if (btn_scissor.isChecked && computer == 2 ||
                        btn_stone.isChecked && computer == 0 ||
                        btn_paper.isChecked && computer == 1)
                {
                    tv_winner.text = """勝利者${ed_name.text}""".trimIndent()
                    tv_text.text = "恭喜你獲勝了!!!"
                }
                else if (btn_scissor.isChecked && computer == 1 ||
                        btn_stone.isChecked && computer == 2 ||
                        btn_paper.isChecked && computer == 0)
                {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜，電腦獲勝了"
                }
                else {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局，請再試一次"
                }
            }
        }
    }
}