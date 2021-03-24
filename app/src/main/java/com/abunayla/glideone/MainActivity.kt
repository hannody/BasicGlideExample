package com.abunayla.glideone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abunayla.glideone.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MainActivity : AppCompatActivity() {

    private var imgOneUrl: String  = "https://abunayla.s3.amazonaws.com/media/profile_image/mohanad_2020.jpg?AWSAccessKeyId=AKIAQQB6DYB7RKGAWLP4&Signature=Q%2FeWh%2BUqZ9XGpUqT3biEtKO945Q%3D&Expires=1616586178"
    private var imgTwoUrl: String  = "https://images.goodsmile.info/cgm/images/product/20200714/9775/71951/large/fc043987452ef368ad5a8dc5b683c909.jpg"
    private var imgThreeUrl: String  = "https://static.wikia.nocookie.net/p__/images/0/08/CrashC4R.png/revision/latest/scale-to-width-down/350?cb=20200814154508&path-prefix=protagonist"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root

        Glide.with(this)
            .load(imgOneUrl)
            .fitCenter()
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.ic_launcher_background)
            .into( binding.ivOne)

        Glide.with(this)
            .load(imgTwoUrl)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_launcher_background)
            .into( binding.ivTwo)

        Glide.with(this)
            .load(imgThreeUrl)
            .into( binding.ivThree)

        setContentView(view)
    }
}