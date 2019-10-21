package com.dominikkrajcer.books.ui.screens.home

import androidx.navigation.fragment.findNavController
import com.dominikkrajcer.books.R
import com.dominikkrajcer.books.base.fragment.BaseFragment
import com.dominikkrajcer.books.common.VerticalDividerItemDecoration
import com.dominikkrajcer.books.databinding.HomeFragmentBinding


class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(R.layout.home_fragment) {

    override fun onCreateView() {
        binding.viewModel = viewModel
    }

    override fun setupViews() {
        setupRecyclerView()
        setupAddBooksButton()
    }

    private fun setupRecyclerView() = with(binding.booksRecyclerView) {
        adapter = HomeListAdapter(OnBookClickListener {
            navigateToDetailsFragment(it)
        })
        addItemDecoration(VerticalDividerItemDecoration(context, R.drawable.home_list_item_divider))
    }

    private fun navigateToDetailsFragment(bookId: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                bookId
            )
        )
    }

    private fun setupAddBooksButton() = with(binding.addBookFloatingActionButton) {
        setOnClickListener {
            navigateToAddFragment()
        }
    }

    private fun navigateToAddFragment() {
        findNavController().navigate(R.id.addFragment)
    }

}