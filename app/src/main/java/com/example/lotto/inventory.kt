package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView
import java.util.*

class LottoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto)

        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        // 중복되지 않는 랜덤한 로또 번호 생성
        val lottoNumbers = generateLottoNumbers()

        // 생성된 로또 번호를 텍스트뷰에 출력
        textViewResult.text = "로또 번호: ${lottoNumbers.joinToString(", ")}"

        // InventoryActivity로 생성된 로또 번호 전달
        val intent = Intent(this, InventoryActivity::class.java)
        intent.putIntegerArrayListExtra("lottoNumbers", ArrayList(lottoNumbers))
        startActivity(intent)
    }

    // 중복되지 않는 랜덤한 로또 번호 생성 함수
    private fun generateLottoNumbers(): List<Int> {
        val lottoNumbers = mutableListOf<Int>()
        val random = Random()

        // 1부터 50까지의 번호를 가진 리스트 생성
        val numbers = mutableListOf<Int>()
        for (i in 1..50) {
            numbers.add(i)
        }

        // 랜덤하게 7개의 번호 선택
        repeat(7) {
            val index = random.nextInt(numbers.size)
            val number = numbers.removeAt(index)
            lottoNumbers.add(number)
        }

        return lottoNumbers
    }
}