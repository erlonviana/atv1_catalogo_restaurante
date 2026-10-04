package com.example.atv1_catalogo_restaurante

import com.example.atv1_catalogo_restaurante.data.model.Bebida
import com.example.atv1_catalogo_restaurante.data.model.FormaPagamento
import com.example.atv1_catalogo_restaurante.data.model.Prato
import com.example.atv1_catalogo_restaurante.domain.CalculadoraPedido
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculadoraPedidoTest {

    @Test
    fun cenarioDoPdf_comPix_deveDarTotal112() {
        val itens = listOf(
            Prato("Pizza Margherita", 42.0, null, false),
            Prato("Feijoada completa", 58.0, null, false),
            Bebida("Suco de laranja", 12.0, null, false)
        )

        val resultado = CalculadoraPedido.calcular(itens, FormaPagamento.Pix(0.10))

        assertEquals("Subtotal", 112.0, resultado.subtotal, 0.001)
        assertEquals("Taxa de servico", 11.20, resultado.taxaServico, 0.001)
        assertEquals("Desconto Pix", 11.20, resultado.desconto, 0.001)
        assertEquals("Total final", 112.0, resultado.totalFinal, 0.001)
    }
}