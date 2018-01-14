package org.gabriel.moviebudget.utils

import android.support.annotation.StringRes
import android.widget.EditText
import android.widget.SearchView

// jobb lenne lazy propertyvel de az extension propertyknél nem használható
val SearchView.editText: EditText
    get() {
        val id = context.resources.getIdentifier("android:id/search_src_text", null, null)
        return findViewById(id)
    }

fun SearchView.setError(error: String?) {
    editText.error = error
}

fun SearchView.setError(@StringRes errorRes: Int, vararg formatArgs: Any) {
    editText.error = context.getString(errorRes, formatArgs)
}