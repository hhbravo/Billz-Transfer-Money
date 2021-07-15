package com.hans.transfermoney.domain.transaction

import com.hans.transfermoney.data.model.Transaction
import com.hans.transfermoney.data.remote.transaction.TransactionDataSource

class TransactionRepoImpl(private val dataSource: TransactionDataSource): TransactionRepo {

    override suspend fun findAll(): List<Transaction> = dataSource.findAll()
}