package com.example.youtube.lasthomework.i

//Interface segregation principle
interface ItemClick {
    fun onclick()
    fun onLongClick()
    fun onShortClick()
}

class JustClick : ItemClick {
    override fun onclick() {

    }

    //В случаи эсли нам нужна только первая функция то эти функции ниже будут лишними
    override fun onLongClick() {
    }

    override fun onShortClick() {
    }

}

//По принципу мы должны разделить функциональность интерфейса ItemClick на много конкретных
//интерфейсов
interface Click {
    fun onClick()
}

interface LongClick {
    fun onLongClick()
}

interface ShortClick {
    fun onShortClick()
}

class Clicker : Click, LongClick {
    override fun onClick() {
    }

    override fun onLongClick() {
    }

}