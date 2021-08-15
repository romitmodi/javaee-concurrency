package org.romit.learning.concurrency.runnables;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Objects;

public class URLHealthProcessor implements Runnable {

    private static String HTTP_URL = "http://www.google.com";

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        String appUrlStatus = "";
        URL url = null;
        try {
            url = new URL(HTTP_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (Objects.equals(responseCode, 200)) {
                appUrlStatus = "Connection is successful";
            } else {
                appUrlStatus = "Connection is failure";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println(appUrlStatus);
    }

}
