package com.example.recepinanc.etkinlikogreniyorum;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class EtkinlikBir extends ActionBarActivity {


    EditText ad,soyad,yas,ileti;
    RadioButton erkek,kiz;
    Button gonder,temizle;

    public void gonder_tikla(View v){
        try{

            Intent i = new Intent(getApplicationContext(),Etkinlikiki.class);
            i.putExtra(Sabitler.AD,ad.getText().toString());
            i.putExtra(Sabitler.SOYAD,soyad.getText().toString());
            i.putExtra(Sabitler.YAS,Integer.parseInt(yas.getText().toString()));
            i.putExtra(Sabitler.ILETI,ileti.getText().toString());
            if(erkek.isChecked())
            {
                i.putExtra(Sabitler.CINSIYET,getText(R.string.erkekCinsiyet));
            }else if(kiz.isChecked())
            {
                i.putExtra(Sabitler.CINSIYET,getText(R.string.kadinCinsiyet));
            }
            startActivity(i);

        }catch(Exception e){
            Toast.makeText(getApplicationContext(),getText(R.string.hata),Toast.LENGTH_SHORT).show();
        }
    }

    public void temizle_tikla(View v){

        ad.setText("");
        soyad.setText("");
        yas.setText("");
        ileti.setText("");
        erkek.setChecked(true);
        kiz.setChecked(false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etkinlik_bir);

        ad = (EditText)findViewById(R.id.adVeri);
        soyad = (EditText)findViewById(R.id.soyadVeri);
        yas = (EditText)findViewById(R.id.yasVeri);
        ileti = (EditText)findViewById(R.id.iletiVeri);

        erkek  = (RadioButton)findViewById(R.id.erkekButton);
        kiz = (RadioButton)findViewById(R.id.kadinButton);

        gonder = (Button)findViewById(R.id.gonderDugme);
        temizle = (Button)findViewById(R.id.temizleDugme);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_etkinlik_bir, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
