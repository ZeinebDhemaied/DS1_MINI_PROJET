package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // njibou el vues mel layout bel id mte3hom
        EditText etNom = findViewById(R.id.et_nom_nj);
        EditText etNaissance = findViewById(R.id.et_naissance_nj);
        EditText etDestination = findViewById(R.id.et_destination_nj);
        Spinner spMotif = findViewById(R.id.sp_motif_nj);
        Button btnInspecter = findViewById(R.id.btn_inspecter_nj);

        btnInspecter.setOnClickListener(v -> {
            String nom = etNom.getText().toString().trim();
            String naissance = etNaissance.getText().toString().trim();
            String destination = etDestination.getText().toString().trim();

            // nthabtou ken el champs kol me3abyin
            if (nom.isEmpty() || naissance.isEmpty() || destination.isEmpty()) {
                Toast.makeText(this, "Remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            // nsob el donnees fel Intent explicite w nab3athhom lel activity 2
            Intent intent = new Intent(this, VerificationActivity.class);
            intent.putExtra(Cles.cle(Cles.MATRICULE, "NOM_VOYAGEUR"), nom);
            intent.putExtra(Cles.cle(Cles.MATRICULE, "ANNEE_NAISSANCE"), Integer.parseInt(naissance));
            intent.putExtra(Cles.cle(Cles.MATRICULE, "ANNEE_DESTINATION"), Integer.parseInt(destination));
            intent.putExtra(Cles.cle(Cles.MATRICULE, "MOTIF"), spMotif.getSelectedItem().toString());
            startActivity(intent);
        });
    }
}