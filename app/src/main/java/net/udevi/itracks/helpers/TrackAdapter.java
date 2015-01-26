package net.udevi.itracks.helpers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.udevi.itracks.R;
import net.udevi.itracks.model.Track;

import java.util.List;

/**
 * Created by tpoperecinii on 1/26/2015.
 */
public class TrackAdapter extends ArrayAdapter<Track> {

    private Context context;
    private List<Track> tracks;

    public TrackAdapter(Context context, int resource, List<Track> trackList) {
        super(context, resource, trackList);

        this.context = context;
        this.tracks = trackList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Track track = tracks.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_track, null);

//        ImageView image = view.findViewById(R.id.artworkImage);
//        image.setImageResource();

        TextView trackTitle = (TextView) view.findViewById(R.id.trackTitle);
        trackTitle.setText(track.getTitle());

        TextView artistName = (TextView) view.findViewById(R.id.artistName);
        artistName.setText(track.getArtist());

        TextView duration = (TextView) view.findViewById(R.id.durationFormatted);
        duration.setText(track.getFormattedDuration());

        return super.getView(position, convertView, parent);
    }
}
