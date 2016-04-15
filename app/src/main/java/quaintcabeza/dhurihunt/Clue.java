package quaintcabeza.dhurihunt;

import android.os.Parcel;
import android.os.Parcelable;

public class Clue implements Parcelable {
    // Value semantic class representing a 'Clue'.

    public int d_imageUrl;
    public String d_videoUrl;
    public String d_passPhrase;
    public Boolean d_passHoGayi;

    // CREATORS
    public Clue(
            ) {
        d_passHoGayi = false;
    }

    // Parcelable interface
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        // Encode to parcel
        out.writeInt(d_imageUrl);
        out.writeString(d_videoUrl);
        out.writeString(d_passPhrase);
        out.writeInt(d_passHoGayi ? 1 : 0);
    }

    private Clue(Parcel in) {
        // Decode from parcel
        d_imageUrl = in.readInt();
        d_videoUrl = in.readString();
        d_passPhrase = in.readString();
        d_passHoGayi = (in.readInt() == 0) ? false : true;
    }

    public static final Parcelable.Creator<Clue> CREATOR
            = new Parcelable.Creator<Clue>() {
        public Clue createFromParcel(Parcel in) {
            return new Clue(in);
        }
        public Clue[] newArray(int size) {
            return new Clue[size];
        }
    };
}
