package com.example.cryptobag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private TextView mName;
    private TextView mSymbol;
    private TextView mValue;
    private TextView mChange1h;
    private TextView mChange24h;
    private TextView mChange7d;
    private TextView mMarketcap;
    private TextView mVolume;
    private ImageView imageView2;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String coinSymbol = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        ArrayList<Coin> coins = Coin.getCoins();

        final Coin coin = Coin.getCoins().get(0);

        mName = (TextView) findViewById(R.id.mName);
        mSymbol = (TextView) findViewById(R.id.mSymbol);
        mValue = (TextView) findViewById(R.id.mvalue);
        mChange1h = (TextView) findViewById(R.id.mChange1h);
        mChange24h = (TextView) findViewById(R.id.mChange24h);
        mChange7d = (TextView) findViewById(R.id.mChange7d);
        mMarketcap = (TextView) findViewById(R.id.mMarketcap);
        mVolume = (TextView) findViewById(R.id.mVolume);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                search();
            }
        });

        mName.setText(coin.getName());
        mSymbol.setText(coin.getSymbol());
        mValue.setText(formatter.format(coin.getValue()));
        mChange1h.setText((coin.getChange1h()) + "%");
        mChange24h.setText((coin.getChange24h()) + "%");
        mChange7d.setText((coin.getChange7d()) + "%");
        mMarketcap.setText(formatter.format(coin.getMarketcap()));
        mVolume.setText(formatter.format(coin.getVolume()));
    }

    public void search() {
        String url = "https://www.google.com/search?sxsrf=ALeKk02nEoq5TMMFtivmMz_lntftaiP2yg%3A1583392184002&source=hp&ei=t6VgXpW1OYHSz7sPgr-k6AI&q=cryptocurrency&oq=cryptocurrency&gs_l=psy-ab.3..0i131l7j0l3.156.5828..6350...1.0..0.303.2919.0j9j5j1......0....1..gws-wiz.......35i39j0i10.jvrcuXlIoPw&ved=0ahUKEwjV7KfF44LoAhUB6XMBHYIfCS0Q4dUDCAg&uact=5";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}

