package dev.trung.music.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import dev.trung.music.R;
import dev.trung.music.data.model.Song;

/**
 * Created by trungnv on 9/8/2016.
 */
public class MusicAdapter extends ArrayAdapter<Song> {
    private List<Song> mSongs;
    private TextView mTextView;
    private ImageView mImageView;

    public MusicAdapter(Context context, List<Song> mSongs) {
        super(context, 0, mSongs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song s = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.activity_list_item, parent, false);
        mTextView = (TextView) convertView.findViewById(android.R.id.text1);
        mImageView = (ImageView) convertView.findViewById(android.R.id.icon);
        mTextView.setText(s.getTitle());

        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        if (mmr.getEmbeddedPicture() != null) {
            Bitmap icon = BitmapFactory.decodeByteArray(mmr.getEmbeddedPicture(), 0, mmr.getEmbeddedPicture().length);
            mImageView.setImageBitmap(icon);
        } else {
            mImageView.setImageResource(R.mipmap.ic_launcher);
        }
        return convertView;
    }
}
