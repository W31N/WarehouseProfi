package com.example.warehouseprofi.Dtos;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemsDto {
    private Long id;
    private String item_name;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date date_taken;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date return_date;

    protected ItemsDto() {}

    public ItemsDto(Long id, String item_name, Date date_taken, Date return_date) {
        this.id = id;
        this.item_name = item_name;
        this.date_taken = date_taken;
        this.return_date = return_date;
    }

    public ItemsDto(Long id, String item_name, String dateTaken, String returnDate) {
        this.id = id;
        this.item_name = item_name;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.date_taken = dateFormat.parse(dateTaken);
            this.return_date = dateFormat.parse(returnDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Date getDate_taken() {
        return date_taken;
    }

    public void setDate_taken(Date date_taken) {
        this.date_taken = date_taken;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        String dateTakenStr = (date_taken != null) ? dateFormat.format(date_taken) : "N/A";
        String returnDateStr = (return_date != null) ? dateFormat.format(return_date) : "N/A";

        return "ItemsDto{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", date_taken=" + dateTakenStr +
                ", return_date=" + returnDateStr +
                '}';
    }
}
