package dev.filipebezerra.android.example.fancontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.filipebezerra.android.example.fancontroller.databinding.FanControllerFragmentBinding

class FanControllerFragment : Fragment() {

    private lateinit var viewBinding: FanControllerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FanControllerFragmentBinding.inflate(inflater, container, false)
        .apply { viewBinding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}