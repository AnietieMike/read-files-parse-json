package com.example.jsonfromassetparser.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.KClass

fun <T: Any> String.toKotlinObject(c: KClass<T>): T {
    val mapper = Gson()
    return mapper.fromJson(this, c.java)
}

// Create an inlined extension function to covert json string to Kotlin Object using Jackson kotlin module
inline fun <reified T: Any> String.jacksonToKotlinObject(): T {
    val mapper = jacksonObjectMapper()
    return mapper.readValue(this, T::class.java)
}

// Create an inlined extension function to covert json string to Kotlin Object using Gson
inline fun <reified T> String.gsonToKotlinObject(): T {
    return Gson().fromJson(this, object : TypeToken<T>() {}.type)
}