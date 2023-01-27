package com.mdev.movieadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchMovieBtn = findViewById<Button>(R.id.search_movie)

        searchMovieBtn.setOnClickListener {
            val movieChoose = findViewById<Spinner>(R.id.movie_options)
            val selectedMovie = movieChoose.selectedItem
            val movieList = getMovies(selectedMovie.toString())
            val movieDesc = getDescription(selectedMovie.toString())
            val movies = movieList.reduce { str, item ->str + '\n' + item}
            val finalMovies = findViewById<TextView>(R.id.movie)
            val finalMoviesDesc = findViewById<TextView>(R.id.movie_des)
            finalMovies.text = movies
            finalMoviesDesc.text = "$movieDesc"

        }

    }
    fun getMovies(type: String): List<String> {
        return when(type) {
            "Adventure" -> listOf("Inception", "The Godfather", "Titanic")
            "Comedy" -> listOf("3 idiots", "Oh My God!","Hindi Medium")
            "Drama" -> listOf("White Noise", "The Fallout", "Athena")
            "Action" -> listOf("The Dark Knight","Die Hard", "Point Break")
            "Horror" -> listOf("Smile","The Black Phone", "old")
            "Animation" -> listOf("Strange World","Light Year", "Robots")
            else -> listOf("Data does not exist.")
        }
    }

    fun getDescription(type: String): String {
        return when(type) {
            "Adventure" -> "A common theme of adventure films is of characters leaving their home or place of comfort and going to fulfill a goal, embarking on travels, quests, treasure hunts, heroic journeys; and explorations or searches for the unknown. Subgenres of adventure films include swashbuckler films, pirate films, and survival films."
            "Comedy" -> "A comedy film is a category of film which emphasizes humor.These films are designed to make the audience laugh through amusement."
            "Drama" -> "Drama Films are serious presentations or stories with settings or life situations that portray realistic characters in conflict with either themselves, others, or forces of nature. A dramatic film shows us human beings at their best, their worst, and everything in-between."
            "Action" -> "Action films are built around a core set of characteristics: spectacular physical action; a narrative emphasis on fights, chases, and explosions; and a combination of state-of-the-art special effects and stunt-work."
            "Horror" -> "Horror films may incorporate incidents of physical violence and psychological terror; they may be studies of deformed, disturbed, psychotic, or evil characters; stories of terrifying monsters or malevolent animals; or mystery thrillers that use atmosphere to build suspense."
            "Animation" -> "Animation is a method by which still figures are manipulated to appear as moving images. In traditional animation, images are drawn or painted by hand on transparent celluloid sheets to be photographed and exhibited on film. Today, most animations are made with computer-generated imagery (CGI)."
            else -> ""
        }

    }
}