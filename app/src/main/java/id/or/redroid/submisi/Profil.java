package id.or.redroid.submisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
