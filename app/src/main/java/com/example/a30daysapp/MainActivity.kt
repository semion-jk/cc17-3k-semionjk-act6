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
            "Go for a Walk",
            "Declutter Your Workspace",
            "Practice Gratitude",
            "Stretch for 5 Minutes",
            "Plan Tomorrow’s Tasks Today",
            "Read for 15 Minutes",
            "Organize Your Digital Files",
            "Take a Break from Social Media",
            "Practice Deep Breathing",
            "Journal for 10 Minutes",
            "Start a New Hobby",
            "Limit Sugar Intake",
            "Try a New Exercise",
            "Reflect on Your Achievements",
            "Prioritize Sleep",
            "Make a Healthy Meal",
            "Visualize Your Goals",
            "Have a No-Complaint Day",
            "Spend Time Outdoors",
            "Create a Vision Board",
            "Practice Mindful Eating",
            "Learn Something New",
            "Disconnect from Technology for 1 Hour",
            "Random Act of Kindness",
            "Organize Your Closet",
            "Reflect on the Last 30 Days"
        )

        imageList = arrayOf(
            R.drawable.day1,
            R.drawable.day2,
            R.drawable.day3,
            R.drawable.day4,
            R.drawable.day5,
            R.drawable.day6,
            R.drawable.day7,
            R.drawable.day8,
            R.drawable.day9,
            R.drawable.day10,
            R.drawable.day11,
            R.drawable.day12,
            R.drawable.day13,
            R.drawable.day14,
            R.drawable.day15,
            R.drawable.day16,
            R.drawable.day17,
            R.drawable.day18,
            R.drawable.day19,
            R.drawable.day20,
            R.drawable.day21,
            R.drawable.day22,
            R.drawable.day23,
            R.drawable.day24,
            R.drawable.day25,
            R.drawable.day26,
            R.drawable.day27,
            R.drawable.day28,
            R.drawable.day29,
            R.drawable.day30
        )

        textList = arrayOf(
            "Establishing a morning routine boosts productivity, reduces stress, and sets a positive tone for the rest of the day",
            "Staying hydrated improves focus, increases energy levels, and supports overall bodily functions, including digestion and circulation",
            "Meditation reduces anxiety, enhances emotional health, and improves attention span, helping you stay calm and focused throughout the day",
            "Setting a daily goal provides direction and motivation, leading to a sense of accomplishment as you check off tasks",
            "Walking improves physical health, boosts mood, and enhances creativity by giving your brain a break from everyday stressors",
            "A tidy workspace reduces distractions, improves focus, and can make you feel more organized and in control of your environment",
            "Gratitude fosters positivity, improves mental health, and strengthens relationships by shifting your focus from what you lack to what you have",
            "Stretching increases flexibility, improves circulation, and relieves muscle tension, especially if you sit for long periods",
            "Planning ahead reduces stress, increases productivity, and helps you manage your time more effectively by prioritizing tasks",
            "Reading enhances knowledge, reduces stress, and improves focus and concentration, all while stimulating mental growth",
            "A clean digital environment increases productivity, reduces clutter-induced stress, and makes it easier to find important files quickly",
            "A social media detox reduces anxiety, improves focus, and allows you to be more present with your surroundings and relationships",
            "Deep breathing reduces stress, lowers blood pressure, and increases relaxation by stimulating the body's parasympathetic nervous system",
            "Journaling helps clarify thoughts, process emotions, and reflect on personal growth, leading to better mental and emotional health",
            "Engaging in a hobby enhances creativity, reduces stress, and provides a sense of accomplishment and fulfillment outside of work",
            "Reducing sugar improves energy levels, mental clarity, and overall health, lowering the risk of health issues like diabetes and obesity",
            "Trying new exercises challenges your body, prevents workout monotony, and promotes physical and mental growth by stepping out of your comfort zone",
            "Reflecting on achievements boosts self-esteem, encourages positive thinking, and fosters motivation to continue growing and improving",
            "Quality sleep improves cognitive function, enhances mood, and supports physical health by allowing the body to repair and recharge",
            "Preparing a healthy meal improves nutrition, boosts energy, and enhances overall well-being by nourishing your body with balanced, wholesome ingredients",
            "Visualization strengthens motivation, builds confidence, and helps manifest your desires by mentally focusing on your goals",
            "Focusing on positivity reduces stress, strengthens relationships, and improves mental well-being by breaking the cycle of negativity",
            "Being outdoors improves mood, reduces stress, and enhances creativity, while exposing you to fresh air and natural light",
            "A vision board clarifies your goals, reinforces your dreams, and keeps you visually reminded of what you want to achieve, increasing motivation",
            "Mindful eating improves digestion, reduces overeating, and enhances the enjoyment of meals by fostering awareness of food choices and portions",
            "Learning new things improves brain health, enhances self-confidence, and promotes personal growth by expanding your knowledge and skills",
            "Disconnecting from technology reduces stress, improves focus, and helps you be more present, fostering deeper connections with your surroundings",
            "Acts of kindness increase happiness, improve mental health, and strengthen social bonds, benefiting both you and the recipient",
            "A decluttered closet reduces decision fatigue, makes it easier to find clothes, and provides a sense of accomplishment and order in your space",
            "Reflecting on the past 30 days reinforces progress, highlights areas of growth, and helps you solidify lasting changes and new habits"
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