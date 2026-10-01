package com.example.atv1_catalogo_restaurante.ui.catalogo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    val itens = MenuRepository.itens

    Column(Modifier.fillMaxSize()) {

        // Cabeçalho com indicador de estado
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

        // Lista rolável
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            // Seção PRATOS
            item {
                Text(
                    text = "PRATOS",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }
            items(itens.filterIsInstance<Prato>()) { prato ->
                ItemMenuCard(item = prato, onAdicionar = onAdicionar)
            }

            // Seção BEBIDAS
            item {
                Text(
                    text = "BEBIDAS",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(8.dp)
                )
            }
            items(itens.filterIsInstance<Bebida>()) { bebida ->
                ItemMenuCard(item = bebida, onAdicionar = onAdicionar)
            }
        }

        // Navegação
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