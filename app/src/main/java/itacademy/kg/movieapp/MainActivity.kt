package itacademy.kg.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import itacademy.kg.movieapp.databinding.MainActivityBinding
import itacademy.kg.movieapp.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(MainFragment())
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_menu -> setFragment(MainFragment())
//                R.id.favourite_menu -> setFragment(FavouriteFragment())
//                R.id.ratings_menu -> setFragment(RateFragment())

            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            commit()
        }
    }

}