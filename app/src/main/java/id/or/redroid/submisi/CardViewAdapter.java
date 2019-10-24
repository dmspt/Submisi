package id.or.redroid.submisi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder> {

    private ArrayList<Katalog> listKatalog;
    public ArrayList<Katalog> getListKatalog() {
        return listKatalog;
    }
    public void setListKatalog(ArrayList<Katalog> listKatalog) {
        this.listKatalog = listKatalog;
    }
    private Context context;
    private OnClick onClick;

    public CardViewAdapter(Context context, OnClick onClick) {
        this.context = context;
        this.onClick = onClick;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {
        Katalog k = getListKatalog().get(position);
        holder.tampil(k, onClick);
    }

    @Override
    public int getItemCount() {
        return getListKatalog().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {

        ImageView img_src;
        TextView txt_judul, txt_isi;
        Button btn_detail;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            img_src = (ImageView) itemView.findViewById(R.id.img_src);
            txt_judul = (TextView) itemView.findViewById(R.id.txtJudul);
            txt_isi = (TextView) itemView.findViewById(R.id.txtIsi);
            btn_detail = (Button) itemView.findViewById(R.id.btnDetail);
        }

        public void tampil(final Katalog katalog, final OnClick OnItemClick) {

            Glide.with(context)
                    .load(katalog.getGambar())
                    .override(300, 300)
                    .into(img_src);

            txt_judul.setText(katalog.getJudul());
            txt_isi.setText(katalog.getIsi());
            btn_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick.onClick(katalog);

                }
            });

        }
    }

    public interface OnClick {
        void onClick(Object pahlawan);
    }

}
