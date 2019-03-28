package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask() throws ExecutionException, InterruptedException {

        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(new EndpointAsyncTask.LaunchDisplayJokesActivityCallback() {
            @Override
            public void startDisplayJokesActivity(String joke) {

            }
        });
        endpointAsyncTask.execute();
        String joke = endpointAsyncTask.get();

        assertNotNull(joke);
    }
}
