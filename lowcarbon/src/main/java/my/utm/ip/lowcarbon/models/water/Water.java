package my.utm.ip.lowcarbon.models.water;

public class Water {
    /* private String waterId; */
    private int month;
    private int numday;
    private double profacta;
    private double usagem3;
    private double usagem3RM;
    private String userId;
    
    public Water() {}

    public Water(String userId, int month, int numday, double profacta, double usagem3, double usagem3RM) {
        this.userId = userId;
        this.month = month;
        this.numday = numday;
        this.profacta = profacta;
        this.usagem3 = usagem3;
        this.usagem3RM = usagem3RM;
    }
    
    public Water(WaterDAO dao){
        this.fromDAO(dao);
    }

    public void fromDAO(WaterDAO dao) {
        this.month = dao.getWater_month();
        this.numday = dao.getWater_numday();
        this.profacta = dao.getWater_profacta();
        this.usagem3 = dao.getWater_usagem3();
        this.usagem3RM = dao.getWater_usagem3RM();
        this.userId = dao.getUserId();
    }

    public WaterDAO toDAO(){
        WaterDAO dao = new WaterDAO();
        dao.setWater_month(this.month);
        dao.setWater_numday(this.numday);
        dao.setWater_profacta(this.profacta);
        dao.setWater_usagem3(this.usagem3);
        dao.setWater_usagem3RM(this.usagem3RM);
        dao.setUserId(userId);

        return dao;
    }


    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getNumday() {
        return numday;
    }
    public void setNumday(int numday) {
        this.numday = numday;
    }
    public double getProfacta() {
        return profacta;
    }
    public void setProfacta(double profacta) {
        this.profacta = profacta;
    }
    public double getUsagem3() {
        return usagem3;
    }
    public void setUsagem3(double usagem3) {
        this.usagem3 = usagem3;
    }
    public double getUsagem3RM() {
        return usagem3RM;
    }
    public void setUsagem3RM(double usagem3RM) {
        this.usagem3RM = usagem3RM;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
