package br.com.disapps.simplemvvm.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import br.com.disapps.simplemvvm.R

/**
 * Created by diefferson on 30/11/2017.
 */
class MyEditText : LinearLayout{

    var label : TextView? = null
    var input : CustomEditText? = null
    var description : TextView? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {

        val a = context.obtainStyledAttributes(attrs,
                R.styleable.Options, 0, 0)

        orientation = LinearLayout.VERTICAL;
        gravity = Gravity.CENTER_VERTICAL;

        val textLabel = a.getString(R.styleable.Options_label_input)
        val textDescription = a.getString(R.styleable.Options_description_input)
        a.recycle()

        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_edittext, this, true)

        label = getChildAt(0) as TextView
        input = getChildAt(1) as CustomEditText
        description = getChildAt(2) as TextView

        label?.text = textLabel
        description?.text = textDescription

    }

    fun getText(): String = input?.text.toString()

    fun setText(value: String){
        input?.setText(value)
    }

}