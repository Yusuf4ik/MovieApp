package itacademy.kg.movieapp.Model

interface RepoImpl {
    fun getMovieWithRate(): List<Movie>
    fun getMovieWithoutRate(): List<Movie>
}