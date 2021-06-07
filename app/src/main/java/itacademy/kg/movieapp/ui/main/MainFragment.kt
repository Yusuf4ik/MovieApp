package itacademy.kg.movieapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import itacademy.kg.movieapp.DescFragment
import itacademy.kg.movieapp.Model.Movie
import itacademy.kg.movieapp.R
import itacademy.kg.movieapp.databinding.MainFragmentBinding


class MainFragment : Fragment(), OnItemClickListener {
    lateinit var adapter: Adapter
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getMovie()
        viewModel.getMovieRate()
        viewModel.liveDataWithRate().observe(viewLifecycleOwner, {
            start(it, false, binding.nowPlaying)
        })

        viewModel.liveDataWithoutRate().observe(viewLifecycleOwner, {
            start(it, true, binding.upcoming)
        })
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun start(movies: List<Movie>, boolean: Boolean, recyclerView: RecyclerView) {
        recyclerView.layoutManager =
            LinearLayoutManager(parentFragment?.context, LinearLayoutManager.HORIZONTAL, true)
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(parentFragment?.context, boolean, movies, this, parentFragmentManager)
        recyclerView.adapter = adapter
    }

    private fun setFragment(fragment: Fragment){
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onItemClick(position: Int) {
       Toast.makeText(context, "Button item clicked", Toast.LENGTH_SHORT).show()
        setFragment(DescFragment())
    }

    override fun onFavoriteClick(position: Int) {
        Toast.makeText(context, "Button favorite clicked", Toast.LENGTH_SHORT).show()

    }

}