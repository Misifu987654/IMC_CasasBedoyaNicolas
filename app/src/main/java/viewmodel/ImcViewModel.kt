package com.example.calculadoraimc.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculadoraimc.model.ImcResult
import kotlin.math.pow
import java.text.DecimalFormat

// 1. Debe heredar de la clase ViewModel() [cite: 97]
class ImcViewModel : ViewModel() {

    // 2. ESTADOS DE LA APLICACIÓN (Usando mutableStateOf [cite: 99])

    // Estados para los inputs (peso y altura) [cite: 98]
    var pesoInput by mutableStateOf("")
        private set

    var alturaInput by mutableStateOf("")
        private set

    // Estado para el resultado (ImcResult) [cite: 98]
    var imcResultado by mutableStateOf(ImcResult())
        private set

    // Estado para manejo de errores (punto 65 del enunciado)
    var errorMensaje by mutableStateOf<String?>(null)
        private set

    // 3. FUNCIONES DE MANEJO DE ESTADO

    fun onPesoChange(newValue: String) {
        pesoInput = newValue
        errorMensaje = null // Limpiar error al empezar a escribir
    }

    fun onAlturaChange(newValue: String) {
        alturaInput = newValue
        errorMensaje = null
    }

    // 4. FUNCIÓN DE LÓGICA DE NEGOCIO [cite: 100]

    fun calcularImc() {
        // A. Validaciones (campos vacíos y valores inválidos) [cite: 64, 65, 102]
        if (pesoInput.isBlank() || alturaInput.isBlank()) {
            errorMensaje = "Ambos campos (Peso y Altura) son obligatorios."
            imcResultado = ImcResult()
            return
        }

        val pesoKg = pesoInput.toDoubleOrNull()
        val alturaCm = alturaInput.toDoubleOrNull()

        if (pesoKg == null || alturaCm == null || pesoKg <= 0 || alturaCm <= 0) {
            errorMensaje = "Ingrese valores numéricos válidos y mayores a cero."
            imcResultado = ImcResult()
            return
        }

        // B. Cálculo del IMC [cite: 67, 68]
        // 1. Conversión de Altura: cm a metros [cite: 69]
        val alturaM = alturaCm / 100.0

        // 2. Fórmula: IMC = peso (kg) / [altura (m)]^2
        val imcCalculado = pesoKg / alturaM.pow(2)

        // C. Clasificación y asignación de color [cite: 61, 62]
        val (clasificacion, color) = clasificarImc(imcCalculado)

        // D. Actualizar el estado del resultado
        imcResultado = ImcResult(
            imc = imcCalculado,
            clasificacion = clasificacion,
            color = color
        )
        errorMensaje = null
    }

    // Función auxiliar para determinar la clasificación y color (Tabla 3.2) [cite: 71, 72]
    private fun clasificarImc(imc: Double): Pair<String, Long> {
        return when {
            imc < 18.5 -> Pair("Bajo peso", 0xFFBBDEFB)     // Azul claro
            imc < 25.0 -> Pair("Peso normal", 0xFFC8E6C9)   // Verde claro
            imc < 30.0 -> Pair("Sobrepeso", 0xFFFFF9C4)     // Amarillo claro
            else -> Pair("Obesidad", 0xFFFFCDD2)            // Rojo claro
        }
    }

    // 5. FUNCIÓN PARA LIMPIAR CAMPOS [cite: 63, 101]

    fun limpiarCampos() {
        pesoInput = ""
        alturaInput = ""
        imcResultado = ImcResult() // Reinicia el resultado
        errorMensaje = null
    }
}