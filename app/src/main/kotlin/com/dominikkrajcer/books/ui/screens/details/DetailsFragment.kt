package com.dominikkrajcer.books.ui.screens.details

import android.view.MenuItem
import androidx.navigation.fragment.findNavController
import com.dominikkrajcer.books.R
import com.dominikkrajcer.books.base.fragment.BaseFragment
import com.dominikkrajcer.books.common.extensions.setTitle
import com.dominikkrajcer.books.databinding.DetailsFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailsFragment :
    BaseFragment<DetailsFragmentBinding, DetailsViewModel>(
        R.layout.details_fragment,
        R.menu.details_menu
    ) {

    private val bookId by lazy { DetailsFragmentArgs.fromBundle(arguments!!).bookId }

    override val viewModel: DetailsViewModel by viewModel { parametersOf(bookId) }

    override fun onCreateView() {
        binding.viewModel = viewModel
    }

    override fun onViewCreated() {
        observeBook()
    }


    private fun observeBook() {
        observe(viewModel.book) {
            setTitle(it.title)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit -> navigateToEditFragment(bookId)
            R.id.delete -> showDeleteBookConfirmationDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateToEditFragment(bookId: Int) {
        findNavController().navigate(
            DetailsFragmentDirections.actionDetailsFragmentToEditFragment(
                bookId
            )
        )
    }

    private fun showDeleteBookConfirmationDialog() {
        MaterialAlertDialogBuilder(context)
            .setTitle("Are you sure you want to delete this book?")
            .setNegativeButton("Cancel") { _, _ -> }
            .setPositiveButton("Ok") { _, _ ->
                viewModel.onDeleteConfirmationButtonClicked()
                findNavController().navigateUp()
            }
            .show()
    }
}