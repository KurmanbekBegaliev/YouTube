package com.example.youtube.lasthomework.d

//Плуг
class PlowImpl : PlowInterface {
    override fun plowing(hectares: Int) {
        println("$hectares hectares of field plowed")
    }
}