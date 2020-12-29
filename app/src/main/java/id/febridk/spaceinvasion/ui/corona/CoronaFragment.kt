package id.febridk.spaceinvasion.ui.corona

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import id.febridk.spaceinvasion.R
import id.febridk.spaceinvasion.databinding.FragmentCoronaBinding
import id.febridk.spaceinvasion.ui.home.MainActivity

class CoronaFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentCoronaBinding
    private val viewModel: CoronaViewModel by lazy { CoronaViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoronaBinding.inflate(inflater, container, false).apply {
            viewModel = this@CoronaFragment.viewModel
            lifecycleOwner = this@CoronaFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerView.adapter = CoronaAdaptor(parent)
        viewModel.listCorona()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listCorona()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
            binding.swipeRefresh.isRefreshing = it
        }

        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            } else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}