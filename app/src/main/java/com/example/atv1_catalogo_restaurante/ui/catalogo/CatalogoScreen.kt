package com.example.atv1_catalogo_restaurante.ui.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atv1_catalogo_restaurante.data.model.Bebida
import com.example.atv1_catalogo_restaurante.data.model.ItemMenu
import com.example.atv1_catalogo_restaurante.data.model.Prato
import com.example.atv1_catalogo_restaurante.data.repository.MenuRepository
import com.example.atv1_catalogo_restaurante.ui.catalogo.components.ItemMenuCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(
    itensNoCarrinho: Int,
    onAdicionar: (ItemMenu) -> Unit,
    onIrParaResumo: () -> Unit
) {
    val pratos = MenuRepository.itens.filterIsInstance<Prato>()
    val bebidas = MenuRepository.itens.filterIsInstance<Bebida>()

    Column(Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Cardápio") },
            actions = {
                Text(
                    text = "🛒 ($itensNoCarrinho)",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            item {
                Text(
                    text = "PRATOS",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }

            items(pratos) {
                ItemMenuCard(
                    item = it,
                    onAdicionar = onAdicionar
                )
            }

            item {
                Text(
                    text = "BEBIDAS",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }

            items(bebidas) {
                ItemMenuCard(
                    item = it,
                    onAdicionar = onAdicionar
                )
            }
        }

        Button(
            onClick = onIrParaResumo,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("[ VER RESUMO ]")
        }
    }
}
