package com.example.calculatricehard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOperator = true
    var edt1: EditText? = null
    var operator = "+"
    var initialNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun digitEvent(view: View) {
        if (isNewOperator) editText.setText("")
        isNewOperator = false
        var number: String = editText.text.toString()
        if (view.id === oneDigit.id) {
            number += "1"
        } else if (view.id === twoDigit.id) {
            number += "2"
        } else if (view.id === threeDigit.id) {
            number += "3"
        } else if (view.id === fourDigit.id) {
            number += "4"
        } else if (view.id === fiveDigit.id) {
            number += "5"
        } else if (view.id === sixDigit.id) {
            number += "6"
        } else if (view.id === sevenDigit.id) {
            number += "7"
        } else if (view.id === eightDigit.id) {
            number += "8"
        } else if (view.id === nineDigit.id) {
            number += "9"
        } else if (view.id === dotDigit.id) {
            number += "."
        }
        editText.setText(number)
    }

    fun calculEvent(view: View) {
        isNewOperator = true
        initialNumber = editText.text.toString()
        if (view.getId() === plusDigit.id) {
            operator = "+"
        } else if (view.getId() === minusDigit.id) {
            operator = "-"
        } else if (view.id === multiplyDigit.id) {
            operator = "*"
        } else if (view.getId() === divideDigit.id) {
            operator = "/"
        }
    }

    fun percentEvent(view: View?) {
        val num: Double = editText.text.toString().toDouble() / 100
        editText.setText(num.toString() + "")
        isNewOperator = true
    }

    fun resultEvent(view: View?) {
        val newNumber: String = editText.text.toString()
        var output = 0.0
        if (operator === "+") output = initialNumber.toDouble() + newNumber.toDouble()
        if (operator === "-") output = initialNumber.toDouble() - newNumber.toDouble()
        if (operator === "*") output = initialNumber.toDouble() * newNumber.toDouble()
        if (operator === "/") output = initialNumber.toDouble() / newNumber.toDouble()
        editText.setText(output.toString() + "")
    }

    fun resetEvent(view: View?) {
        editText.setText("0")
        isNewOperator = true
    }

}