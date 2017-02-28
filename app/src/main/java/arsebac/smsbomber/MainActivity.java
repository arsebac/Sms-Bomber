package arsebac.smsbomber;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;


public class MainActivity extends ActionBarActivity {
    Button envoyer = null;
    EditText numero = null;
    EditText message = null;
    EditText nombre = null;
    EditText tempsAttente = null;
    String actual_message = "";
    String actual_numero = "";
    int actual_nombre = 0;
    int actual_tempsAttente = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero = (EditText) findViewById(R.id.num);
        message = (EditText) findViewById(R.id.msgToSend);
        nombre = (EditText) findViewById(R.id.nbIteration);
        tempsAttente = (EditText) findViewById(R.id.timeSleep);
        envoyer = (Button) findViewById(R.id.buttonStart);
        envoyer.setOnClickListener(smsBomber);
    }
//.length()

    private OnClickListener smsBomber = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (message.getText().length() == 0 || numero.getText().length()==0 || nombre.getText().toString().length()==0 ||tempsAttente.getText().toString().length()==0)
            {
                Toast.makeText(MainActivity.this, "Certains champs ne sont pas remplis.\n Remplissez les et recommencer.", Toast.LENGTH_SHORT).show();
            } else {
                actual_message = message.getText().toString();
                actual_numero = numero.getText().toString();
                actual_nombre = Integer.parseInt(nombre.getText().toString());
                actual_tempsAttente = Integer.parseInt(tempsAttente.getText().toString());
                int i;
                for (i = 0; i < actual_nombre; i++) {
                    SmsManager.getDefault().sendTextMessage(actual_numero, null, actual_message, null, null);
                    Toast.makeText(MainActivity.this, "Envoi N°" + Integer.toString(i + 1) + " à " + actual_numero + " réussi", Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(1 + actual_tempsAttente);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                        ;

                    }
                }
            }


        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String url = "https://plus.google.com/u/0/b/103687612329172110284";
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
