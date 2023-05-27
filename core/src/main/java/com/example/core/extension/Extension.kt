package com.example.core.extension

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.showFragment(
    fragment: Fragment,
    containerId: Int,
    addToBackStack: Boolean = true,
) {
    this.beginTransaction()
        .replace(containerId, fragment, fragment::class.java.name)
        .also { transaction ->
            if (addToBackStack) transaction.addToBackStack(fragment::class.java.name)
        }
        .commitAllowingStateLoss()
}

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}