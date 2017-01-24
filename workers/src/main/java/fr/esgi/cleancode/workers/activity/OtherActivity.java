package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.activity.human.HumanActivity;
import fr.esgi.cleancode.workers.activity.robot.RobotActivity;
import fr.esgi.cleancode.workers.worker.Worker;

public class OtherActivity extends Activity implements HumanActivity, RobotActivity {

	public OtherActivity(int start, int end) {
		super(start, end);
	}

	@Override
	public String proceed(Worker worker) {
		return "Worker " + worker.getName() + " did stuff from " + start + " to " + end + ".";
	}
}
