package my.utm.ip.lowcarbon.models.calculate;

public class Calculate {
    private double total_emission;
    private double water_emission;
    private double electric_emission;
    private double recycle_emission;
    public Calculate() {
    }
    
    public Calculate(double total_emission, double water_emission, double electric_emission, double recycle_emission) {
        this.total_emission = total_emission;
        this.water_emission = water_emission;
        this.electric_emission = electric_emission;
        this.recycle_emission = recycle_emission;
    }

    public double getTotal_emission() {
        return total_emission;
    }
    public void setTotal_emission(double total_emission) {
        this.total_emission = total_emission;
    }
    public double getWater_emission() {
        return water_emission;
    }
    public void setWater_emission(double water_emission) {
        this.water_emission = water_emission;
    }
    public double getElectric_emission() {
        return electric_emission;
    }
    public void setElectric_emission(double electric_emission) {
        this.electric_emission = electric_emission;
    }
    public double getRecycle_emission() {
        return recycle_emission;
    }
    public void setRecycle_emission(double recycle_emission) {
        this.recycle_emission = recycle_emission;
    }

    
}
