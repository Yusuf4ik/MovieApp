package itacademy.kg.movieapp.Model

data class Movie(
    val nameOfMovie: String,
    val yearOfRelease: String,
    val photoOfMovie: Int,
    val rate: String,
    var isFavorite : Boolean = false
)