package com.example.atv1_catalogo_restaurante.ui.resumo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atv1_catalogo_restaurante.data.model.FormaPagamento

/**
 * Seletor interativo de forma de pagamento.
 * Reflete os tipos mapeados em FormaPagamento (sealed class).
 */
@Composable
fun SeletorPagamento(
    atual: FormaPagamento,
    onSelecionar: (FormaPagamento) -> Unit
) {
    Column(Modifier.fillMaxWidth()) {

        OpcaoPagamento(
            label = "Dinheiro",
            selecionado = atual is FormaPagamento.Dinheiro,
            onSelecionar = { onSelecionar(FormaPagamento.Dinheiro) }
        )

        OpcaoPagamento(
            label = "Cartão",
            selecionado = atual is FormaPagamento.Cartao,
            onSelecionar = { onSelecionar(FormaPagamento.Cartao) }
        )

        OpcaoPagamento(
            label = "Pix — 10% off",
            selecionado = atual is FormaPagamento.Pix,
            onSelecionar = { onSelecionar(FormaPagamento.Pix()) }
        )
    }
}

@Composable
private fun OpcaoPagamento(
    label: String,
    selecionado: Boolean,
    onSelecionar: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selecionado,
                onClick = onSelecionar
            )
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selecionado,
            onClick = onSelecionar
        )
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
    }
}