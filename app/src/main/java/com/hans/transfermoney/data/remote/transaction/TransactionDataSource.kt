package com.hans.transfermoney.data.remote.transaction

import com.hans.transfermoney.data.model.Transaction
import com.hans.transfermoney.data.remote.expense.WebService

class TransactionDataSource(private val webService: WebService) {

    suspend fun findAll():List<Transaction> = webService.transaction()
}