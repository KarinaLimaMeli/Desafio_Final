package br.com.meli.desafio_final.model.entity;
import java.math.BigInteger;
import java.util.Date;
public class Discount {
    private Date dueDate;
    private BigInteger batchNumber;
    private double unitPrice;

    public double getUnitPriceDiscount() {
        return unitPriceDiscount;
    }

    public void setUnitPriceDiscount(double unitPriceDiscount) {
        this.unitPriceDiscount = unitPriceDiscount;
    }

    private double unitPriceDiscount;

    public Discount(Object dueDate, Object batchNumber, Object unitPrice) {
        this.batchNumber = (BigInteger) batchNumber;
        this.dueDate = (Date) dueDate;
        this.unitPrice = (double) unitPrice;
        this.unitPriceDiscount = (double) unitPriceDiscount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getBatchNumber() {
        return batchNumber;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
