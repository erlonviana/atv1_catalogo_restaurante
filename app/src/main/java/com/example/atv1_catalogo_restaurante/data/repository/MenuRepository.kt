package com.example.atv1_catalogo_restaurante.data.repository   // ← package certo

import com.example.atv1_catalogo_restaurante.data.model.Bebida
import com.example.atv1_catalogo_restaurante.data.model.ItemMenu
import com.example.atv1_catalogo_restaurante.data.model.Prato

object MenuRepository {

    val itens: List<ItemMenu> = listOf(
        Prato(
            nome = "Pizza Margherita",
            preco = 42.00,
            descricao = "Molho de tomate, manjericão fresco e mussarela de búfala",
            vegetariano = true
        ),
        Prato(
            nome = "Feijoada completa",
            preco = 58.00,
            descricao = null,
            vegetariano = false
        ),
        Prato(
            nome = "Risoto de cogumelos",
            preco = 47.00,
            descricao = "Arroz arbóreo, cogumelos paris e parmesão",
            vegetariano = true
        ),
        Bebida(
            nome = "Suco de laranja",
            preco = 12.00,
            descricao = "Natural, 500ml",
            alcoolica = false
        ),
        Bebida(
            nome = "Cerveja artesanal IPA",
            preco = 18.00,
            descricao = "500ml, produzida localmente",
            alcoolica = true
        ),
        Bebida(
            nome = "Água mineral",
            preco = 5.00,
            descricao = null,
            alcoolica = false
        )
    )
}