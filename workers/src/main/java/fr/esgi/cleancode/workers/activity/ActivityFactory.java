package fr.esgi.cleancode.workers.activity;

import fr.esgi.cleancode.workers.activity.human.EatActivity;
import fr.esgi.cleancode.workers.activity.human.SleepActivity;
import fr.esgi.cleancode.workers.activity.robot.StandbyActivity;

/**
 * Beuurk...
 */
public class ActivityFactory {

	public static Activity getActivity(String name, int start, int end) {
		name = name.toLowerCase();

		switch(name) {
			case "work":
				return new WorkActivity(start, end);
			case "other":
				return new OtherActivity(start, end);
			case "standby":
				return new StandbyActivity(start, end);
			case "eat":
				return new EatActivity(start, end);
			case "sleep":
				return new SleepActivity(start, end);
			default:
				throw new IllegalArgumentException("Activity " + name + " does not exists");
		}
	}
}
