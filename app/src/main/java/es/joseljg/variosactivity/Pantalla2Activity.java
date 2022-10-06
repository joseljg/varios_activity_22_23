package es.joseljg.variosactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Pantalla2Activity extends AppCompatActivity {

    public static final String EXTRA_MENSAJE_RESPUESTA ="es.joseljg.variosactivity.pantalla2activity.mensaje_respuesta" ;
    private TextView txt_recibido_pantalla2;
    private EditText edt_respuesta_pantalla2;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        txt_recibido_pantalla2 = (TextView) findViewById(R.id.txt_recibido_pantalla2);
        edt_respuesta_pantalla2 = (EditText) findViewById(R.id.edt_respuesta_pantalla2);

        //-------------------------------------------------
        Intent intent = getIntent(); // enlazo con el intent recibido
        if(intent != null)
        {
            String texto_recibido_en_el_intent =  intent.getStringExtra(MainActivity.EXTRA_TEXTO_MENSAJE);
            txt_recibido_pantalla2.setText(texto_recibido_en_el_intent);
        }
    }


    public void enviar_respuesta_pantalla1(View view) {
        String texto_respuesta = String.valueOf(edt_respuesta_pantalla2.getText());
        Intent intent_respuesta = new Intent();
        intent_respuesta.putExtra(EXTRA_MENSAJE_RESPUESTA,texto_respuesta);
        setResult(RESULT_OK, intent_respuesta);
        finish();
    }
}