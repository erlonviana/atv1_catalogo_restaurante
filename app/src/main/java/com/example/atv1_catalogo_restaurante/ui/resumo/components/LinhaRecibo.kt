package com.example.atv1_catalogo_restaurante.ui.resumo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Linha reutilizável do recibo: descrição à esquerda, valor à direita.
 * Se destaque = true, usa negrito e tipografia maior (para o TOTAL).
 */
@Composable
fun LinhaRecibo(
    descricao: String,
    valor: Double,
    destaque: Boolean = false
) {
    val estilo = if (destaque)
        MaterialTheme.typography.titleMedium
    else
        MaterialTheme.typography.bodyMedium

    val peso = if (destaque) FontWeight.Bold else FontWeight.Normal

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = descricao, style = estilo, fontWeight = peso)
        Text(
            text = "R$ ${"%.2f".format(valor)}",
            style = estilo,
            fontWeight = peso
        )
    }
}