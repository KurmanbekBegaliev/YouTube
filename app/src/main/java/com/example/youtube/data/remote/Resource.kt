package com.example.youtube.data.remote

class Resource<out T>(val status: Status, val data: T?, val msg: String?) {
    companion object {
        fun <T>success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data = data, null)
        }

        fun <T>error(msg: String?): Resource<T> {
            return Resource(Status.ERROR, data = null, msg = msg)
        }

        fun <T>loading(): Resource<T> {
            return Resource(Status.LOADING, data = null, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}