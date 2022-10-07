package es.joseljg.variosactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXTO_MENSAJE = "es.joseljg.variosactivity.MainActivity.mensaje_enviado";
    private static final int PETICION1 = 1;
    public static final String EXTRA_NUMERO = "es.joseljg.variosactivity.MainActivity.numero_enviado";
    public static final String EXTRA_TEXTO_MENSAJE2 = "es.joseljg.variosactivity.MainActivity.mensaje_enviado2";
    private EditText edt_texto_envio_pantalla1;
    private TextView txt_recibido_pantalla1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_texto_envio_pantalla1 = (EditText) findViewById(R.id.edt_texto_envio_pantalla1);
        txt_recibido_pantalla1 = (TextView) findViewById(R.id.txt_recibido_pantalla1);
        Log.i("ciclo_de_vida", "estoy en el estado oncreate de la pantalla1");
    }
//------------------------------------------------------------------------------------------------

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ciclo_de_vida", "estoy en el estado onstart de la pantalla1");
    }

    //------------------------------------------------------------------------------------------------

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ciclo_de_vida", "estoy en el estado onresume de la pantalla1");
    }

    //------------------------------------------------------------------------------------------------


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ciclo_de_vida", "estoy en el estado onpause de la pantalla1");
    }

    //------------------------------------------------------------------------------------------------


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ciclo_de_vida", "estoy en el estado onstop de la pantalla1");
    }
    //------------------------------------------------------------------------------------------------


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ciclo_de_vida", "estoy en el estado ondestroy de la pantalla1");
    }

    //------------------------------------------------------------------------------------------------


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ciclo_de_vida", "estoy en el estado onrestart de la pantalla1");
    }

    //------------------------------------------------------------------------------------------------

    public void enviar_a_pantalla2(View view) {
        Intent intent = new Intent(this, Pantalla2Activity.class);
        String texto = String.valueOf(edt_texto_envio_pantalla1.getText());
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TEXTO_MENSAJE, texto);
        bundle.putInt(EXTRA_NUMERO, 3);
        bundle.putString(EXTRA_TEXTO_MENSAJE2, "hola");
        intent.putExtras(bundle);
       // intent.putExtra(EXTRA_TEXTO_MENSAJE,texto);
        startActivityForResult(intent,PETICION1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        edt_texto_envio_pantalla1.setText("");
        if(requestCode == PETICION1)
        {
            if(resultCode == RESULT_OK)
            {
                String texto = data.getStringExtra(Pantalla2Activity.EXTRA_MENSAJE_RESPUESTA);
                txt_recibido_pantalla1.setText(texto);
                txt_recibido_pantalla1.setVisibility(View.VISIBLE);
            }
        }
    }


}