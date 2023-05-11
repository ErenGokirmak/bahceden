package com.swifties.bahceden.data;


import android.os.AsyncTask;

import com.swifties.bahceden.models.PostAction;
import com.swifties.bahceden.models.Retrievable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBConnection extends AsyncTask <Retrievable, Integer, PostAction> {

    public static void retrieveFromDB (PostAction postAction, Retrievable... retrievables)
    {
        new DBConnection(postAction).execute(retrievables);
    }
    PostAction postAction;

    public DBConnection (PostAction postAction)
    {
        this.postAction = postAction;
    }

    @Override
    protected PostAction doInBackground(Retrievable... retrievables) {
        for (Retrievable r : retrievables)
        {
            try
            {
                String urlString = "http://10.0.2.2:8080/" + r.getClass().getSimpleName().toLowerCase() + "s/" + r.getId();
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String dataString = reader.readLine();
                Parser.parse(dataString, r);
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
        return this.postAction;
    }

    @Override
    protected void onPostExecute(PostAction postAction) {
        postAction.Action();
    }
}
