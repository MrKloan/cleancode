package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.worker.Worker;
import fr.esgi.cleancode.workers.activity.human.HumanActivity;
import fr.esgi.cleancode.workers.activity.robot.RobotActivity;

public class WorkActivity extends Activity implements HumanActivity, RobotActivity {

	public WorkActivity(int start, int end) {
		super(start, end);
	}

	@Override
	public String proceed(Worker worker) {
		return "Worker " + worker.getName() + " worked from " + start + " to " + end + ".";
	}
}
