package com.example.atv1_catalogo_restaurante.data.model

//Camada A Modelagem - Erlon

/**
 * Formas de pagamento aceitas pelo restaurante.
 * Hierarquia FECHADA (sealed) — Dinheiro, Cartão e Pix.
 * Pix carrega o percentual de desconto consigo.
 */
sealed class FormaPagamento {

    object Dinheiro : FormaPagamento()

    object Cartao : FormaPagamento()

    data class Pix(
        val percentualDesconto: Double = 0.10
    ) : FormaPagamento()
}