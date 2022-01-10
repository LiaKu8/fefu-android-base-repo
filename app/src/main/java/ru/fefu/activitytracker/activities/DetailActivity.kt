package ru.fefu.activitytracker.activities

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ru.fefu.activitytracker.ActivitiesInfo
import ru.fefu.activitytracker.R

class DetailActivity : AppCompatActivity() {
    companion object {
        const val intentTag = "intentTag"
        fun getIntent(context: Context, item: ActivitiesInfo) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(intentTag, item)
            }
    }

    private lateinit var toolbar: Toolbar
    private lateinit var detailDistance: TextView
    private lateinit var detailTimeAgo: TextView
    private lateinit var detailTime: TextView
    private lateinit var detailStartTime: TextView
    private lateinit var detailFinishTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        findViewsById()

        val info = getActivitiesDataFromIntent()

        setupToolbar(info.type)
        setupViews(info)
    }

    private fun findViewsById() {
        toolbar = findViewById(R.id.detail_toolbar)
        detailDistance = findViewById(R.id.detail_distance)
        detailTimeAgo = findViewById(R.id.detail_time_ago)
        detailTime = findViewById(R.id.detail_time)
        detailStartTime = findViewById(R.id.detail_start_time)
        detailFinishTime = findViewById(R.id.detail_finish_time)
    }

    private fun getActivitiesDataFromIntent(): ActivitiesInfo {
        val rawIntentData =
            intent.getSerializableExtra(intentTag) ?: throw Resources.NotFoundException()
        return rawIntentData as ActivitiesInfo
    }

    private fun setupToolbar(type: String) {
        with(toolbar) {
            title = type
            setNavigationOnClickListener { finish() }
        }
    }

    private fun setupViews(info: ActivitiesInfo) {
        detailDistance.text = info.distance
        detailTimeAgo.text = info.timeAgo
        detailTime.text = info.time
        detailStartTime.text = info.startTime
        detailFinishTime.text = info.finishTime
    }
}
