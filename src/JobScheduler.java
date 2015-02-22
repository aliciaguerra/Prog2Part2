import data_structures.*;

public class JobScheduler {

    // Use your OrderedArrayPriorityQueue<E> implementation here.
    private PriorityQueue<ServiceRequest> queue;
    private int maxJobs;

    public int getMaxJobs() {
        return maxJobs;
    }

    public JobScheduler(int maxJobs) {
        this.maxJobs = maxJobs;
        queue = new OrderedArrayPriorityQueue<ServiceRequest>(this.maxJobs);
    }

    // Insert a new job in the scheduler, returns false if insertion fails.
    public boolean insertJob(ServiceRequest req) {
        return queue.insert(req);
    }

    // Returns the next job of highest precedence based on the specifications
    // in the assignment, and removes it from the scheduler.
    public ServiceRequest nextJob() {
        return queue.remove();
    }

    // Returns the next job of highest precedence based on the specifications
    // in the assignment, but does NOT remove it. 
    public ServiceRequest peekJob() {
        return queue.peek();
    }

    // Returns true if more jobs remain in the scheduler, false if the scheduler
    // is empty
    public boolean hasMoreJobs() {
        return !queue.isEmpty();
    }

    // Returns true if the scheduler is full.
    public boolean schedulerFull() {
        // System.out.println("size: "+queue.size()+" / max: "+this.getMaxJobs());
        return this.getMaxJobs() == queue.size();
    }

    // Prints all jobs with the given priority
    public void printJobs(int priority) {
        for (ServiceRequest job : queue) {
            if (job.getPriority() == priority) {
                System.out.println(job);
            }
        }
    }

    // Prints all jobs
    public void printJobs() {
        printJobs(-1);
    }

    // Returns the total number of jobs waiting in the scheduler with the given
    // priority.
    public int numberWaiting(int priority) {
        if (priority == -1)
            return queue.size();
        else {
            //do some fancy work
            int count = 0;
            for (ServiceRequest job : queue) {
                if (job.getPriority() == priority) {
                    count++;
                }
            }
            return count;
        }
    }

    // Returns the total number of jobs waiting in the scheduler.
    public int numberWaiting() {
        return numberWaiting(-1);

    }
}