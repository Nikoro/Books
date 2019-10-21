package com.dominikkrajcer.books.ui.screens.add

import androidx.navigation.findNavController
import com.dominikkrajcer.books.R
import com.dominikkrajcer.books.base.fragment.BaseFragment
import com.dominikkrajcer.books.common.extensions.addOnTextChangeListener
import com.dominikkrajcer.books.common.extensions.hideKeyboard
import com.dominikkrajcer.books.databinding.AddFragmentBinding

class AddFragment : BaseFragment<AddFragmentBinding, AddViewModel>(R.layout.add_fragment) {

    override fun onCreateView() {
        binding.viewModel = viewModel
    }

    override fun setupViews() {
        setupAddBooksButton()
        setupISBEditText()
    }

    private fun setupAddBooksButton() = with(binding.addBookButton) {
        setOnClickListener {
            viewModel.onAddButtonClicked()
            hideKeyboard()
            findNavController().navigateUp()
        }
    }

    private fun setupISBEditText() = with(binding.ISBNEditText) {
        addOnTextChangeListener {
            viewModel.onISBNEdiTextChanged(it)
        }
    }
}