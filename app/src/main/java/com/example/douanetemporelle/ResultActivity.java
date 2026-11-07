package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        View racine = findViewById(R.id.ll_racine_nj);
        TextView tvIcone = findViewById(R.id.tv_icone_nj);
        TextView tvMessage = findViewById(R.id.tv_message_nj);
        Button btnNouveau = findViewById(R.id.btn_nouveau_nj);

        // nrecuperiw el verdict w el esm
        String nom = getIntent().getStringExtra(Cles.cle(Cles.MATRICULE, "NOM_VOYAGEUR"));
        boolean verdict = getIntent().getBooleanExtra(Cles.cle(Cles.MATRICULE, "VERDICT"), false);

        // el alwen njibouhom mel colors.xml: khadhra ken approuvé, 7amra ken refusé
        if (verdict) {
            racine.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            tvIcone.setText("\u2714");
            tvMessage.setText("Bon voyage " + nom);
        } else {
            racine.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            tvIcone.setText("\u2716");
            tvMessage.setText(nom + " est en état d'arrestation temporelle");
        }

        // nraj3ou lel MainActivity w nsakrou el activities el kol elli9bal
        btnNouveau.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}