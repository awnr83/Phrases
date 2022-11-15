package com.moappdev.phrases.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moappdev.phrases.databinding.ActivityMainBinding
import com.moappdev.phrases.ui.viewmodel.PharseViewModel
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pharseViewModel: PharseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pharseViewModel.onCreate()
        createViewModel()
    }

    private fun createViewModel() {
//todo con esta dependencia       implementation 'androidx.activity:activity-ktx:1.1.0'
//        se puede definir asi el viewmodel en vez de la forma vieja
//        private val pharseViewModel: PharseViewModel by viewModels()
//        pharseViewModel = ViewModelProvider(this).get(PharseViewModel::class.java)

        binding.apply {

            pharseViewModel.is_loading.observe(this@MainActivity,{
                pb.isVisible= it
            })

            //al hacer clic busca una frase aleatoria
            clData.setOnClickListener {
                pharseViewModel.randomQuote()
            }

            //oyente de cambios
            pharseViewModel.pharse.observe(this@MainActivity, Observer{
                it?.let {
                    tvPharse.text= it.quote
                    tvAuthor.text= it.author
                }
            })
        }
    }
}