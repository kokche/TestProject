package com.pulse.practic.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.security.cert.CertPathChecker

@Entity
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "description")
    var description: String = "None",
    @ColumnInfo(name = "isChecked")
    var isChecked: Boolean = false
): Serializable