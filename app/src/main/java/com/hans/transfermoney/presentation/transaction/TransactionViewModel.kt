package com.hans.transfermoney.presentation.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hans.transfermoney.core.Result
import com.hans.transfermoney.domain.transaction.TransactionRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repo: TransactionRepo): ViewModel() {

    fun transaction() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(Result.Success(repo.findAll()))
        }catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}
/*

class TransactionViewModelFactory(private val repo: TransactionRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(TransactionRepo::class.java).newInstance(repo)
    }

}*/
