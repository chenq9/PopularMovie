package com.example.android.popularmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailActivityFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class DetailActivityFragment extends Fragment {

        public DetailActivityFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Intent intent = getActivity().getIntent();
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            if (intent != null && intent.hasExtra("movie")) {
                String[] movieInfo = intent.getStringArrayExtra("movie");
                TextView name = (TextView) rootView.findViewById(R.id.name);
                name.setText(movieInfo[0]);

                ImageView image = (ImageView) rootView.findViewById(R.id.imageThumb);
                String url = movieInfo[1];
                Picasso.with(getActivity())
                        .load(url)
                        .error(R.raw.image_not_found)
                        .into(image);

                TextView date = (TextView) rootView.findViewById(R.id.date);
                date.setText(movieInfo[2]);

                TextView language = (TextView) rootView.findViewById(R.id.language);
                language.setText(movieInfo[3]);

                TextView rating = (TextView) rootView.findViewById(R.id.rating);
                rating.setText(movieInfo[4] + "/10.0");

                TextView plot = (TextView) rootView.findViewById(R.id.plot);
                plot.setText(movieInfo[5]);
            }
            return rootView;
        }
    }
}
