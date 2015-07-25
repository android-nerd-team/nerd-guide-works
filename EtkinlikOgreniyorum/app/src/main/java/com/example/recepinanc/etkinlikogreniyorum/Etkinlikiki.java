package com.example.recepinanc.etkinlikogreniyorum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Etkinlikiki extends ActionBarActivity {

    TextView bilgi;
    Button geri;

    public void geri_tikla(View v){
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etkinlik_iki);

        bilgi = (TextView)findViewById(R.id.bilgiMetni);
        geri = (Button)findViewById(R.id.geriDugme);

        String bilgiMetni = "";

        if(getIntent().getExtras().getString(Sabitler.CINSIYET).equals(getString(R.string.erkekCinsiyet)))
        {
            bilgiMetni = getString(R.string.metin_bay);
        }
        else if(getIntent().getExtras().getString(Sabitler.CINSIYET).equals(getString(R.string.kadinCinsiyet)))
        {
            bilgiMetni = getString(R.string.metin_bayan);
        }

        bilgiMetni += " " + getIntent().getExtras().getString(Sabitler.AD)
                + " " + getIntent().getExtras().getString(Sabitler.SOYAD)
                + " (" + getIntent().getExtras().getInt(Sabitler.YAS) + ") "
                + getString(R.string.metin_diyor)
                + getIntent().getExtras().getString(Sabitler.ILETI);

        bilgi.setText(bilgiMetni);

    }

}
