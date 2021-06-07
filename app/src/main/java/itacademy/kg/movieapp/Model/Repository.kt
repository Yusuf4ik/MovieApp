package itacademy.kg.movieapp.Model

import itacademy.kg.movieapp.R

class Repository : RepoImpl {
    private val moviesWithRate = mutableListOf<Movie>()
    private val moviesWithOutRate = mutableListOf<Movie>()
    override fun getMovieWithRate(): List<Movie> {
        moviesWithRate.add(Movie("Fast and Furious 9", "2021", R.drawable.fast_and_furious, "9.1"))
        moviesWithRate.add(Movie("Green Book", "2018", R.drawable.green_book, "11.1"))
        moviesWithRate.add(Movie("Zodiac", "2007", R.drawable.zodiac, "7.8"))
        moviesWithRate.add(Movie("The Gentlemen", "2020", R.drawable.the_gentlemen, "9.2"))
        moviesWithRate.add(Movie("Scorpion", "2014", R.drawable.scorpion, "12.5"))
        moviesWithRate.add(Movie("Maze Runner", "2016", R.drawable.maze_runner, "7.5"))
        return moviesWithRate
    }

    override fun getMovieWithoutRate(): List<Movie> {
        moviesWithOutRate.add(Movie("Fast and Furious 9", "2021", R.drawable.fast_and_furious, "9.1"))
        moviesWithOutRate.add(Movie("Green Book", "2018", R.drawable.green_book, "11.1"))
        moviesWithOutRate.add(Movie("Zodiac", "2007", R.drawable.zodiac, "7.8"))
        moviesWithOutRate.add(Movie("The Gentlemen", "2020", R.drawable.the_gentlemen, "9.2"))
        moviesWithOutRate.add(Movie("Scorpion", "2014", R.drawable.scorpion, "12.5"))
        moviesWithOutRate.add(Movie("Maze Runner", "2016", R.drawable.maze_runner, "7.5"))
        return moviesWithOutRate
    }
}