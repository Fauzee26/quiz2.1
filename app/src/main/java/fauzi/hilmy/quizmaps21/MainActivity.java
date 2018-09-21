package fauzi.hilmy.quizmaps21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import fauzi.hilmy.quizmaps21.model.Wisata;
import fauzi.hilmy.quizmaps21.model.WisataData;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerWisata)
    RecyclerView recyclerWisata;
    WisataAdapter adapter;
    ArrayList<Wisata> wisatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        wisatas = new ArrayList<>();
        wisatas.addAll(WisataData.getWisataMakassar());

        recyclerWisata.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WisataAdapter(wisatas, MainActivity.this);
        recyclerWisata.setAdapter(adapter);
    }
}
