package com.example.atv1_catalogo_restaurante.domain

import com.example.atv1_catalogo_restaurante.data.model.FormaPagamento
import com.example.atv1_catalogo_restaurante.data.model.ItemMenu

/**
 * Motor de cálculo do pedido.
 * Totalmente isolado da UI — pode ser testado com JUnit puro.
 */
object CalculadoraPedido {

    private const val TAXA_SERVICO = 0.10   // 10% sobre o subtotal

    fun calcular(
        itens: List<Pair<ItemMenu, Int>>,
        formaPagamento: FormaPagamento
    ): ResultadoCalculo {

        // 1) Subtotal
        val subtotal = itens.sumOf { (item, qtd) -> item.preco * qtd }

        // 2) Taxa de serviço (sempre 10%)
        val taxaServico = subtotal * TAXA_SERVICO

        // 3) Desconto — avaliando exaustivamente a forma de pagamento
        val desconto = when (formaPagamento) {
            is FormaPagamento.Pix      -> subtotal * formaPagamento.percentualDesconto
            FormaPagamento.Dinheiro    -> 0.0
            FormaPagamento.Cartao      -> 0.0
        }

        // 4) Total final
        val total = subtotal + taxaServico - desconto

        return ResultadoCalculo(
            subtotal = subtotal,
            taxaServico = taxaServico,
            desconto = desconto,
            total = total
        )
    }
}