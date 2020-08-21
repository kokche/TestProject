package com.pulse.practic.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var description: String
)