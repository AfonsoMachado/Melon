package com.forcetower.unes.feature.home

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.forcetower.unes.R
import com.forcetower.unes.databinding.ActivityHomeBinding
import com.forcetower.unes.feature.shared.ToolbarActivity
import com.forcetower.unes.feature.shared.UActivity
import com.forcetower.unes.feature.shared.config
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class HomeActivity : UActivity(), ToolbarActivity, HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var binding: ActivityHomeBinding
    private val bottomFragment: HomeBottomFragment by lazy { HomeBottomFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home).also { it ->
            binding = it
            setSupportActionBar(it.bottomAppBar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            it.bottomAppBar.setNavigationOnClickListener {
                if (!bottomFragment.isAdded) bottomFragment.show(supportFragmentManager, bottomFragment.tag)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.home_nav_host).navigateUp()

    override fun getToolbar(): Toolbar = binding.toolbar

    override fun getTabLayout(): TabLayout = binding.tabLayout

    override fun getAppBar(): AppBarLayout = binding.appBar

    override fun showSnack(string: String) {
        val snack = Snackbar.make(binding.snack, string, Snackbar.LENGTH_SHORT)
        snack.config()
        snack.show()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}