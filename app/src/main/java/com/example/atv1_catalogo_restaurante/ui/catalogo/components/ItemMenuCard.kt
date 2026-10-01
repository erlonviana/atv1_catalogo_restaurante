package com.example.atv1_catalogo_restaurante.ui.catalogo.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.atv1_catalogo_restaurante.data.model.ItemMenu

/**
 * Card reutilizável para exibir um item do menu.
 * Recebe os dados via parâmetro e emite um callback ao ser adicionado.
 */
@Composable
fun ItemMenuCard(
    item: ItemMenu,
    onAdicionar: (ItemMenu) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {

            // Nome — Material Design 3
            Text(
                text = item.nome,
                style = MaterialTheme.typography.titleMedium
            )

            // Descrição — trata nulo + truncamento com reticências
            Text(
                text = item.descricao ?: "Sem descrição",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            // Preço + botão de adicionar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "R$ ${"%.2f".format(item.preco)}",
                    style = MaterialTheme.typography.bodyLarge
                )
                TextButton(onClick = { onAdicionar(item) }) {
                    Text("[+ Add]")
                }
            }
        }
    }
}