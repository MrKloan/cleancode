package fr.esgi.cleancode.workers.activity.human;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.worker.Worker;

public class SleepActivity extends Activity implements HumanActivity {

	public SleepActivity(int start, int end) {
		super(start, end);
	}

	@Override
	public String proceed(Worker worker) {
		return "Human worker " + worker.getName() + " slept from " + start + " to " + end + ".";
	}
}
