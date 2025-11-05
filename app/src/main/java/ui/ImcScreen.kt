package com.example.calculadoraimc.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculadoraimc.viewmodel.ImcViewModel
import java.text.DecimalFormat

@Composable
fun ImcScreen(
    // Obtiene el ViewModel
    viewModel: ImcViewModel = viewModel()
) {
    // Lectura de estados reactivos
    val peso = viewModel.pesoInput
    val altura = viewModel.alturaInput
    val resultado = viewModel.imcResultado
    val error = viewModel.errorMensaje

    // Formateador para dos decimales
    val decimalFormat = DecimalFormat("#.##")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp), // Padding apropiado [cite: 105, 112]
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text("CALCULADORA DE IMC", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(32.dp))

        // 1. Entrada para Peso (kg)
        OutlinedTextField(
            value = peso,
            onValueChange = { viewModel.onPesoChange(it) },
            label = { Text("Peso (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // keyboardType = Number [cite: 106]
            modifier = Modifier.fillMaxWidth() // Uso de fillMaxWidth [cite: 112]
        )
        Spacer(Modifier.height(16.dp))

        // 2. Entrada para Altura (cm)
        OutlinedTextField(
            value = altura,
            onValueChange = { viewModel.onAlturaChange(it) },
            label = { Text("Altura (cm)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // keyboardType = Number [cite: 107]
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(24.dp))

        // 3. Botones 'Calcular' y 'Limpiar'
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // Row con botones [cite: 108]
        ) {
            Button(
                onClick = { viewModel.calcularImc() },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("CALCULAR")
            }
            Button(
                onClick = { viewModel.limpiarCampos() },
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text("LIMPIAR")
            }
        }
        Spacer(Modifier.height(32.dp))

        // 4. Manejo de Errores (Mostrar si hay error)
        if (error != null) {
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error, // Mensaje de error apropiado [cite: 65]
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(24.dp))
        }

        // 5. Sección de Resultados
        // Se muestra solo si el IMC es mayor a 0 [cite: 109]
        if (resultado.imc > 0.0) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(resultado.color) // Color de fondo correspondiente [cite: 111, 62]
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Tu IMC es: ${decimalFormat.format(resultado.imc)}", // Formato de dos decimales [cite: 110, 60]
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Clasificación: ${resultado.clasificacion}", // Visualización de la clasificación [cite: 111, 61]
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}