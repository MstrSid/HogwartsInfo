package by.kos.hogwartsinfo.ui.scenes.hat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import by.kos.hogwartsinfo.R
import by.kos.hogwartsinfo.databinding.ActivityHatBinding

class HatActivity : AppCompatActivity() {

    private lateinit var hatViewModel: HatViewModel
    private lateinit var binding: ActivityHatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hatViewModel = ViewModelProvider(this).get(HatViewModel::class.java)
    }
}