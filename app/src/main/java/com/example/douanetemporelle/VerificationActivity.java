package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        TextView tvNom = findViewById(R.id.tv_nom_nj);
        TextView tvAge = findViewById(R.id.tv_age_nj);
        TextView tvMotif = findViewById(R.id.tv_motif_nj);
        Button btnApprouver = findViewById(R.id.btn_approuver_nj);
        Button btnRefuser = findViewById(R.id.btn_refuser_nj);

        // nrecuperiw el donnees elli jou mel activity 1 bel cles mte3hom
        Intent recu = getIntent();
        String nom = recu.getStringExtra(Cles.cle(Cles.MATRICULE, "NOM_VOYAGEUR"));
        int naissance = recu.getIntExtra(Cles.cle(Cles.MATRICULE, "ANNEE_NAISSANCE"), 0);
        int destination = recu.getIntExtra(Cles.cle(Cles.MATRICULE, "ANNEE_DESTINATION"), 0);
        String motif = recu.getStringExtra(Cles.cle(Cles.MATRICULE, "MOTIF"));

        // el age temporel = destination - naissance
        int age = destination - naissance;

        tvNom.setText("Nom : " + nom);
        tvAge.setText("Age temporel : " + age + " ans");
        tvMotif.setText("Motif : " + motif);

        // ken motif = modification du passé w el farq premier => nde3ml disable lel bouton
        if (motif != null && motif.equals(getString(R.string.motif_modif)) && estPremier(age)) {
            btnApprouver.setEnabled(false);
        }

        // el bouton approuver yab3ath verdict = true
        btnApprouver.setOnClickListener(v -> ouvrirVerdict(nom, true));
        // el bouton refuser yab3ath verdict = false
        btnRefuser.setOnClickListener(v -> ouvrirVerdict(nom, false));
    }

    // nlanci el activity 3 m3a el verdict w esm el voyageur
    private void ouvrirVerdict(String nom, boolean verdict) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(Cles.cle(Cles.MATRICULE, "NOM_VOYAGEUR"), nom);
        intent.putExtra(Cles.cle(Cles.MATRICULE, "VERDICT"), verdict);
        startActivity(intent);
    }

    // methode tchouf ken el 3adad premier wala le
    private boolean estPremier(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}