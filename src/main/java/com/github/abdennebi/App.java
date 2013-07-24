package com.github.abdennebi;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.*;
import org.apache.abdera.parser.Parser;

import java.io.InputStream;

public class App {

    public static void main(String[] args) {

        Abdera abdera = new Abdera();

        Parser parser = abdera.getParser();

        InputStream in = App.class.getResourceAsStream("/Book.xml");

        Document<Feed> doc = parser.parse(in, "Book.xml");

        Feed feed = doc.getRoot();
        // Get the feed title
        System.out.println("Feed Title: " + feed.getTitle());

        // Get the entry items...
        for (Entry entry : feed.getEntries()) {
            System.out.println("Title: " + entry.getTitle());
            System.out.println("Unique Identifier: " + entry.getId().toString());
            System.out.println("Updated Date: " + entry.getUpdated().toString());
            System.out.println("Published Date: " + entry.getPublished());
            System.out.println("Content: " + entry.getContent());

            // Get the links
            for (Link link : entry.getLinks()) {
                System.out.println("Link: " + link.getHref());
            }

            // Get the categories
            for (Category category : entry.getCategories()) {
                System.out.println("Category: " + category.getTerm());
            }
        }
    }
}