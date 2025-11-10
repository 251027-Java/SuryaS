package org.example;

import java.util.Date;

public class Expense {
    private int id;
    private Date date;
    private double value;
    private String merchant;

    public Expense(int id, Date date, double value, String merchant){
        this.id = id;
        this.date = date;
        this.value = value;
        this.merchant = merchant;
    }

    public double getValue(){
        return this.value;
    }

    public String getMerchant(){
        return this.merchant;
    }

    public String toString(){
        return "Expense [id="+this.id + "," + "date="+this.date + "," + "value="+this.value+ "," + "merchant="+this.merchant +"]";
    }


    public String toCSV(){
        return this.id + ", " + this.date + ", "+this.value+ ", " +this.merchant;
    }

    public String toJSON(){
        return "{\"id\": "+this.id+" , \"date\": \""+this.date+"\", \"value\": "+this.value+" , \"merchant\": "+"\""+this.merchant+"\"}";
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
}
