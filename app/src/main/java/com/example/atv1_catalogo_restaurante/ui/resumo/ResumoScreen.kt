package com.example.atv1_catalogo_restaurante.ui.resumo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atv1_catalogo_restaurante.data.model.FormaPagamento
import com.example.atv1_catalogo_restaurante.data.model.ItemMenu
import com.example.atv1_catalogo_restaurante.domain.CalculadoraPedido
import com.example.atv1_catalogo_restaurante.domain.RelatorioLogcat
import com.example.atv1_catalogo_restaurante.ui.resumo.components.LinhaRecibo
import com.example.atv1_catalogo_restaurante.ui.resumo.components.SeletorPagamento


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumoScreen(
    itens: List<Pair<ItemMenu, Int>>,
    formaPagamento: FormaPagamento,
    onMudarPagamento: (FormaPagamento) -> Unit,
    onVoltar: () -> Unit
) {
    // Recalcula SEMPRE que itens ou formaPagamento mudarem
    val resultado = CalculadoraPedido.calcular(itens, formaPagamento)

    Column(Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Resumo do Pedido") },
            navigationIcon = {
                IconButton(onClick = onVoltar) {

                }
            }
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            // ---- ITENS ----
            Text("ITENS", style = MaterialTheme.typography.titleMedium)
            itens.forEach { (item, qtd) ->
                LinhaRecibo(
                    descricao = "${item.nome} x$qtd",
                    valor = item.preco * qtd
                )
            }

            Spacer(Modifier.height(16.dp))

            // ---- FORMA DE PAGAMENTO ----
            Text("FORMA DE PAGAMENTO", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            SeletorPagamento(
                atual = formaPagamento,
                onSelecionar = onMudarPagamento
            )

            Spacer(Modifier.height(16.dp))
            Divider()

            // ---- VALORES CALCULADOS (vêm da Camada B) ----
            LinhaRecibo("Subtotal", resultado.subtotal)
            LinhaRecibo("Taxa de serviço", resultado.taxaServico)
            LinhaRecibo("Desconto Pix", -resultado.desconto)
            Divider()
            LinhaRecibo("TOTAL", resultado.total, destaque = true)
        }

        Button(
            onClick = { RelatorioLogcat.imprimir(itens) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("[ FINALIZAR PEDIDO ]")
        }
    }
}