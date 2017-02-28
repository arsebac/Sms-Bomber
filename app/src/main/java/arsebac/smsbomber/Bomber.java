package arsebac.smsbomber;

import android.app.Activity;
import android.telephony.SmsManager;
import android.view.*;
import android.widget.Toast;

/**
 * Created by Hasaghi on 28/02/2017.
 */

public class Bomber {
	private String message = "";
	private String phoneNumber = "";
	private int iterations = 0;
	private int waitTime = 0;

	public Bomber() {
	}
	public void run(Activity activity){
				int i;
				for (i = 0; i < iterations; i++) {
					SmsManager.getDefault().sendTextMessage(phoneNumber, null, message, null, null);
					Toast.makeText(activity, "Envoi N°" + Integer.toString(i + 1) + " à " + phoneNumber + " réussi", Toast.LENGTH_SHORT).show();
					try {
						Thread.sleep(1 + waitTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

	public void config(String msg, String phone, int iterations, int wait) throws IllegalStateException{
		message = msg;
		phoneNumber = phone;
		this.iterations = iterations;
		waitTime = wait;
		if (message.length() == 0 || phoneNumber.length()==0 || iterations==0 ||waitTime ==0)
		{
			throw new IllegalStateException();
		}

	}
}
