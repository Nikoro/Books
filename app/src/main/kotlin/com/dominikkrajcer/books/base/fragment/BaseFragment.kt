package com.dominikkrajcer.books.base.fragment

import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.dominikkrajcer.books.common.extensions.second
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<B : ViewDataBinding, VM : ViewModel>(@LayoutRes val layoutRes: Int, @MenuRes val menuRes: Int? = null) :
    Fragment() {

    lateinit var binding: B

    open val viewModel: VM by lazy { getViewModel(viewModelClass()) }

    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass() =
        ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments.second() as Class<VM>).kotlin


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(menuRes != null)
        onCreateView()
        return binding.root
    }

    open fun onCreateView() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        onViewCreated()
    }

    open fun setupViews() {}

    open fun onViewCreated() {}

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menuRes?.let { inflater.inflate(it, menu) }
    }

    fun <T> observe(liveData: LiveData<T>, code: (T) -> Unit) {
        liveData.observe(viewLifecycleOwner, Observer {
            code(it)
        })
    }

}