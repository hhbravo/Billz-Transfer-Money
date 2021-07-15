package com.hans.transfermoney.presentation.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.hans.transfermoney.core.Result
import com.hans.transfermoney.domain.transaction.TransactionRepo
import kotlinx.coroutines.Dispatchers
import kotlin.Exception

class TransactionViewModel(private val repo: TransactionRepo): ViewModel() {

    fun transaction() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.findAll()))
        }catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}

class TransactionViewModelFactory(private val repo: TransactionRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TransactionRepo::class.java).newInstance(repo)
    }

}