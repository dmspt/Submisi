package id.or.redroid.submisi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    ImageView gambar;
    TextView judul, isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Katalog acc = getIntent().getParcelableExtra("key");

        gambar = (ImageView) findViewById(R.id.img_view);
        judul = (TextView) findViewById(R.id.txtJudul);
        isi = (TextView) findViewById(R.id.txtJudul);

        Glide.with(this).load(acc.getGambar()).override(300, 300).into(gambar);

        judul.setText(acc.getJudul());
        isi.setText(acc.getIsi());

    }
}
