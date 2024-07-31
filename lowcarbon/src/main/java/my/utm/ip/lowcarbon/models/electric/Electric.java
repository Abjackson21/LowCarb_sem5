package my.utm.ip.lowcarbon.models.electric;

public class Electric {
    private int electric_month;
    private int electric_numday;
    private double electric_profacta;
    private double electric_usagekWh;
    private double electric_usagekWhRM;
    private String user_id;
    public Electric() {
    }
    public Electric(int electric_month, int electric_numday, double electric_profacta, double electric_usagekWh,
            double electric_usagekWhRM, String user_id) {
        this.electric_month = electric_month;
        this.electric_numday = electric_numday;
        this.electric_profacta = electric_profacta;
        this.electric_usagekWh = electric_usagekWh;
        this.electric_usagekWhRM = electric_usagekWhRM;
        this.user_id = user_id;
    }
    public int getElectric_month() {
        return electric_month;
    }
    public void setElectric_month(int electric_month) {
        this.electric_month = electric_month;
    }
    public int getElectric_numday() {
        return electric_numday;
    }
    public void setElectric_numday(int electric_numday) {
        this.electric_numday = electric_numday;
    }
    public double getElectric_profacta() {
        return electric_profacta;
    }
    public void setElectric_profacta(double electric_profacta) {
        this.electric_profacta = electric_profacta;
    }
    public double getElectric_usagekWh() {
        return electric_usagekWh;
    }
    public void setElectric_usagekWh(double electric_usagekWh) {
        this.electric_usagekWh = electric_usagekWh;
    }
    public double getElectric_usagekWhRM() {
        return electric_usagekWhRM;
    }
    public void setElectric_usagekWhRM(double electric_usagekWhRM) {
        this.electric_usagekWhRM = electric_usagekWhRM;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    
}
