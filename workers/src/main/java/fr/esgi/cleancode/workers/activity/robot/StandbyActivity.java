package fr.esgi.cleancode.workers.activity.robot;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.worker.Worker;

public class StandbyActivity extends Activity implements RobotActivity {

	public StandbyActivity(int start, int end) {
		super(start, end);
	}

	@Override
	public String proceed(Worker worker) {
		return "Robot worker " + worker.getName() + " was in standby from " + start + " to " + end + ".";
	}
}
