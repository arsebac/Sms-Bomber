package arsebac.smsbomber;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Hasaghi on 28/02/2017.
 */

public class View {

	private final Activity activity;
	private Button envoyer = null;
	private EditText numero = null;
	private EditText message = null;
	private EditText nombre = null;
	private EditText tempsAttente = null;

	public View(Activity activity) {
		this.activity= activity;
		numero = (EditText) activity.findViewById(R.id.num);
		message = (EditText) activity.findViewById(R.id.msgToSend);
		nombre = (EditText) activity.findViewById(R.id.nbIteration);
		tempsAttente = (EditText) activity.findViewById(R.id.timeSleep);
		envoyer = (Button) activity.findViewById(R.id.buttonStart);

	}
	public void showError(){
		Toast.makeText(activity, "Certains champs ne sont pas remplis.\n Remplissez les et recommencer.", Toast.LENGTH_SHORT).show();

	}

	public String getMsg() {
		return message.getText().toString();
	}

	public String getPhone() {
		return numero.getText().toString();
	}

	public int getIterations() {
		return Integer.parseInt(nombre.getText().toString());
	}

	public int getWait() {
		return Integer.parseInt(tempsAttente.getText().toString());
	}

	public void setStartButton(android.view.View.OnClickListener start) {
		envoyer.setOnClickListener(start);
	}
}
