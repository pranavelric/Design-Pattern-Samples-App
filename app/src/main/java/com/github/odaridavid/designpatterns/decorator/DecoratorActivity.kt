package com.github.odaridavid.designpatterns.decorator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.odaridavid.designpatterns.R
import com.github.odaridavid.designpatterns.base.BaseActivity

class DecoratorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decorator)
    }
}
