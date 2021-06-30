package by.kos.hogwartsinfo.ui.scenes.hat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
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

        binding.editTextWelcomeUserName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                hatViewModel.applyUserName(name = s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        binding.btnWelcomeSelect.setOnClickListener {
            hatViewModel.getFacultyName()
        }

        setupFaculty(viewModel = hatViewModel)
        setupLoading(viewModel = hatViewModel)
    }

    private fun setupLoading(viewModel: HatViewModel) {
        viewModel.isLoading.observe(this, Observer { isLoading ->
            binding.editTextWelcomeUserName.isEnabled = !isLoading
            binding.btnWelcomeSelect.isEnabled = !isLoading
        })

    }

    private fun setupFaculty(viewModel: HatViewModel) {
        viewModel.facultyName.observe(this, Observer { facultyName ->
            if (facultyName.isNotEmpty()) {
                binding.txtWelcomeSelected.text =
                    getString(R.string.welcome_selected).replace("[faculty_name]", facultyName)
                binding.txtWelcomeSelected.visibility = View.VISIBLE
            }
        })

    }
}