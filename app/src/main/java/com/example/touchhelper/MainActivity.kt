package com.example.touchhelper

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var sportsAdapter: SportsAdapter
    private lateinit var mSportsData: ArrayList<Sport>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        mSportsData = arrayListOf(
            Sport("Baseball", "Here is some Baseball news!", R.drawable.img_baseball),
            Sport("Badminton", "Here is some Badminton news!", R.drawable.img_badminton),
            Sport("Basketball", "Here is some Basketball news!", R.drawable.img_basketball),
            Sport("Bowling", "Here is some Bowling news!", R.drawable.img_bowling),
            Sport("Cycling", "Here is some Cycling news!", R.drawable.img_cycling),
            Sport("Golf", "Here is some Golf news!", R.drawable.img_golf),
            Sport("Running", "Here is some Running news!", R.drawable.img_running),
            Sport("Soccer", "Here is some Soccer news!", R.drawable.img_soccer),
            Sport("Swimming", "Here is some Swimming news!", R.drawable.img_swimming),
            Sport("Table Tennis", "Here is some Table Tennis news!", R.drawable.img_tabletennis),
            Sport("Tennis", "Here is some Tennis news!", R.drawable.img_tennis),
        )

        sportsAdapter = SportsAdapter(mSportsData)
        recyclerView.adapter = sportsAdapter


        val swipeDirs = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT

        val helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            swipeDirs
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                Collections.swap(mSportsData, from, to)
                sportsAdapter.notifyItemMoved(from, to)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                mSportsData.removeAt(viewHolder.adapterPosition)
                sportsAdapter.notifyItemRemoved(viewHolder.adapterPosition)
                Toast.makeText(applicationContext, "Deleted", Toast.LENGTH_SHORT).show()
            }
        })


        helper.attachToRecyclerView(recyclerView)

    }
}