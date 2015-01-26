package net.udevi.itracks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Timur on 1/26/2015.
 */
public class HttpManager {

    public static final String ITUNES_SEARCH_URL = "https://itunes.apple.com/search?entity=song&term=";

    public static String getData(String searchedTerm) {
        BufferedReader reader = null;

        try {
            String encodedTerm = URLEncoder.encode(searchedTerm, "UTF-8");

            URL url = new URL(ITUNES_SEARCH_URL + encodedTerm);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
