package br.com.disapps.simplemvvm.util.extensions

import android.widget.TextView

/**
 * Created by diefferson on 29/11/2017.
 */

fun TextView.setText(value : Int){
    this.text = value.toString()
}