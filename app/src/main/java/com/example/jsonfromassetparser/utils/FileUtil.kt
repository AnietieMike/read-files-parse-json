package com.example.jsonfromassetparser.utils

import android.content.Context
import java.io.IOException

object FileUtil {

    /*
    * Returns a string representation of the content of the given file name.
    *
    * @throws IOException If unable to locate, read or open the given file name.
    * */
    @JvmStatic
    @Throws(IOException::class)
    fun readFileToString(filename: String, context: Context): String? {
        // Create an InputStream variable using AssetManager to access and open file
        val inputStream = context.assets.open(filename)

        // Create a buffer of the size of the file
        val buffer = ByteArray(inputStream.available())

        // Read the inputStream file into the buffer and close the stream
        inputStream.read(buffer)
        inputStream.close()

        return String(buffer, charset("UTF-8"))
    }

    @Throws(IOException::class)
    fun readFile(filename: String, context: Context): String {
        return  context.assets.open(filename)
            .bufferedReader(charset("UTF-8")).use { it.readText() }
    }

}