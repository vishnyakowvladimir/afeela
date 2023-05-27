package com.example.afeela.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.afeela.R
import com.example.afeela.databinding.ActivityMainBinding
import com.example.afeela.di.component.MainAppComponent
import com.example.afeela.navigation.BaseFeatureEventsListener
import com.example.core.navigation.RootRoutingEmitter
import com.example.core.presentation.activity.BaseActivity
import com.example.core.presentation.fragment.BaseFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var rootRoutingEmitter: RootRoutingEmitter

    @Inject
    lateinit var featureEventsListener: BaseFeatureEventsListener

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private lateinit var binding: ActivityMainBinding
    private val containerId = R.id.fragment_wrapper

    override fun onCreate(savedInstanceState: Bundle?) {
        MainAppComponent.get().inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareToolbar()
        subscribe()
        viewModel.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        unsubscribe()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val currentFlowFragment = getCurrentFragment()
        val flowFragmentCount = supportFragmentManager.backStackEntryCount
        when {
            flowFragmentCount == 1 && currentFlowFragment?.childFragmentManager?.backStackEntryCount == 0 -> {
                finish()
            }
            getCurrentFragment() is BaseFragment -> {
                (getCurrentFragment() as BaseFragment).onBackPressed()
            }

            else -> super.onBackPressed()
        }
    }

    private fun getCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(R.id.fragment_wrapper)
    }

    private fun prepareToolbar() {
        setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun subscribe() {
        featureEventsListener.subscribe()
        rootRoutingEmitter.subscribe(supportFragmentManager, containerId)
    }

    private fun unsubscribe() {
        rootRoutingEmitter.unsubscribe()
        featureEventsListener.unsubscribe()
    }
}