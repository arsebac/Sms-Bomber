package arsebac.smsbomber;

import android.app.Activity;
import android.widget.Button;

/**
 * Created by Hasaghi on 28/02/2017.
 */

public class Controller {
	private final Activity activity;
	private Bomber bomber;
	private View view;

	public Controller(Activity activity) {
		this.activity = activity;
		bomber = new Bomber();
		view = new View(activity);
	}
	public void init(){
		android.view.View.OnClickListener start = new android.view.View.OnClickListener() {
			@Override
			public void onClick(android.view.View v) {
				try {
					bomber.config( view.getMsg(),view.getPhone(),view.getIterations(),view.getWait());
					bomber.run(activity);
				}catch (IllegalStateException e){
					view.showError();
				}
			}
		};
		view.setStartButton(start);
	}
}
