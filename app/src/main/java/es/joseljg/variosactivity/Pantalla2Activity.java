package es.joseljg.variosactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Log.i("ciclo_de_vida", "estoy en el estado oncreate de la pantalla2");

        //-------------------------------------------------
        Intent intent = getIntent(); // enlazo con el intent recibido
        if(intent != null)
        {
            Bundle bundle = intent.getExtras();
            String texto_recibido_en_el_intent =  bundle.getString(MainActivity.EXTRA_TEXTO_MENSAJE);
            String texto2 = bundle.getString(MainActivity.EXTRA_TEXTO_MENSAJE2);
            int numero = bundle.getInt(MainActivity.EXTRA_NUMERO);

            // String texto_recibido_en_el_intent =  intent.getStringExtra(MainActivity.EXTRA_TEXTO_MENSAJE);
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


    //------------------------------------------------------------------------------------------------

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo_de_vida", "estoy en el estado onstart de la pantalla2");
    }

    //------------------------------------------------------------------------------------------------

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo_de_vida", "estoy en el estado onresume de la pantalla2");
    }

    //------------------------------------------------------------------------------------------------


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo_de_vida", "estoy en el estado onpause de la pantalla2");
    }

    //------------------------------------------------------------------------------------------------


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo_de_vida", "estoy en el estado onstop de la pantalla2");
    }
    //------------------------------------------------------------------------------------------------


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo_de_vida", "estoy en el estado ondestroy de la pantalla2");
    }

    //------------------------------------------------------------------------------------------------


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo_de_vida", "estoy en el estado onrestart de la pantalla2");
    }

    //------------------------------------------------------------------------------------------------
}