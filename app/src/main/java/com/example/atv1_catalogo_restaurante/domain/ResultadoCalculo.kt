package com.example.atv1_catalogo_restaurante.domain

/**
 * Camada B — Business Logic (Leandro)
 * Data class que encapsula o resultado final dos cálculos de um pedido.
 * A UI usa esta classe apenas para exibir os valores.
 */
data class ResultadoCalculo(
    val subtotal: Double,
    val taxaServico: Double,
    val desconto: Double,
    val total: Double
)
