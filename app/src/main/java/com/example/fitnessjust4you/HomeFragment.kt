package com.example.fitnessjust4you

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.bumptech.glide.Glide
import com.example.fitnessjust4you.adapter.BodyStatsAdapter
import com.example.fitnessjust4you.adapter.ChartAdapter
import com.example.fitnessjust4you.data.entities.BodyStats
import com.example.fitnessjust4you.data.entities.Chart
import com.example.fitnessjust4you.databinding.FragmentHomeBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //viewModel.getChartURL()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Home"
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            var bitmap = getBitmapFromURL("https://fastly.picsum.photos/id/385/200/300.jpg?hmac=IG8cHDliDmlgbSYX1yquX_5cAHcuS_O378oPs5rZGrU")
            println(bitmap)
        }



    }

    fun getBitmapFromURL(src: String?): Bitmap? {
        return try {
            val url = URL(src)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.setDoInput(true)
            connection.connect()
            val input: InputStream = connection.getInputStream()
            BitmapFactory.decodeStream(input)
        } catch (e: IOException) {
            // Log exception
            null
        }
    }

   /* private suspend fun getBitmap(): Bitmap {
        Log.d("HomeFragment", "getBitmap function started")
        val loading = ImageLoader(requireContext())
        Log.d("HomeFragment", "ImageKLoader started")
        val request = ImageRequest.Builder(requireContext())
            .data("https://img.freepik.com/fotos-kostenlos/trauriger-babywolf-im-wald-der-auf-generative-ki-im-freien-wartet_1258-150896.jpg?w=826&t=st=1681824209~exp=1681824809~hmac=cd7d07b766b273664828ebed3eeb0d80f4e87302a56a8084ab63cdd5bacb55a3")
            .build()
        Log.d("HomeFragment", "request created")
            val result = (loading.execute(request) as SuccessResult).drawable
            println(result)

        Log.d("HomeFragment", "result created")

            return (result as BitmapDrawable).bitmap
    }*/

}