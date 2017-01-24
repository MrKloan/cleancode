package fr.esgi.cleancode.workers.worker;

import fr.esgi.cleancode.workers.activity.Activity;
import fr.esgi.cleancode.workers.logger.Logger;
import fr.esgi.cleancode.workers.task.Task;

import java.lang.reflect.ParameterizedType;

public abstract class Worker<T> {

	private final Class<T> type;
	private final String name;
	private Task task;

	@SuppressWarnings("unchecked")
	public Worker(String name) {
		this.type = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.name = name;
	}

	public final String work(Activity activity, Logger logger) {
		if(task == null)
			throw new IllegalStateException("The worker must be assigned to a task in order to perform any kind of activity");
		if(!type.isInstance(activity))
			throw new IllegalArgumentException("This kind of activity cannot be performed by a human");
		if(logger == null)
			throw new IllegalArgumentException("A logger must be provided in order to create a work log record");

		logger.log(this, this.currentTask(), activity);
		return activity.proceed(this);
	}

	public final void assign(Task task) {
		this.task = task;
	}

	public String getName() {
		return name;
	}

	public Task currentTask() {
		return task;
	}
}
