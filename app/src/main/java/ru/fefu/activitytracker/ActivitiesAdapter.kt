package ru.fefu.activitytracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivitiesAdapter(
    private val activitiesList: List<ActivitiesData>,
    private val onItemClick: (ActivitiesInfo) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            0 -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_card_item, parent, false)
                ActivitiesCardViewHolder(view)
            }
            1 -> {
                val view: View =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_date_item, parent, false)
                ActivitiesDateViewHolder(view)
            }
            else -> throw IllegalArgumentException()
        }

    override fun getItemCount() = activitiesList.size

    override fun getItemViewType(position: Int): Int {
        val item = activitiesList[position]
        return if (item is ActivitiesInfo) 0 else 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = activitiesList[position]
        when (holder) {
            is ActivitiesCardViewHolder -> holder.bind(item as ActivitiesInfo) {
                onItemClick(item)
            }
            is ActivitiesDateViewHolder -> holder.bind(item as ActivitiesDate)
            else -> throw IllegalArgumentException()
        }
    }
}

class ActivitiesCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private var currentOnClick: () -> Unit = {}

    private var cardDistance: TextView = view.findViewById(R.id.card_distance)
    private var cardTime: TextView = view.findViewById(R.id.card_time)
    private var cardType: TextView = view.findViewById(R.id.card_type)
    private var cardUser: TextView = view.findViewById(R.id.card_user)
    private var cardTimeAgo: TextView = view.findViewById(R.id.card_time_ago)

    fun bind(activitiesData: ActivitiesInfo, onClick: () -> Unit) {
        cardDistance.text = activitiesData.distance
        cardTime.text = activitiesData.time
        cardType.text = activitiesData.type
        cardUser.text = activitiesData.user ?: ""
        cardTimeAgo.text = activitiesData.timeAgo

        view.removeCallbacks(currentOnClick)
        currentOnClick = onClick

        view.setOnClickListener { onClick() }
    }
}

class ActivitiesDateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var date: TextView = view.findViewById(R.id.activities_date)

    fun bind(activitiesDate: ActivitiesDate) {
        date.text = activitiesDate.date
    }
}
