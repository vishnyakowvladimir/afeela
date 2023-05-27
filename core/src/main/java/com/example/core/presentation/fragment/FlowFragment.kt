package com.example.core.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.R
import com.example.core.navigation.CloseScreenEvent
import com.example.core.navigation.FeatureResultEmitter
import com.example.core.navigation.setLaunchScreen
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

abstract class FlowFragment : BaseFragment() {
    private val layoutRes: Int = R.layout.layout_container

    private val currentFragment
        get() = childFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var featureEmitter: FeatureResultEmitter

    private val navigator: Navigator by lazy {
        object : AppNavigator(requireActivity(), R.id.container, childFragmentManager) {
            override fun activityBack() {
                onBackPressed()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (childFragmentManager.fragments.isEmpty()) {
            navigator.setLaunchScreen(getLaunchScreen())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(layoutRes, container, false)

    abstract fun getLaunchScreen(): Screen

    override fun onBackPressed() {
        childFragmentManager.backStackEntryCount.takeIf { it > 0 }?.let {
            currentFragment?.onBackPressed()
        } ?: featureEmitter.emit(CloseScreenEvent)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
