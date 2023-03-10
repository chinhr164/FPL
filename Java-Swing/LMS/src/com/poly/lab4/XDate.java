package com.poly.lab4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class XDate {

    private final DateTimeFormatter dateFormatter;

    public XDate(DateTimeFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    
    public boolean isValid(String dateStr) {
        try {
            LocalDate.parse(dateStr, this.dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
