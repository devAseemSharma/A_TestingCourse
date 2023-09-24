package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


internal class ShoppingCartTest {
    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setUp(){
        cart = ShoppingCart()
    }

    @Test
    fun `add multiple products, total price sum is correct` (){
        // Given
        val product = Product(
            id= 0,
            name = "Ice cream",
            price = 5.0
        )
        cart.addProduct(product = product, quantity = 4)

        //Action
        val priceSum = cart.getTotalCost()


        // Assertion
        assertThat(priceSum).isEqualTo(20.0)
    }

    @Test
    fun `Add product with negative quantity, throws Exception` (){
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        assertFailure {
            cart.addProduct(product = product, -5)
        }
    }
}