package br.com.disapps.simplemvvm.ui.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.support.annotation.ColorInt
import android.util.AttributeSet
import android.util.Log

import br.com.disapps.simplemvvm.R


/**
 * Created by Nadim on 29/09/2017.
 */

class CustomEditText : android.support.v7.widget.AppCompatEditText {

    var colorId: Int = 0

    var borderRadius = 0f
        set(value) {
            field = value
            initView()
        }

    var borderStroke = 0
        set(value) {
            field = value
            initView()
        }

    var borderColor = 0
        set(@ColorInt value) {
            field = value
            initView()
        }

    val shape: GradientDrawable = GradientDrawable()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val a = context.obtainStyledAttributes(attrs,
                R.styleable.Options, 0, 0)


        // Border attributes...
        borderRadius = a.getFloat(R.styleable.Options_border_radius, 0f)
        borderStroke = a.getInt(R.styleable.Options_border_stroke, 0)
        borderColor = a.getInt(R.styleable.Options_border_color, 0)

        try {
            val buttonColor = background as ColorDrawable
            colorId = buttonColor.color
            shape.setColor(colorId)
        } catch (ex: Exception) {
            Log.e("parsing error", ex.message)
        }

        a.recycle()

        initView()
        setPadding(20, 20, 20, 20)

    }

    fun initView() {

        shape.cornerRadius = borderRadius
        shape.setStroke(borderStroke, borderColor)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            background = shape
        } else {
            setBackgroundDrawable(shape)
        }

    }

    fun setBorderColor(borderColor: String) {
        this.borderColor = Color.parseColor(borderColor)
        initView()
    }
}
