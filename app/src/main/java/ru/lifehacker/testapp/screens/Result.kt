package ru.lifehacker.testapp.screens

sealed class Result<out T> {

    data class Success<out T>(val data: T?): Result<T>()

    data class Failure(val e: Exception?): Result<Nothing>()

}