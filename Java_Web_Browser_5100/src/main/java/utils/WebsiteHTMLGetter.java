package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteHTMLGetter {
    public static String getHTMLCode(String url) throws IOException {
        URL website = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) website.openConnection();
        connection.setRequestMethod("GET");

        // get website content
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder htmlcode = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            htmlcode.append(line).append("\n");
        }
        reader.close();
        return htmlcode.toString();
    }
}
