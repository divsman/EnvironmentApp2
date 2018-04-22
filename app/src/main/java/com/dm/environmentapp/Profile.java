package com.dm.environmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    public static double weightRecycled; //in cubic feet
    private static boolean setUp;
    private static double energy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if (!setUp){
            weightRecycled = 0;
            energy = 0;
            setUp =true;
        }
        TextView weightText = (TextView) findViewById(R.id.button);

        weightText.setText((int)(energy * 100) / 100.0+" KwH saved!");
     }

    public double convertToEnergy(double weight){
        return weight * 84.12;
    }

    public static double getWeightRecycled() {
        return weightRecycled;
    }

    public void goToCoupons(View view){
        Intent intent = new Intent(this, Coupons.class);
        startActivity(intent);
    }
    public void displayTotal(View view) {
        TextView weightText = (TextView) findViewById(R.id.input);
        double inputWeight = Double.parseDouble(weightText.getText().toString());
        weightText.setText("");
        weightRecycled += inputWeight;
        TextView weightText2 = (TextView) findViewById(R.id.button);
        energy = convertToEnergy(weightRecycled);
        weightText2.setText((int)(energy * 100) / 100.0+" KwH saved!");
        //Progress.updateGraph(weightRecycled, convertToEnergy(weightRecycled));

        Intent i = new Intent(this, Progress.class);
        i.putExtra("key", "" + energy);
        startActivity(i);
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
