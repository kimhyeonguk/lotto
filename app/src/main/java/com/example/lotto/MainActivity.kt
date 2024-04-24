package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGenerateRandomNumber = findViewById<Button>(R.id.buttonGenerateRandomNumber)
        val buttonRandomNumberStorage = findViewById<Button>(R.id.buttonRandomNumberStorage)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonSignUp = findViewById<Button>(R.id.buttonSignUp)

        // 랜덤 번호 생성 버튼 클릭 시
        buttonGenerateRandomNumber.setOnClickListener {
            val intent = Intent(this, lotto::class.java)
            startActivity(intent)
        }

        // 랜덤 번호 보관함 버튼 클릭 시
        buttonRandomNumberStorage.setOnClickListener {
            val intent = Intent(this, inventory::class.java)
            startActivity(intent)}

        // 로그인 버튼 클릭 시
        buttonLogin.setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }

        // 회원가입 버튼 클릭 시
        buttonSignUp.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }

    // 랜덤 번호 생성 함수
    private fun generateRandomNumber(): Int {
        return Random().nextInt(100) // 0부터 99까지의 랜덤한 정수 생성
    }