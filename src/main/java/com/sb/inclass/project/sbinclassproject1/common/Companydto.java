package com.sb.inclass.project.sbinclassproject1.common;

public class Companydto {

    private String companyName;
    private Integer ein;
    private Integer noOfEmployees;
    private Addressdto address;
    private String ticker;

    public Companydto() {

    }

    public Companydto(String companyName, Integer ein, Integer noOfEmployees, Addressdto address, String ticker) {
        this.companyName = companyName;
        this.ein = ein;
        this.noOfEmployees = noOfEmployees;
        this.address = address;
        this.ticker = ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Companydto setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Integer getEin() {
        return ein;
    }

    public Companydto setEin(Integer ein) {
        this.ein = ein;
        return this;
    }

    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    public Companydto setNoOfEmployees(Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
        return this;
    }

    public Addressdto getAddress() {
        return address;
    }

    public Companydto setAddress(Addressdto address) {
        this.address = address;
        return this;
    }

    public String getTicker() {
        return ticker;
    }

    public Companydto setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", ein=" + ein +
                ", noOfEmployees=" + noOfEmployees +
                ", address=" + address +
                ", ticker='" + ticker + '\'' +
                '}';
    }
}
