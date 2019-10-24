package id.or.redroid.submisi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvKatalog;
    private ArrayList<Katalog> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvKatalog = (RecyclerView) findViewById(R.id.rvKatalog);
        rvKatalog.setHasFixedSize(true);
        list = new ArrayList<>();
        list.addAll(KatalogData.getListData());

        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvKatalog.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter listKatalogAdapter = new CardViewAdapter(this, new CardViewAdapter.OnClick() {
            @Override
            public void onClick(Object katalog) {
                Katalog katalog1 = (Katalog) katalog;
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("key", katalog1);
                startActivity(intent);
            }
        });
        listKatalogAdapter.setListKatalog(list);
        rvKatalog.setAdapter(listKatalogAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(MainActivity.this, Profil.class);
        startActivity(i);

        return super.onOptionsItemSelected(item);
    }
}
