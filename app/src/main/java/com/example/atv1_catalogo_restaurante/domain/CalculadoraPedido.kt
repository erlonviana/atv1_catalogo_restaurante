package com.example.atv1_catalogo_restaurante.domain

import com.example.catalogo_restaurante.data.model.FormaPagamento
import com.example.catalogo_restaurante.data.model.ItemMenu

/**
 * Camada B — Business Logic (Leandro)
 * Motor de cálculo centralizado e isolado da UI.
 */
object CalculadoraPedido {

    private const val PERCENTUAL_TAXA_SERVICO = 0.10 // 10% sempre

    fun calcular(
        itens: List<ItemMenu>,
        formaPagamento: FormaPagamento
    ): ResultadoCalculo {

        // 1) Subtotal
        val subtotal = itens.sumOf { it.preco }

        // 2) Taxa de serviço (10% sobre subtotal, independe do pagamento)
        val taxaServico = subtotal * PERCENTUAL_TAXA_SERVICO

        // 3) Desconto (avaliação exaustiva da forma de pagamento)
        val desconto = when (formaPagamento) {
            is FormaPagamento.Pix -> subtotal * formaPagamento.percentualDesconto
            is FormaPagamento.Dinheiro -> 0.0
            is FormaPagamento.Cartao -> 0.0
        }

        // 4) Total final
        val totalFinal = subtotal + taxaServico - desconto

        return ResultadoCalculo(
            subtotal = subtotal,
            taxaServico = taxaServico,
            desconto = desconto,
            totalFinal = totalFinal
        )
    }
}