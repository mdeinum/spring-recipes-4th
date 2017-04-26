package com.apress.springrecipes.court.feeds;

import com.rometools.rome.feed.atom.Content;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class AtomFeedView extends AbstractAtomFeedView {

    @Override
    protected void buildFeedMetadata(Map model, Feed feed, HttpServletRequest request) {
        feed.setId("tag:tennis.org");
        feed.setTitle("Grand Slam Tournaments");

        List<TournamentContent> tournamentList = (List<TournamentContent>) model.get("feedContent");

        feed.setUpdated(tournamentList.stream().map(TournamentContent::getPublicationDate).sorted().findFirst().orElse(null));

    }

    @Override
    protected List buildFeedEntries(Map model, HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        List<TournamentContent> tournamentList = (List<TournamentContent>) model.get("feedContent");
        return tournamentList.stream().map(this::toEntry).collect(Collectors.toList());
    }

    private Entry toEntry(TournamentContent tournament) {
        Entry entry = new Entry();
        String date = String.format("%1$tY-%1$tm-%1$td", tournament.getPublicationDate());
        entry.setId(String.format("tag:tennis.org,%s:%d", date, tournament.getId()));
        entry.setTitle(String.format("%s - Posted by %s", tournament.getName(), tournament.getAuthor()));
        entry.setUpdated(tournament.getPublicationDate());

        Content summary = new Content();
        summary.setValue(String.format("%s - %s", tournament.getName(), tournament.getLink()));
        entry.setSummary(summary);
        return entry;
    }
}
