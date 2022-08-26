package com.example.controlmyfinance.presentation.show_finance

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.controlmyfinance.R
import com.example.controlmyfinance.databinding.FragmentShowFinanceBinding
import com.example.controlmyfinance.presentation.add_finance.AddFinanceFragment
import com.example.controlmyfinance.presentation.helper.replaceFragment
import com.example.controlmyfinance.presentation.main.MainActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.RuntimeException


class ShowFinanceFragment : Fragment(R.layout.fragment_show_finance) {

    private val binding: FragmentShowFinanceBinding by viewBinding()
    private val viewModel: ShowFinanceViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    companion object {
        private const val POSITION = "position"

        fun initFinanceFr(position: Int): ShowFinanceFragment {
            val fragment = ShowFinanceFragment()
            val bundle = Bundle()
            bundle.putInt(POSITION, position)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPagerAndTabLayout()
        initFab()
        initPosition()
    }

    private fun initPosition() {
        viewModel.setMode(arguments?.getInt(POSITION) ?: -1)
        viewModel.modeLiveData.observe(viewLifecycleOwner) {
            when (it) {
                0 -> {
                    binding.viewPager.setCurrentItem(0, false)
                }
//                1 -> {
//                    binding.viewPager.setCurrentItem(1, false)
//                }
                else -> {
                }
            }
        }
    }

    private fun initViewPagerAndTabLayout() {
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                binding.viewPager.currentItem = position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            if (position == 0) {
                tab.text = getString(R.string.expenses)
            } else {
//                tab.text = getString(R.string.profit)
            }
        }.attach()
    }

    private fun initFab() {
        binding.fab.setOnClickListener {
            (requireActivity() as MainActivity).replaceFragment(
                AddFinanceFragment.initAddFinanceFr(
                    binding.viewPager.currentItem
                )
            )
        }
    }

}