package ar.edu.unlp.info.oo1.ej10_jobScheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler {
    protected List<JobDescription> jobs;

    protected JobScheduler () {
        this.jobs = new ArrayList<>();
    }

    protected void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    protected void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    protected List<JobDescription> getJobs(){
        return jobs;
    }

    protected abstract JobDescription next();

}
