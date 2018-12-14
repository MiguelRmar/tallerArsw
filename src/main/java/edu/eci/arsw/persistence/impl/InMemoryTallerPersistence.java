/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.persistence.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;
import edu.eci.arsw.persistence.TallerPersistence;

/**
 *
 * @author Miguel
 */
@Service("Alpha")
public class InMemoryTallerPersistence implements TallerPersistence {

    @Override
    public String getIntradayShare(String shareName) throws IOException {
        String url = "http://www.omdbapi.com/?apikey=[yourkey]&";
        return getUrlData(url);
    }

    @Override
    public String getDiaryShare(String shareName) throws IOException {
        String url = "http://www.omdbapi.com/?apikey=[yourkey]&";
        return getUrlData(url);
    }

    @Override
    public String getWeeklyShare(String shareName) throws IOException {
        String url = "http://www.omdbapi.com/?apikey=[yourkey]&";
        return getUrlData(url);
    }

    @Override
    public String getMonthlyShare(String shareName) throws IOException {
        String url = "http://www.omdbapi.com/?apikey=[yourkey]&";
        return getUrlData(url);
    }

    public String getUrlData(String GET_URL) throws IOException {

        String USER_AGENT = "Mozilla/5.0";

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            return "GET request not worked";
        }
    }

}
