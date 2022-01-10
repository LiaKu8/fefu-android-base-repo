package ru.fefu.activitytracker

import java.io.Serializable


interface ActivitiesData

data class ActivitiesInfo (
    val distance: String,
    val time: String,
    val type: String,
    val user: String? = null,
    val timeAgo: String,
    val startTime: String = "14:49",
    val finishTime: String = "16:31"
): ActivitiesData, Serializable

data class ActivitiesDate(
    val date: String
): ActivitiesData, Serializable
