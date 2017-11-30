package br.com.disapps.simplemvvm.ui.home

import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by diefferson on 29/11/2017.
 */
class HomeViewModel @Inject constructor() : ViewModel() {
    var teste  =  "HEllo Teste"
    var mensagem = "Mensagem"
}