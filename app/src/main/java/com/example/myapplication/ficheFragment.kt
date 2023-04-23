package com.example.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.myapplication.Product


class FicheFragment : Fragment() {


    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_fiche,
            container, false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = NavHostFragment.create(
            R.navigation.bottombar_nav
        )

        val barcode = FicheFragmentArgs.fromBundle(requireArguments()).barcode
        println(barcode)

        //requete
        GlobalScope.launch(Dispatchers.Main) {

            val productResponse: Product = withContext(Dispatchers.Default) {
                NetworkManager.getProduct(barcode)
            }

        }

        childFragmentManager.beginTransaction()
            .replace(
                R.id.product_details_nav_host, navHostFragment
            ).commitAllowingStateLoss()

        navHostFragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)

                NavigationUI.setupWithNavController(
                    view.findViewById<BottomNavigationView>(R.id.menu),
                    navHostFragment.navController
                )
            }
        })
    }
}