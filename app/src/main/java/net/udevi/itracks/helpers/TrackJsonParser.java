package net.udevi.itracks.helpers;

import net.udevi.itracks.model.Track;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timur on 1/26/2015.
 */
public class TrackJsonParser {

    public static final String RESULTS = "results";
    public static final String TRACK_ID = "trackId";
    public static final String ARTIST_NAME = "artistName";
    public static final String TRACK_NAME = "trackName";
    public static final String TRACK_TIME_MILLIS = "trackTimeMillis";
    public static final String ARTWORK_URL = "artworkUrl60";

    public static List<Track> parseFeed(String content) {

        try {
            JSONObject response = new JSONObject(content);
            JSONArray responseArr = response.getJSONArray(RESULTS);
            List<Track> trackList = new ArrayList<>();

            for (int i = 0; i < responseArr.length(); i++) {
                JSONObject trackJson = responseArr.getJSONObject(i);
                Track track = new Track();

                track.setId(trackJson.getLong(TRACK_ID));
                track.setArtist(trackJson.getString(ARTIST_NAME));
                track.setTitle(trackJson.getString(TRACK_NAME));
                track.setDurationMillis(trackJson.getLong(TRACK_TIME_MILLIS));
                track.setArtworkUrl(trackJson.getString(ARTWORK_URL));

                trackList.add(track);
            }

            return trackList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}
