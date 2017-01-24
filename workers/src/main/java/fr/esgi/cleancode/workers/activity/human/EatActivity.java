package fr.esgi.cleancode.workers.activity.human;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.worker.Worker;

public class EatActivity extends Activity implements HumanActivity {

	public EatActivity(int start, int end) {
		super(start, end);
	}

	@Override
	public String proceed(Worker worker) {
		return "Human worker " + worker.getName() + " ate from " + start + " to " + end + ".";
	}
}
