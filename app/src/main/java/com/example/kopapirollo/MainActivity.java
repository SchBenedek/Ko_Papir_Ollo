package com.example.kopapirollo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton button_ko;
    private ImageButton button_papir;
    private ImageButton button_ollo;
    private Integer ember_elet=3;
    private Integer gep_elet=3;
    private Integer dontetlen=0;
    private TextView dontetlenText;
    private ImageView[] ember_heart=new ImageView[3];
    private ImageView[] gep_heart=new ImageView[3];
    private Random random;
    private Integer gep_jatekSzam=0;
    private Integer ember_jatekSzam=0;
    private LinearLayout linearLayout;
    private ImageView ember_valasztas;
    private ImageView gep_valasztas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        button_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember_valasztas.setImageResource(R.drawable.rock);
                GepKepGen();
                ember_jatekSzam=0;
                Jatek();
            }
        });
        button_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember_valasztas.setImageResource(R.drawable.paper);
                GepKepGen();
                ember_jatekSzam=1;
                Jatek();
            }
        });
        button_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember_valasztas.setImageResource(R.drawable.scissors);
                GepKepGen();
                ember_jatekSzam=2;
                Jatek();
            }
        });

    };

    public int GepKepGen(){
        gep_jatekSzam=random.nextInt(3);
        if(gep_jatekSzam==0)
        {
            gep_valasztas.setImageResource(R.drawable.rock);
        } else if (gep_jatekSzam==1) {
           gep_valasztas.setImageResource(R.drawable.paper);
        }
        else {
            gep_valasztas.setImageResource(R.drawable.scissors);
        }
        return gep_jatekSzam;
    }

    public void Jatek(){
        if(gep_jatekSzam==ember_jatekSzam)
        {
            dontetlen++;
            dontetlenText.setText(String.format("Döntetlenek száma: %s",dontetlen));
            Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
        } else if (gep_jatekSzam==0 && ember_jatekSzam==1) {
            Eletcsokkentes("gep");
            Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
        } else if (gep_jatekSzam==0 && ember_jatekSzam==2) {
            Eletcsokkentes("ember");
            Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
        } else if (gep_jatekSzam==1 && ember_jatekSzam==0) {
            Eletcsokkentes("ember");
            Toast.makeText(MainActivity.this, "Vesztettél", Toast.LENGTH_SHORT).show();
        } else if (gep_jatekSzam==1 && ember_jatekSzam==2) {
            Eletcsokkentes("gep");
            Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
        } else if (gep_jatekSzam==2 && ember_jatekSzam==0) {
            Eletcsokkentes("gep");
            Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_SHORT).show();
        } else if (gep_jatekSzam==2 && ember_jatekSzam==1) {
            Eletcsokkentes("ember");
            Toast.makeText(MainActivity.this, "vesztettél", Toast.LENGTH_SHORT).show();
        }
    }

    void Eletcsokkentes(String csokkentendo){
        if (csokkentendo == "gep" && gep_elet > 1){
            gep_heart[gep_elet-1].setBackgroundResource(R.drawable.heart1);
            gep_elet--;
        } else if (csokkentendo == "gep" && gep_elet == 1) {
            gep_heart[gep_elet-1].setBackgroundResource(R.drawable.heart1);
            gep_elet--;
            Jatekvege();
        }else if (csokkentendo == "ember" && ember_elet > 1) {
            ember_heart[ember_elet-1].setBackgroundResource(R.drawable.heart1);
            ember_elet--;
        }else if (csokkentendo == "ember" && ember_elet == 1) {
            ember_heart[ember_elet-1].setBackgroundResource(R.drawable.heart1);
            ember_elet--;
            Jatekvege();
        }
    }

    void Jatekvege(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretne új játékot kezdeni?");
        if(gep_elet==0){
            builder.setTitle("Győzelem");
        }
        else{
            builder.setTitle("Vereség");
        }
        builder.setPositiveButton("Nem", (DialogInterface.OnClickListener) (dialog, which) -> {
            // When the user click yes button then app will close
            finish();
        });
        builder.setNegativeButton("Igen", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            Ujjatek();
            dialog.cancel();
        });
        builder.show();
    }

    public void Ujjatek(){
        ember_elet=3;
        gep_elet=3;
        ember_jatekSzam=0;
        gep_jatekSzam=0;
        dontetlen=0;
        for (int i=0; i<ember_heart.length;i++) {
            ember_heart[i].setBackgroundResource(R.drawable.heart2);
        }
        for (int i=0; i<gep_heart.length;i++) {
            gep_heart[i].setBackgroundResource(R.drawable.heart2);
        }
    }

    public void init(){
        button_ko=findViewById(R.id.button_ko);
        button_papir=findViewById(R.id.button_papir);
        button_ollo=findViewById(R.id.button_ollo);
        random=new Random();
        ember_valasztas=findViewById(R.id.ember_Valasztas);
        gep_valasztas=findViewById(R.id.gep_Valasztas);
        dontetlenText=findViewById(R.id.dontetlen);
        ember_heart[0]=findViewById(R.id.ember_heart1);
        ember_heart[1]=findViewById(R.id.ember_heart2);
        ember_heart[2]=findViewById(R.id.ember_heart3);
        gep_heart[0]=findViewById(R.id.gep_heart1);
        gep_heart[1]=findViewById(R.id.gep_heart2);
        gep_heart[2]=findViewById(R.id.gep_heart3);
    }
}