package id.or.redroid.submisi;

import android.os.Parcel;
import android.os.Parcelable;

public class Katalog implements Parcelable {

    private String judul, isi, gambar;

    protected Katalog(Parcel pc) {
        judul = pc.readString();
        isi = pc.readString();
        gambar = pc.readString();

    }

    public static final Parcelable.Creator<Katalog> CREATOR = new Parcelable.Creator<Katalog>() {
        @Override
        public Katalog createFromParcel(Parcel pc) {
            return new Katalog(pc);
        }

        @Override
        public Katalog[] newArray(int size) {
            return new Katalog[size];
        }
    };

    public Katalog() {

    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.judul);
        parcel.writeString(this.isi);
        parcel.writeString(this.gambar);
    }
}
