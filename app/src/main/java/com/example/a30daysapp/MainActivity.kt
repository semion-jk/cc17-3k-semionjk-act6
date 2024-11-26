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
            "Optimize Your Gaming Setup",
            "Try a New Game Genre",
            "Master a Difficult Game Level",
            "Improve Your Reaction Time",
            "Stream Your Gameplay",
            "Declutter Your Gaming Desk",
            "Watch Esports Highlights",
            "Customize Your Keybindings",
            "Complete a Speedrun Challenge",
            "Join an Online Gaming Community",
            "Revisit a Classic Game",
            "Update Your Gaming Hardware Drivers",
            "Learn a New Strategy for Your Favorite Game",
            "Take a Gaming Break for Eye Health",
            "Host a Multiplayer Game Night",
            "Set a New High Score",
            "Tackle a 100% Completion Challenge",
            "Experiment with Game Mods",
            "Level Up Your Gaming Chair Setup",
            "Create Content: Record a Gameplay Video",
            "Discover an Indie Game",
            "Practice a Game for Esports",
            "Share Your Gaming Setup Online",
            "Try a Hardcore Difficulty Mode",
            "Perfect a Combo in a Fighting Game",
            "Play a Co-op Game with Friends",
            "Participate in a Gaming Tournament",
            "Upgrade Your In-Game Skills",
            "Analyze a Pro Player's Gameplay",
            "Reflect on Your Gaming Achievements"
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
            "Adjust lighting, organize cables, and improve ergonomics. Boosts comfort and maximizes focus for better performance.",
            "Play a game type you’ve never tried before. Broadens skills, keeps gaming exciting, and challenges your adaptability.",
            "Tackle a tough stage and learn its mechanics. Builds persistence, problem-solving skills, and a sense of accomplishment.",
            "Practice reflex-intensive games or exercises. Enhances focus, hand-eye coordination, and performance across all games.",
            "Share your gaming sessions with an audience. Builds confidence, encourages creativity, and strengthens communication skills.",
            "Organize your desk, clean up peripherals, and tidy your space. Reduces distractions, boosts focus, and creates a stress-free environment.",
            "Analyze matches from professional players. Inspires new strategies, improves tactical thinking, and fuels motivation.",
            "Tailor control settings to your style. Enhances comfort, efficiency, and precision during gameplay.",
            "Attempt a fast, efficient playthrough of a game. Sharpens focus, planning, and execution under pressure.",
            "Engage with other players in forums or groups. Builds connections, fosters teamwork, and provides helpful insights.",
            "Play a nostalgic favorite or iconic title. Rekindles fond memories and deepens appreciation for gaming history.",
            "Ensure all drivers and software are up-to-date. Prevents crashes, boosts performance, and ensures smooth gameplay.",
            "Study advanced tactics or techniques. Increases success rate and gives you a competitive edge.",
            "Rest your eyes, stretch, and hydrate. Prevents eye strain, reduces fatigue, and boosts long-term health.",
            "Organize a session with friends online or locally. Strengthens friendships, encourages teamwork, and creates fun memories.",
            "Challenge yourself to beat your personal record. Builds determination, focus, and satisfaction through improvement.",
            "Collect every item, trophy, or achievement in a game. Encourages thoroughness, patience, and dedication.",
            "Install and explore creative or fan-made modifications. Unlocks new experiences and adds fresh perspectives to familiar games.",
            "Upgrade to an ergonomic chair or adjust your seating. Improves posture, reduces fatigue, and enhances overall comfort.",
            "Capture, edit, and share a memorable session. Fosters creativity, storytelling skills, and a new hobby.",
            "Try a lesser-known title with unique mechanics. Supports developers, expands horizons, and introduces new ideas.",
            "Dedicate time to refine skills in a competitive game. Boosts discipline, strategy, and performance under pressure.",
            "Post photos of your rig or workspace. Sparks pride, inspires others, and connects with like-minded gamers.",
            "Push yourself with a challenging difficulty setting. Builds resilience, critical thinking, and mastery of the game.",
            "Learn and practice a precise combo sequence. Improves muscle memory, timing, and precision under stress.",
            "Collaborate on a multiplayer game. Encourages teamwork, strengthens bonds, and creates shared experiences.",
            "Join a local or online competition. Boosts confidence, hones skills, and provides a thrilling challenge.",
            "Focus on learning new tricks or techniques. Leads to noticeable improvement and greater enjoyment in gaming.",
            "Watch and study high-level matches. Enhances understanding of strategies and sharpens your game sense.",
            "Look back on progress, skills gained, and challenges overcome. Reinforces pride, growth, and motivation for the future."
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