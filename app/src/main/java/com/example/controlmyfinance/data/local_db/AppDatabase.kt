package com.example.controlmyfinance.data.local_db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.controlmyfinance.data.local_db.dao.ExpensesDao
import com.example.controlmyfinance.data.local_db.dao.ProfitDao
import com.example.controlmyfinance.data.local_db.model.ExpensesEntity
import com.example.controlmyfinance.data.local_db.model.ProfitEntity

@Database(
    entities = [ProfitEntity::class, ExpensesEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun profitDao(): ProfitDao
    abstract fun expensesDao(): ExpensesDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "control_my_finance.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = db
                return db
            }
        }

    }

}