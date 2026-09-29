package com.example.atv1_catalogo_restaurante.data.model

//Camada A Modelagem - Erlon

data class Bebida(
    override val nome: String,
    override val preco: Double,
    override val descricao: String? = null,
    val alcoolica: Boolean = false
) : ItemMenu(
    nome = nome,
    preco = preco,
    descricao = descricao,
    categoria = Categoria.BEBIDA
)