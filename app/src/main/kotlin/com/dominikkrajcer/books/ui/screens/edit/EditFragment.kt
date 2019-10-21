package com.dominikkrajcer.books.ui.screens.edit

import androidx.navigation.findNavController
import com.dominikkrajcer.books.R
import com.dominikkrajcer.books.base.fragment.BaseFragment
import com.dominikkrajcer.books.common.extensions.addOnTextChangeListener
import com.dominikkrajcer.books.common.extensions.hideKeyboard
import com.dominikkrajcer.books.databinding.EditFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class EditFragment : BaseFragment<EditFragmentBinding, EditViewModel>(R.layout.edit_fragment) {

    private val bookId by lazy { EditFragmentArgs.fromBundle(arguments!!).bookId }

    override val viewModel: EditViewModel by viewModel { parametersOf(bookId) }

    override fun onCreateView() {
        binding.viewModel = viewModel
    }

    override fun setupViews() {
        setupEditBooksButton()
        setupISBEditText()
    }

    private fun setupEditBooksButton() = with(binding.editBookButton) {
        setOnClickListener {
            viewModel.onEditButtonClicked()
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