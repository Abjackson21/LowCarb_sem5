package my.utm.ip.lowcarbon.models.water;

public class WaterDAO {
    private int water_month;
    private int water_numday;
    private double water_profacta;
    private double water_usagem3;
    private double water_usagem3RM;
    private String user_id;
   
    
    public WaterDAO() {
    }

    public WaterDAO(int water_month, int water_numday, double water_profacta, double water_usagem3,
            double water_usagem3RM, String userId) {
        this.water_month = water_month;
        this.water_numday = water_numday;
        this.water_profacta = water_profacta;
        this.water_usagem3 = water_usagem3;
        this.water_usagem3RM = water_usagem3RM;
        this.user_id = userId;
    }

    public int getWater_month() {
        return water_month;
    }

    public void setWater_month(int water_month) {
        this.water_month = water_month;
    }

    public int getWater_numday() {
        return water_numday;
    }

    public void setWater_numday(int water_numday) {
        this.water_numday = water_numday;
    }

    public double getWater_profacta() {
        return water_profacta;
    }

    public void setWater_profacta(double water_profacta) {
        this.water_profacta = water_profacta;
    }

    public double getWater_usagem3() {
        return water_usagem3;
    }

    public void setWater_usagem3(double water_usagem3) {
        this.water_usagem3 = water_usagem3;
    }

    public double getWater_usagem3RM() {
        return water_usagem3RM;
    }

    public void setWater_usagem3RM(double water_usagem3RM) {
        this.water_usagem3RM = water_usagem3RM;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    @Override
    public String toString() {
        return "WaterDOA [water_month=" + water_month + ", water_numday=" + water_numday + ", water_profacta="
                + water_profacta + ", water_usagem3=" + water_usagem3 + ", water_usagem3RM=" + water_usagem3RM + "]";
    }
    
}
