package ru.fefu.activitytracker

object Repository {
    val myActivitiesList = listOf<ActivitiesData>(
        ActivitiesDate("Вчера"),
        ActivitiesInfo(
            distance = "14.32 км",
            time = "2 часа 46 минут",
            type = "Серфинг \uD83C\uDFC4",
            timeAgo = "14 часов назад"
        ),
        ActivitiesDate("Май 2022 года"),
        ActivitiesInfo(
            distance = "1 000 м",
            time = "60 минут",
            type = "Велосипед \uD83C\uDFC4",
            timeAgo = "29.05.2022"
        )
    )

    val usersActivitiesList = listOf<ActivitiesData>(
        ActivitiesDate("Вчера"),
        ActivitiesInfo(
            "14.32 км",
            "2 часа 46 минут",
            "Серфинг",
            "@van_darkholme",
            "14 часов назад"
        ),
        ActivitiesInfo(
            "228 м",
            "14 часов 48 минут",
            "Качели",
            "@techniquepasha",
            "14 часов назад"
        ),
        ActivitiesInfo(
            "10 км",
            "1 час 10 минут",
            "Езда на кадилаке",
            "@morgen_shtern",
            "14 часов назад"
        ),
    )
}