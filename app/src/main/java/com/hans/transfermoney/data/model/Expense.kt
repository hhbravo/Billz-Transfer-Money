package com.hans.transfermoney.data.model


data class Expense(
    val fecAmount: String = "",
    val bill: Bill
)

data class Bill(
    val amount: Double,
    val symbol: String,
    val currency: String
)