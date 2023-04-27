package com.example.youtube.lasthomework.d


//Dependency inversion principle
class Tractor(private val plowInterface: PlowInterface) {

//    private val plow = PlowImpl()


    fun doWork() {
//        plow.plowing(12)
        plowInterface.plowing(12)
    }

}