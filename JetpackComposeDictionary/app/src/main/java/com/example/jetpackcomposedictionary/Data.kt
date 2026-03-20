
package com.example.jetpackcomposedictionary


import android.content.Context

fun loadDictionary(context: Context): Map<String, String> {
    val map = mutableMapOf<String, String>()

    try {
        val inputStream = context.assets.open("dictionary.txt")

        inputStream.bufferedReader().forEachLine { line ->
            val parts = line.split(",")

            if (parts.size == 2) {
                val key = parts[0].trim()
                val value = parts[1].trim()

                map[key] = value
                map[value] = key
            }
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }

    return map
}

fun searchInDictionary(
    dictionary: Map<String, String>,
    query: String
): String {
    return dictionary[query.trim()] ?: "Not found"
}