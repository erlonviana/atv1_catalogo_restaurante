package com.example.atv1_catalogo_restaurante.data.model

//Camada A Modelagem - Erlon

data class Prato(
    override val nome: String,
    override val preco: Double,
    override val descricao: String? = null,
    val vegetariano: Boolean = false
) : ItemMenu(
    nome = nome,
    preco = preco,
    descricao = descricao,
    categoria = Categoria.PRATO
)