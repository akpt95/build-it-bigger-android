package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private MyApi myApiService = null;

    private LaunchDisplayJokesActivityCallback displayJokesActivityCallback;

    public interface LaunchDisplayJokesActivityCallback{
        void startDisplayJokesActivity(String joke);
    }

    public EndpointAsyncTask(LaunchDisplayJokesActivityCallback displayJokesActivityCallback){

        this.displayJokesActivityCallback = displayJokesActivityCallback;
    }

    @Override
    protected String doInBackground(Void... voids) {

        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getJokeData();
        } catch (IOException e) {
            return  e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if(s!=null){
            displayJokesActivityCallback.startDisplayJokesActivity(s);
        }
    }
}
