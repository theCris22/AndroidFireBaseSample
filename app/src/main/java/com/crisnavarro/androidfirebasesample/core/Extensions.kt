package com.crisnavarro.androidfirebasesample.core

import android.util.Patterns
import android.view.View

fun String.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()
fun View.show() { this.visibility = View.VISIBLE }
fun View.hide() { this.visibility = View.GONE }
