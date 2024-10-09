package com.example.kopapirollo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton button_ko;
    private ImageButton button_papir;
    private ImageButton button_ollo;
    private TextView Viewvalasztas;
    private Integer ember_szam=0;
    private Integer gep_szam=0;
    private ImageView ko;
    private ImageView papir;
    private ImageView ollo;
    private Random random;
    private Integer gep_jatekSzam=0;
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
            }
        });
        button_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember_valasztas.setImageResource(R.drawable.paper);
            }
        });
        button_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember_valasztas.setImageResource(R.drawable.scissors);
            }
        });

    };
    public void init(){
        button_ko=findViewById(R.id.button_ko);
        button_papir=findViewById(R.id.button_papir);
        button_ollo=findViewById(R.id.button_ollo);
        //Viewvalasztas=findViewById(R.id.Viewvalasztas);
        random=new Random();
        gep_jatekSzam= random.nextInt(2);
        //ko=findViewById(R.id.ko);
        //papir=findViewById(R.id.papir);
        ember_valasztas=findViewById(R.id.ember_Valasztas);
        gep_valasztas=findViewById(R.id.gep_Valasztas);

    }
}