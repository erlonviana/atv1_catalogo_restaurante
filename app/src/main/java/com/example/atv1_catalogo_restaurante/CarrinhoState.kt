package com.example.atv1_catalogo_restaurante


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.atv1_catalogo_restaurante.data.model.FormaPagamento
import com.example.atv1_catalogo_restaurante.data.model.ItemMenu


class CarrinhoState {


    val itens = mutableStateListOf<Pair<ItemMenu, Int>>()


    var formaPagamento by mutableStateOf<FormaPagamento>(FormaPagamento.Dinheiro)


    fun adicionar(item: ItemMenu) {
        val index = itens.indexOfFirst { it.first == item }
        if (index >= 0) {
            val (produto, qtd) = itens[index]
            itens[index] = produto to (qtd + 1)
        } else {
            itens.add(item to 1)
        }
    }


    fun quantidadeTotal(): Int = itens.sumOf { it.second }
}