package fauzi.hilmy.quizmaps21;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    public static String EX_NAMA = "nama";
    public static String EX_DETAIL = "detail";
    public static String EX_GAMBAR = "gambar";
    public static String EX_LAT = "latitude";
    public static String EX_LONG = "longi";
    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.txtDetail)
    TextView txtDetail;
    @BindView(R.id.imgMaps)
    ImageView imgMaps;
    String nama, gambar, detail;
    double lati, longi;
//    GoogleMap mapp;

    private static String BASE_URL = "https://maps.googleapis.com/maps/api/staticmap?center=";
    private static String END_URL = "&zoom=15&size=1000x500&maptype=hybrid&markers=color:red%7C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        nama = getIntent().getStringExtra(EX_NAMA);
        gambar = getIntent().getStringExtra(EX_GAMBAR);
        detail = getIntent().getStringExtra(EX_DETAIL);
        lati = getIntent().getDoubleExtra(EX_LAT, 0);
        longi = getIntent().getDoubleExtra(EX_LONG, 0);
        setTitle(nama);
        Picasso.with(this)
                .load(gambar)
                .placeholder(R.drawable.click)
                .fit()
                .into(imgDetail);
        txtDetail.setText(detail);

        Picasso.with(this)
                .load(BASE_URL + lati + "," + longi + END_URL + lati + "," + longi)
                .fit()
                .into(imgMaps);

        imgMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(DetailActivity.this)
                        .load(BASE_URL + lati + "," + longi + END_URL + lati + "," + longi)
                        .placeholder(R.drawable.click)
                        .fit()
                        .into(imgMaps);
            }
        });
//        LatLng latLng = new LatLng(lati, longi);
//        mapp.addMarker(new MarkerOptions()
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.location))
//                .position(latLng)
//                .title(nama));
//        mapp.addMarker(new MarkerOptions().position(latLng));
//        mapp.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 4.0f));
//        imgMaps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                imgMaps.setImageBitmap(null);
//                imgMaps.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
//            }
//        });
////https://maps.googleapis.com/maps/api/staticmap?
//// center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=hybrid
//// &markers=color:blue%7Clabel:S%7C40.702147,-74.015794
//// &markers=color:green%7Clabel:G%7C40.711614,-74.012318
//// &markers=color:red%7Clabel:C%7C40.718217,-73.998284
//        mapp.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
//            @Override
//            public void onMapLoaded() {
//                mapp.snapshot(new GoogleMap.SnapshotReadyCallback() {
//                    @Override
//                    public void onSnapshotReady(Bitmap bitmap) {
//                        imgMaps.setLayoutParams(new RelativeLayout.LayoutParams(
//                                ViewGroup.LayoutParams.MATCH_PARENT,
//                                ViewGroup.LayoutParams.MATCH_PARENT));
//                        imgMaps.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        });

    }
}
