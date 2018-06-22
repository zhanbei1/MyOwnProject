/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author 展贝
 */
public class salary {
    private String id;//员工编号
    private String name;//员工姓名
    private double baseSalary;//基本工资
    private int overTime;//加班时间，已小时为计量单位
    private double subsidies;//补贴，已元为计量单位，加班时间*加班提成
    private int leave;//请假时间，已小时为单位
    private double reduction;//请假扣除的工资，请假时间*请假期间工资
    private double tax;//当达到一定工资之后自动交税
    private double TotalWages;//最后的总工资，前面的几项相加可得

    public salary() {
    }

    public salary(String id, String name, double baseSalary, int overTime, double subsidies, int leave, double reduction, double tax, double TotalWages) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.overTime = overTime;
        this.subsidies = subsidies;
        this.leave = leave;
        this.reduction = reduction;
        this.tax = tax;
        this.TotalWages = TotalWages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public double getSubsidies() {
        return subsidies;
    }

    public void setSubsidies(double subsidies) {
        this.subsidies = subsidies;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalWages() {
        return TotalWages;
    }

    public void setTotalWages(double TotalWages) {
        this.TotalWages = TotalWages;
    }
    
}
