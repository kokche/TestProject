package com.pulse.practic.data.database.room.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


 val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE tasks ADD COLUMN isChecked BOOLEAN default false");
    }
}

