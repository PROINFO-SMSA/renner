package br.com.renner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VendaActivity extends AppCompatActivity {

    ImageView featured_imagee;
    private Spinner spnColors;
    private Spinner spnTams;
    private Button btVoltar;
    private Button btVComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);
        featured_imagee = findViewById(R.id.my_featured_images);

        spnColors = (Spinner) findViewById(R.id.spinnerColors);
        spnTams   = (Spinner) findViewById(R.id.spinnerTam);

        btVoltar     = (Button) findViewById(R.id.btnVoltar);
        btVComprar   = (Button) findViewById(R.id.btComprar);

        String[] lsColors = getResources().getStringArray(R.array.lista_cores);
        spnColors.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lsColors));


        String[] lsTamns= getResources().getStringArray(R.array.lista_tamanhos);
        spnTams.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lsTamns));


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("imagem");
            carregaImagem(value);

        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VendaActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

        btVComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(VendaActivity.this, "Obrigado Pela Compra e Volte Sempre!!", Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void carregaImagem(int value){
      switch(value) {
          case 0:
              featured_imagee.setImageResource(R.drawable.imgu);
              break;
          case 1:
              featured_imagee.setImageResource(R.drawable.imgd);
              break;
          case 2:
              featured_imagee.setImageResource(R.drawable.imgt);
              break;
          case 3:
              featured_imagee.setImageResource(R.drawable.imgq);
              break;
          case 4:
              featured_imagee.setImageResource(R.drawable.imgc);
              break;
          case 5:
              featured_imagee.setImageResource(R.drawable.imgs);
              break;
          case 6:
              featured_imagee.setImageResource(R.drawable.imgse);
              break;
          case 7:
              featured_imagee.setImageResource(R.drawable.imgn);
              break;
          case 8:
              featured_imagee.setImageResource(R.drawable.imgn);
              break;
          case 9:
              featured_imagee.setImageResource(R.drawable.imgdz);
              break;
          case 10:
              featured_imagee.setImageResource(R.drawable.img11);
              break;
          default:
              featured_imagee.setImageResource(R.drawable.imgu);
              break;
      }

  }

}


