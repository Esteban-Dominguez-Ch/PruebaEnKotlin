package com.example.prueba

import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var etCantidad1: EditText? = null
    private var etCantidad2: EditText? = null
    private var tvPrecioComida: TextView? = null
    private var tvPropina: TextView? = null
    private var tvTotal: TextView? = null
    private var pagoPropina: Switch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCantidad1 = findViewById(R.id.etCantidad1)
        etCantidad2 = findViewById(R.id.etCantidad2)
        tvPrecioComida = findViewById(R.id.tvPrecioComida)
        tvPropina = findViewById(R.id.tvPropina)
        tvTotal = findViewById(R.id.tvTotal)
        pagoPropina = findViewById(R.id.pagoPropina)


        etCantidad1?.setOnFocusChangeListener { _, hasFocus -> if (!hasFocus) calcularPrecio() }
        etCantidad2?.setOnFocusChangeListener { _, hasFocus -> if (!hasFocus) calcularPrecio() }
        pagoPropina?.setOnCheckedChangeListener { _, isChecked -> calcularPrecio() }
    }

    private fun calcularPrecio() {
        val cantidad1 = etCantidad1?.text.toString().toIntOrNull() ?: 0
        val cantidad2 = etCantidad2?.text.toString().toIntOrNull() ?: 0

        val precio1 = if (cantidad1 > 0) cantidad1 * 10000 else 0
        val precio2 = if (cantidad2 > 0) cantidad2 * 36000 else 0

        val precioComida = precio1 + precio2
        val propina = if (pagoPropina?.isChecked == true) (precioComida * 0.1).toInt() else 0
        val total = precioComida + propina

        tvPrecioComida?.text = precioComida.toString()
        tvPropina?.text = propina.toString()
        tvTotal?.text = total.toString()

    }
}