package com.apress.springrecipes.court.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PeriodicReservation {

    private String courtName;

    // Accept the time in the SO Date Format {@code yyyy-MM-dd}
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fromDate;

    // Accept the time in the SO Date Format {@code yyyy-MM-dd}
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate toDate;
    private int period;
    private int hour;
    private Player player;

    public String getCourtName() {
        return courtName;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public int getHour() {
        return hour;
    }

    public int getPeriod() {
        return period;
    }

    public Player getPlayer() {
        return player;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }
}
