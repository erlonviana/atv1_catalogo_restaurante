package com.example.atv1_catalogo_restaurante.data.model

//Camada A Modelagem - Erlon
/**
 * Abstração raiz para todos os itens do menu.
 * Hierarquia FECHADA (sealed) — só Prato e Bebida podem herdar.
 */
sealed class ItemMenu(
    open val nome: String,
    open val preco: Double,
    open val descricao: String? = null,
    open val categoria: Categoria //"categoria" aparece "esmaecido"
)