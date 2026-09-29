package com.example.atv1_catalogo_restaurante.domain

import android.util.Log
import com.example.catalogo_restaurante.data.model.Bebida
import com.example.catalogo_restaurante.data.model.ItemMenu
import com.example.catalogo_restaurante.data.model.Prato
import java.util.Locale

/**
 * Camada B — Business Logic (Leandro)
 * Gera e imprime o relatório do pedido no Logcat, agrupado por categoria.
 */
object RelatorioLogcat {

    private const val TAG = "RelatorioPedido"

    fun imprimir(itens: List<ItemMenu>) {
        Log.d(TAG, "===== RELATÓRIO DE PEDIDO =====")

        val agrupados = itens.groupBy { item ->
            when (item) {
                is Prato -> "PRATO"
                is Bebida -> "BEBIDA"
            }
        }

        agrupados.forEach { (categoria, lista) ->
            Log.d(TAG, "--- $categoria ---")
            lista.forEach { item ->
                val linha = String.format(
                    Locale.getDefault(),
                    "%s x1 = R$ %.2f",
                    item.nome,
                    item.preco
                )
                Log.d(TAG, linha)
            }
        }

        Log.d(TAG, "================================")
    }
}