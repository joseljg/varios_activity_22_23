package es.joseljg.variosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO_MENSAJE = "es.joseljg.variosactivity.MainActivity.mensaje_enviado";
    private EditText edt_texto_envio_pantalla1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_texto_envio_pantalla1 = (EditText) findViewById(R.id.edt_texto_envio_pantalla1);
    }

    public void enviar_a_pantalla2(View view) {
        Intent intent = new Intent(this, Pantalla2Activity.class);
        String texto = String.valueOf(edt_texto_envio_pantalla1.getText());
        intent.putExtra(EXTRA_TEXTO_MENSAJE,texto);
        startActivity(intent);
    }
}