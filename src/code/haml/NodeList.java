package code.haml;

import java.util.*;

public class NodeList {
    private ArrayList<Node> nodes;

    public NodeList() {
        nodes = new ArrayList<>();
    }

    public void fillExample() {
        Node html = new Node();

        Node head = new Node(html);
        Node pageTitle = new Node(head);
        Node meta = new Node(head);
        Node script = new Node(head);
        Node css = new Node(head);

        Node body = new Node(html);
        Node bannerSection = new Node(body);
        Node mainTitle = new Node(bannerSection);
        Node navList = new Node(bannerSection);
        Node homeListItem = new Node(navList);
        Node homeAnchor = new Node(homeListItem);
        Node profileListItem = new Node(navList);
        Node profileAnchor = new Node(profileListItem);
        Node aboutListItem = new Node(navList);
        Node aboutAnchor = new Node(aboutListItem);

        Node mainContent = new Node(body);
        Node subTitle = new Node(mainContent);
        // See end of method for addition of articles

        Node footer = new Node(body);
        Node infoList = new Node(footer);
        Node copyListItem = new Node(infoList);
        Node copyright = new Node(copyListItem);
        Node taxListItem = new Node(infoList);
        Node tax = new Node(taxListItem);
        Node phoneListItem = new Node(infoList);
        Node phone = new Node(phoneListItem);

        // One example of many possibilities...
        phone.addAttribute("content", "0412 34 56 78");
        phone.addAttribute("class", "split.like.so");
        phone.addAttribute("id", "noSplitting");

        nodes = new ArrayList<Node>() {{
            add(html);
            add(head);
            add(body);
            add(pageTitle);
            add(meta);
            add(script);
            add(css);
            add(mainTitle);
            add(navList);
            add(homeListItem);
            add(homeAnchor);
            add(profileListItem);
            add(profileAnchor);
            add(aboutListItem);
            add(aboutAnchor);
            add(mainContent);
            add(subTitle);
            add(footer);
            add(infoList);
            add(copyListItem);
            add(copyright);
            add(taxListItem);
            add(tax);
            add(phoneListItem);
            add(phone);
        }};

        for (int x = 0; x < 10; x++) {
            Node article = new Node(mainContent);
            Node articleTitle = new Node(article);
            Node articleDescription = new Node(article);
            Node articleLink = new Node(article);

            nodes.add(article);
            nodes.add(articleTitle);
            nodes.add(articleDescription);
            nodes.add(articleLink);
        }
    }
}
