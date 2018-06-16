package com.padcmyanmar.ted2assignment.networks;

import android.os.AsyncTask;
import android.util.Log;

import com.padcmyanmar.ted2assignment.utils.TedConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionDataAgentImpl implements TedTalkDataAgents {

    private static HttpUrlConnectionDataAgentImpl objInstance;

    private HttpUrlConnectionDataAgentImpl() {
    }

    public static HttpUrlConnectionDataAgentImpl getObiInstance() {
        if (objInstance == null)
            objInstance = new HttpUrlConnectionDataAgentImpl();
        return objInstance;
    }

    @Override
    public void loadTedTalk(int page, final String accessTaken) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                URL url;
                BufferedReader reader = null;
                StringBuilder stringBuilder;

                try {
                    url = new URL(TedConstants.API_BASE + TedConstants.GET_NEWS);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("POST");

                    connection.setReadTimeout(15 * 1000);

                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    List<NameValuePair> params = new ArrayList<>();
                    params.add(new BasicNameValuePair(TedConstants.PARAM_ACCESS_TOKEN,
                            accessTaken));

                    OutputStream outputStream = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(outputStream, "UTF-8"));
                    writer.write(getQuery(params));
                    writer.flush();
                    writer.close();
                    outputStream.close();

                    connection.connect();

                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    stringBuilder = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }

                    String responseString = stringBuilder.toString();

                    /*
                    AttractionListResponse response = CommonInstances.getGsonInstance().fromJson(responseString, AttractionListResponse.class);
                    List<AttractionVO> attractionList = response.getAttractionList();

                    return attractionList;
                      */
                    return responseString;

                } catch (Exception e) {
                    Log.e("", e.getMessage());

                } finally {
                    if (reader != null)
                        try {
                            reader.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                }


                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }
        }.execute();



    }

    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
