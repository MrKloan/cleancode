package fr.esgi.cleancode.workers;

import fr.esgi.cleancode.workers.activity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class WorkerTest {
	@Parameterized.Parameter(0)
	public String name;
	@Parameterized.Parameter(1)
	public Activity activity;
	@Parameterized.Parameter(2)
	public int start;
	@Parameterized.Parameter(3)
	public int end;
	@Parameterized.Parameter(4)
	public String date;

	@Parameterized.Parameters
	public static Collection parameters() {
		Object[][] parameters = new Object[][] {
			{"Peter", new WorkActivity(), 9, 12, null},
			{"Peter", new EatActivity(), 12, 13, null},
			{"Peter", new WorkActivity(), 13, 17, null},
			{"Peter", new OtherActivity(), 17, 22, null},
			{"Peter", new SleepActivity(), 22, 8, null},
			{"Paul", new WorkActivity(), 10, 16, "2016-12-24"}
		};

		return Arrays.asList(parameters);
	}

	@Test
	public void test() {
		Worker worker = new Worker(name);
		worker.work(activity, start, end);
	}
}