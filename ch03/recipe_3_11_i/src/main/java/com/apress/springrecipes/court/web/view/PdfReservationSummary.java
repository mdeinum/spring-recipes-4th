package com.apress.springrecipes.court.web.view;

import com.apress.springrecipes.court.domain.Reservation;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

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
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        table.addCell(reservation.getCourtName());
        table.addCell(dateFormat.format(reservation.getDate()));
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
