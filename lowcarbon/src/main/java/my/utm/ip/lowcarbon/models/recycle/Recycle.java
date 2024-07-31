package my.utm.ip.lowcarbon.models.recycle;

public class Recycle {
    private int recycle_month;
    private double collectedKG;
    private double collectedRM;
    private String user_id;
    public Recycle() {
    }
    public Recycle(int recycle_month, double collectedKG, double collectedRM, String user_id) {
        this.recycle_month = recycle_month;
        this.collectedKG = collectedKG;
        this.collectedRM = collectedRM;
        this.user_id = user_id;
    }
    public int getRecycle_month() {
        return recycle_month;
    }
    public void setRecycle_month(int recycle_month) {
        this.recycle_month = recycle_month;
    }
    public double getCollectedKG() {
        return collectedKG;
    }
    public void setCollectedKG(double collectedKG) {
        this.collectedKG = collectedKG;
    }
    public double getCollectedRM() {
        return collectedRM;
    }
    public void setCollectedRM(double collectedRM) {
        this.collectedRM = collectedRM;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
}
