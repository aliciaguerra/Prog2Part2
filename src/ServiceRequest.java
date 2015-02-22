import java.util.Hashtable;
import java.util.Locale;

public class ServiceRequest implements Comparable<ServiceRequest> {
    public enum priorities {
        P1, P2, P3, P4, P5;
    }
    public static final String FACULTY = "faculty";
    public static final int P1 = 1;
    public static final int P2 = 2;
    public static final int P3 = 3;
    public static final int P4 = 4;
    public static final int P5 = 5;

    public static final String Categories = null;

    public static Hashtable<String, Integer> CATEGORIES;
    private int priority;
    private String client;
    private String category;
    private String description;

    public ServiceRequest(int priority, String client, String category, String description) {
        //must validate priority 1-5 and category fields
        if (priority < 0 || priority > 5)
            throw new IllegalArgumentException("Priority must be between 1-5");
        else if (!category.matches("(?i)classroom|network|server|lab|faculty|staff"))
            throw new IllegalArgumentException("category must be of form: classroom|network|server|lab|faculty|staff");

        this.priority = priority;
        this.client = client;
        this.category = category.toLowerCase(Locale.US);
        this.description = description;

        CATEGORIES = new Hashtable<String, Integer>();
        CATEGORIES.put("classroom", 1);
        CATEGORIES.put("network", 2);
        CATEGORIES.put("server", 3);
        CATEGORIES.put("lab", 4);
        CATEGORIES.put("faculty", 5);
        CATEGORIES.put("staff", 6);

    }

    @Override
    public int compareTo(ServiceRequest next) {
        int priority_diff = this.priority - next.priority;
        if (priority_diff != 0)
            return priority_diff;
        else {
            int category_diff = CATEGORIES.get(this.category) - CATEGORIES.get(next.category);
            return category_diff;
        }

    }

    public String getCategory() {
        return category;
    }

    public String getClient() {
        return client;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setCategory(String c) {
        this.category = c;
    }

    public void setClient(String c) {
        this.client = c;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public void setPriority(int n) {
        this.priority = n;
    }

    @Override
    public String toString() {
        return "ServiceRequest [priority=" + priority + ", client=" + client + ", category=" + category
                + ", description=" + description + "]";
    }

}