package by.kos.hogwartsinfo.ui.scenes.hat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.kos.hogwartsinfo.R
import by.kos.hogwartsinfo.databinding.ActivityHatBinding
import by.kos.hogwartsinfo.helpers.Keys
import by.kos.hogwartsinfo.ui.scenes.main.MainActivity

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
        setupLoading(viewModel = hatViewModel)
        setupFaculty(viewModel = hatViewModel)
        binding.btnWelcomeSelect.setOnClickListener {
            if(binding.btnWelcomeSelect.text == getString(R.string.to_hogwarts)){
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }  else hatViewModel.getFacultyName()
        }
    }

    private fun setupLoading(viewModel: HatViewModel) {
        viewModel.isLoading.observe(this, Observer { isLoading ->
            if(isLoading) binding.editTextWelcomeUserName.isEnabled = false
            binding.btnWelcomeSelect.isEnabled = !isLoading
            if(isLoading) binding.btnWelcomeSelect.text = getString(R.string.thinking)
        })
    }

    private fun setupFaculty(viewModel: HatViewModel) {
        viewModel.facultyName.observe(this, Observer { facultyName ->
            if (facultyName.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences(getString(R.string.app_name),0)
                sharedPreferences.edit()
                    .putString(Keys.USERNAME.value, binding.editTextWelcomeUserName.text.toString())
                    .putString(Keys.FACULTY.value, facultyName)
                    .apply()
                binding.txtWelcomeSelected.text =
                    getString(R.string.welcome_selected).replace("[faculty_name]", facultyName)
                binding.txtWelcomeSelected.visibility = View.VISIBLE
                binding.btnWelcomeSelect.text = getString(R.string.to_hogwarts)
            }
        })
    }
}