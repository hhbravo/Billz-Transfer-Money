package com.hans.transfermoney.domain.expense

import com.hans.transfermoney.data.model.Expense

interface ExpenseRepo {
    suspend fun expense(): List<Expense>
}