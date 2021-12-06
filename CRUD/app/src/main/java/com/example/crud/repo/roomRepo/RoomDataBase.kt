package com.example.crud.repo.roomRepo

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.crud.domain.TravelPlace
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [TravelPlace::class], version = 1, exportSchema = false)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun travelPlaceDao(): TravelPlaceDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDataBase? = null

        fun getDatabase(
            context: Context,
            scope: Application
        ): RoomDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "word_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    .fallbackToDestructiveMigration()
                    //.addCallback(RoomDataBaseeCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class RoomDataBaseeCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.travelPlaceDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        fun populateDatabase(travelPlaceDto: TravelPlaceDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            //wordDao.()

//            var word = Word("Hello")
//            wordDao.insert(word)
//            word = Word("World!")
//            wordDao.insert(word)
            var elem = TravelPlace(1,"Castelul Corvinilor","Hunedoara","45","22","Castelul Corvinilor, numit și Castelul Huniazilor sau al Hunedoarei, este cetatea medievală a Hunedoarei, unul din cele mai importante monumente de arhitectură gotică din România.\n" +
                    "\n" +
                    "Este considerat unul dintre cele mai frumoase castele din lume, fiind situat în „top 10 destinații de basm din Europa”","10:00-16:00 L-S","https://www.descopera.ro/wp-content/uploads/2021/05/castelul-corvinilor-hunedoara-shutter_descopera-3-scaled.jpg")
            travelPlaceDto.insert(elem)
        }
    }

}
