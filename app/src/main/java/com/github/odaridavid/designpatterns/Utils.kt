/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.IntRange
import us.feras.mdv.MarkdownView

fun versionFrom(@IntRange(from = 0, to = 29) versionCodes: Int): Boolean {
    return Build.VERSION.SDK_INT >= versionCodes
}

inline fun <reified T> Activity.navigateTo(noinline intentExtras: ((Intent) -> Unit)? = null) {
    val intent = Intent(this, T::class.java)
    intentExtras?.run {
        intentExtras(intent)
    }
    startActivity(intent)
}

fun checkUrlScheme(url: String): String {
    return if (!url.startsWith("http://") && !url.startsWith("https://"))
        "http://$url"
    else url
}


fun MarkdownView.loadWithKotlinCss(filePath: String) {
    loadMarkdownFile(filePath, KOTLIN_CSS_PATH)
}







