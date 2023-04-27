package com.example.youtube.lasthomework.l


//Liskov substitution principle
// Принцип гласит, что поведение методов в дочернем классе должно следовать
// принципам базового класса, а не изменять их
open class Rectangle {
    var width = 0
    var height = 0
}


//Эта функция испортила изначальную идею класса Rectangle, в который заложена логика,
// что стороны могут отличаться
// И поетому несоответсевует принципу
class Square : Rectangle() {
    fun setSize(size: Int) {
        super.width = size
        super.height = size
    }
}