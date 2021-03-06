package com.mediaone

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_video_play.*


class VideoPlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play)
        mPlay.setOnClickListener {
            mPlay.visibility = View.GONE
            val video = Uri.parse("http://onetv.cinesoftcdn.com/onetv/live1/playlist.m3u8")
            mVideo.setVideoURI(video)
            mVideo.requestFocus()
            mProgress.visibility = View.VISIBLE
        }

        mVideo.setOnErrorListener { mp, what, extra ->
            mProgress.visibility = View.GONE
            mPlay.visibility = View.VISIBLE
            Toast.makeText(this,
                "Can't play this video. Check your Network/Server settings",
                Toast.LENGTH_SHORT).show()
            true
        }

        mVideo.setOnPreparedListener {
            mProgress.visibility = View.GONE
            mVideo.start()
        }
    }
}
