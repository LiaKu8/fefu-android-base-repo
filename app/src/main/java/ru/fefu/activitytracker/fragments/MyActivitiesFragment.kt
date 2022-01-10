package ru.fefu.activitytracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.activitytracker.ActivitiesAdapter
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.Repository
import ru.fefu.activitytracker.activities.DetailActivity

class MyActivitiesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_activities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.my_activities_recycler)

        recyclerView.layoutManager = LinearLayoutManager(context);
        recyclerView.adapter = ActivitiesAdapter(Repository.myActivitiesList) {
            startActivity(DetailActivity.getIntent(requireContext(), it))
        }
    }
}