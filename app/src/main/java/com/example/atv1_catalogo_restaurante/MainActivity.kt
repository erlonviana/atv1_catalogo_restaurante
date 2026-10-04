package com.example.atv1_catalogo_restaurante

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.atv1_catalogo_restaurante.ui.catalogo.CatalogoScreen
import com.example.atv1_catalogo_restaurante.ui.resumo.ResumoScreen
import com.example.atv1_catalogo_restaurante.ui.theme.RestauranteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestauranteTheme {
                AppRestaurante()
            }
        }
    }
}

@Composable
fun AppRestaurante() {


    var mostrandoResumo by rememberSaveable { mutableStateOf(false) }


    val carrinho = remember { CarrinhoState() }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (mostrandoResumo) {
            ResumoScreen(
                itens = carrinho.itens,
                formaPagamento = carrinho.formaPagamento,
                onMudarPagamento = { carrinho.formaPagamento = it },
                onVoltar = { mostrandoResumo = false }
            )
        } else {
            CatalogoScreen(
                itensNoCarrinho = carrinho.quantidadeTotal(),
                onAdicionar = { carrinho.adicionar(it) },
                onIrParaResumo = { mostrandoResumo = true }
            )
        }
    }
}