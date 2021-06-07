package itacademy.kg.movieapp.ui.main

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import itacademy.kg.movieapp.DescFragment
import itacademy.kg.movieapp.Model.Movie
import itacademy.kg.movieapp.Model.Repository
import itacademy.kg.movieapp.R

class MainViewModel : ViewModel(){
    private val liveDataMovieWithRate = MutableLiveData<List<Movie>>()
    private val liveDataMovieWithoutRate = MutableLiveData<List<Movie>>()

    private val repository = Repository()
    fun getMovieRate(){
        val movieList = repository.getMovieWithRate()
        liveDataMovieWithRate.value = movieList
    }

    fun getMovie(){
        val movies = repository.getMovieWithoutRate()
        liveDataMovieWithoutRate.value = movies
    }

    fun liveDataWithRate() : MutableLiveData<List<Movie>> {
        return liveDataMovieWithRate
    }

    fun liveDataWithoutRate(): MutableLiveData<List<Movie>>{
        return liveDataMovieWithoutRate
    }

    fun onClickMethod(position: Int, view: View, fragmentManager: FragmentManager){
        when(view.id){
            R.id.favorite ->{
            repository.getMovieWithRate()[position].isFavorite = true
            }
            R.id.parent ->{
                fragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, DescFragment())
                    addToBackStack(null)
                    commit()
                }
            }

        }

    }

}