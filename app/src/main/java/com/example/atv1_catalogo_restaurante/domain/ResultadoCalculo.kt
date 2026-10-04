package com.example.atv1_catalogo_restaurante.domain

data class ResultadoCalculo(
    val subtotal: Double,
    val taxaServico: Double,
    val desconto: Double,
    val total: Double
)
