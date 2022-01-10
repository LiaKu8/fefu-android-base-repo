package ru.fefu.activitytracker.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.fragments.MainActivityFragment
import ru.fefu.activitytracker.fragments.MainProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container_view,
                MainActivityFragment(),
                "MainActivityFragment"
            )
            .addToBackStack("tag name")
            .commit()


        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_item_activity -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction = detachFragmentByTag(transaction, "MainProfileFragment")

                    val mainActivityFragment =
                        supportFragmentManager.findFragmentByTag("MainActivityFragment")

                    if (mainActivityFragment != null) {
                        transaction.show(mainActivityFragment)
                    } else {
                        transaction.add(
                            R.id.fragment_container_view,
                            MainProfileFragment(),
                            "MainActivityFragment"
                        ).addToBackStack("tag name")
                    }.commit()
                }
                R.id.menu_item_profile -> {
                    var transaction = supportFragmentManager.beginTransaction()
                    transaction = detachFragmentByTag(transaction, "MainActivityFragment")

                    val profileFragment =
                        supportFragmentManager.findFragmentByTag("MainProfileFragment")

                    if (profileFragment != null) {
                        transaction.show(profileFragment)
                    } else {
                        transaction.add(
                            R.id.fragment_container_view,
                            MainProfileFragment(),
                            "MainProfileFragment"
                        ).addToBackStack("tag name")
                    }.commit()
                }
            }
            true
        }
    }

    override fun onBackPressed() {
        finish()
    }

    private fun detachFragmentByTag(
        transaction: FragmentTransaction,
        tag: String
    ): FragmentTransaction {
        val fragment = supportFragmentManager.findFragmentByTag(tag)
        return if (fragment != null) {
            transaction.hide(fragment)
        } else {
            transaction
        }
    }
}