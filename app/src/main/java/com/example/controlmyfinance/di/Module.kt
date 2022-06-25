package com.example.controlmyfinance.di

import androidx.room.Room
import com.example.controlmyfinance.data.local_db.AppDatabase
import com.example.controlmyfinance.data.local_db.shared_pref.SharedPreference
import com.example.controlmyfinance.data.mapper.ExpensesMapper
import com.example.controlmyfinance.data.mapper.ProfitMapper
import com.example.controlmyfinance.data.repository.ExpensesRepositoryImpl
import com.example.controlmyfinance.data.repository.ProfitRepositoryImpl
import com.example.controlmyfinance.domain.repository.ExpensesRepository
import com.example.controlmyfinance.domain.repository.ProfitRepository
import com.example.controlmyfinance.domain.usecase.GetExpensesUseCase
import com.example.controlmyfinance.domain.usecase.GetProfitUseCase
import com.example.controlmyfinance.domain.usecase.SetExpensesUseCase
import com.example.controlmyfinance.domain.usecase.SetProfitUseCase
import com.example.controlmyfinance.presentation.add_finance.AddFinanceViewModel
import com.example.controlmyfinance.presentation.expenses.ExpensesViewModel
import com.example.controlmyfinance.presentation.show_finance.ShowFinanceViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<ExpensesRepository> { ExpensesRepositoryImpl(get(), get()) }
    single { GetExpensesUseCase(get()) }
    single { SetExpensesUseCase(get()) }

    single<ProfitRepository> { ProfitRepositoryImpl(get(), get()) }
    single { GetProfitUseCase(get()) }
    single { SetProfitUseCase(get()) }
}

val mapperModule = module {
    single { ProfitMapper() }
    single { ExpensesMapper() }
}

val localDBModel = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "control_my_finance.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
    single {
        AppDatabase.getInstance(this.androidApplication()).expensesDao()
    }
    single {
        AppDatabase.getInstance(this.androidApplication()).profitDao()
    }
    single {
        SharedPreference(this.androidApplication())
    }
}

val viewModelModule = module {
    viewModel { AddFinanceViewModel(get(), get()) }
    viewModel { ShowFinanceViewModel() }
    viewModel { ExpensesViewModel(get()) }
}
