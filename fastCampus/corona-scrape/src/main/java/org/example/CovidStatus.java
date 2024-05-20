package org.example;

public class CovidStatus {
    private String region;
    private int total;
    private int domestic;
    private int abroad;

    public CovidStatus(String region, int total, int domestic, int abroad, int confirmed, int deaths, double rate) {
        this.region = region;
        this.total = total;
        this.domestic = domestic;
        this.abroad = abroad;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.rate = rate;
    }

    private int confirmed;
    private int deaths;
    private double rate;

    public CovidStatus() {
    }


    public void setAbroad(int abroad) {
        this.abroad = abroad;
    }

    public int getAbroad() {
        return abroad;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDomestic(int domestic) {
        this.domestic = domestic;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRegion() {
        return region;
    }

    public int getTotal() {
        return total;
    }

    public int getDomestic() {
        return domestic;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public double getRate() {
        return rate;
    }
}
