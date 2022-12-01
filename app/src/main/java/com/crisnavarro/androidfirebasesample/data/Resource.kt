package com.crisnavarro.androidfirebasesample.data

/*
sealed class Resource <out R> {
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<String>()
    object Loading : Resource<Nothing>()
    object Finished: Resource<Nothing>()
}*/
sealed class Resource <out R> {
    data class Success<out T>(val data: T): Resource<T>()
    data class Error<out T>(val message: String? = null, val data: T? = null): Resource<T>()
}