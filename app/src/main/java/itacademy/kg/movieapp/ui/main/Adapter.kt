package itacademy.kg.movieapp.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import itacademy.kg.movieapp.Model.Movie
import itacademy.kg.movieapp.R
import itacademy.kg.movieapp.databinding.ItemMovieBinding
import itacademy.kg.movieapp.databinding.ItemMovieBinding.inflate

class Adapter(
    var context: Context?,
    var boolean: Boolean,
    private var movies: List<Movie>,
    var listener: OnItemClickListener,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<Adapter.MovieHolder>() {


    inner class MovieHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        var title: TextView = binding.goodTitleNow
        val viewModel = MainViewModel()
        var date: TextView = binding.goodDateNow
        var rate: TextView = binding.goodRateNow
        var movie: ImageView = binding.goodImageNow
        var parent: CardView = binding.parent
        var favorite: ImageView = binding.favorite
        init {

            parent.setOnClickListener(this)
            favorite.setOnClickListener{
                if(!movies[adapterPosition].isFavorite){
                    binding.favorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                    movies[adapterPosition].isFavorite = true
                }else if(movies[adapterPosition].isFavorite){
                    binding.favorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                    movies[adapterPosition].isFavorite = false

                }
                notifyDataSetChanged()
            }


        }
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.parent -> listener.onItemClick(adapterPosition)
               R.id.favorite -> listener.onFavoriteClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = ItemMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.apply {
            movie.setImageResource(movies[position].photoOfMovie)
            title.text = movies[position].nameOfMovie
            date.text = movies[position].yearOfRelease
            rate.text = movies[position].rate
        }

    }

}

interface OnItemClickListener {
    fun onItemClick(position: Int)
    fun onFavoriteClick(position: Int)
}