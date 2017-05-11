package com.apress.springrecipes.court.web.view;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.apress.springrecipes.court.domain.Reservation;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReservationSummary extends AbstractPdfView {

    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        List<Reservation> reservations =
                (List<Reservation>) model.get("reservations");

        Table table = new Table(5);

        addTableHeader(table);
        for (Reservation reservation : reservations) {
            addContent(table, reservation);
        }
        document.add(table);
    }

    private void addContent(Table table, Reservation reservation) throws BadElementException {
        table.addCell(reservation.getCourtName());
        table.addCell(reservation.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        table.addCell(Integer.toString(reservation.getHour()));
        table.addCell(reservation.getPlayer().getName());
        table.addCell(reservation.getPlayer().getPhone());
    }

    private void addTableHeader(Table table) throws BadElementException {
        table.addCell("Court Name");
        table.addCell("Date");
        table.addCell("Hour");
        table.addCell("Player Name");
        table.addCell("Player Phone");
    }
}
