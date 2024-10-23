package com.example.a30daysapp

import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList:Array<Int>
    lateinit var dateList: Array<String>
    lateinit var titleList: MutableList<String>
    lateinit var textList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        titleList = mutableListOf<String>()

        for (i in 1..30){
            val dayString = "Day $i"
            titleList.add(dayString)
        }

        dateList = arrayOf(
            "Start Your Day with a Morning Routine",
            "Drink More Water",
            "10-Minute Meditation",
            "Set a Goal for Today",
            "Go for a Walk"

        )

        imageList = arrayOf(
            R.drawable.day1,
            R.drawable.day2,
            R.drawable.day3,
            R.drawable.day4,
            R.drawable.day5
        )

        textList = arrayOf(
            "Establishing a morning routine boosts productivity, reduces stress, and sets a positive tone for the rest of the day",
            "Staying hydrated improves focus, increases energy levels, and supports overall bodily functions, including digestion and circulation",
            "Meditation reduces anxiety, enhances emotional health, and improves attention span, helping you stay calm and focused throughout the day",
            "Setting a daily goal provides direction and motivation, leading to a sense of accomplishment as you check off tasks",
            "Walking improves physical health, boosts mood, and enhances creativity by giving your brain a break from everyday stressors"

        )

        recyclerView =  findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getData() {
        for (i in imageList.indices){
            val dataClass = DataClass(titleList[i], dateList[i], imageList[i], textList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)
    }

}