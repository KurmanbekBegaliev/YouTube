package com.example.youtube.ui.nointernet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentNoInternetBinding

class NoInternetFragment : BaseFragment<FragmentNoInternetBinding, NoInternetViewModel>() {
    override val viewModel: NoInternetViewModel by lazy {
        ViewModelProvider(this)[NoInternetViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNoInternetBinding {
        return FragmentNoInternetBinding.inflate(inflater, container, false)
    }

    override fun initViews() {

    }

    override fun initListeners() {

    }

    override fun initObservers() {

    }

}