package com.fourdt.musicgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class AlbumDetailsActivity extends AppCompatActivity {
    Song nowPlayingSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        Album album = getIntent().getParcelableExtra("album name");
        nowPlayingSong = getIntent().getParcelableExtra("now playing song");
        updateNowPlaying();
        ListView albumSongs = findViewById(R.id.album_songs_list);
        albumSongs.setAdapter(new SongAdapter(this,album.getSongs()));
    }

    public void playSong (Song song){
        nowPlayingSong = song;
        updateNowPlaying();
    }

    private void updateNowPlaying (){
        TextView nowPlayingTextView = findViewById(R.id.now_playing_text_view);
        if (nowPlayingSong != null){
            nowPlayingTextView.setText(nowPlayingSong.getName());
        } else {
            nowPlayingTextView.setText(R.string.no_track_playing);
        }
    }
}
