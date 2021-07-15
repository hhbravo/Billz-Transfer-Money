package com.hans.transfermoney.data.remote.expense

import com.hans.transfermoney.data.model.Expense

class ExpenseDataSource(private val webService: WebService) {

    suspend fun findAll(): List<Expense>  =  webService.expense()
}