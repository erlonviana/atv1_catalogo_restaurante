package com.example.atv1_catalogo_restaurante.ui.catalogo.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.atv1_catalogo_restaurante.data.model.ItemMenu

@Composable
fun ItemMenuCard(
    item: ItemMenu,
    onAdicionar: (ItemMenu) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {

            Text(
                text = item.nome,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = item.descricao ?: "Sem descrição",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                Modifier.fillMaxWidth(),
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
