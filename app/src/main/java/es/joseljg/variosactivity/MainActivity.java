package es.joseljg.variosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar_a_pantalla2(View view) {
        Intent intent = new Intent(this, Pantalla2Activity.class);
        startActivity(intent);
    }
}