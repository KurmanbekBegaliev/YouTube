package com.example.youtube.lasthomework.o

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


//Open-closed principle
//По этому принципу классы или интерфейсы должны быть открыты для изменения и закрыты для модификии
fun AppCompatActivity.showToast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
}

