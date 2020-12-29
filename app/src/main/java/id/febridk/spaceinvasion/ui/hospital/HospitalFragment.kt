package id.febridk.spaceinvasion.ui.hospital

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.febridk.spaceinvasion.R

class HospitalFragment : Fragment() {

    companion object {
        fun newInstance() = HospitalFragment()
    }

    private lateinit var viewModel: HospitalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hospital, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HospitalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}