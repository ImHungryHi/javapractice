package code.haml;

import java.util.*;

public class NodeList extends ArrayList<Node> {
    public void fillExample() {
        Node html = new Node("html");

        Node head = new Node("head", html);
        Node pageTitle = new Node("title", head);
        Node meta = new Node("meta", head);
        Node script = new Node("script", head);
        Node css = new Node("style", head);

        Node body = new Node("body", html);
        Node bannerSection = new Node("header", body);
        Node mainTitle = new Node("h1", bannerSection);
        Node navList = new Node("ul", bannerSection);
        Node homeListItem = new Node("li", navList);
        Node homeAnchor = new Node("a", homeListItem);
        Node profileListItem = new Node("li", navList);
        Node profileAnchor = new Node("a", profileListItem);
        Node aboutListItem = new Node("li", navList);
        Node aboutAnchor = new Node("a", aboutListItem);

        Node mainContent = new Node("section", body);
        Node subTitle = new Node("h2", mainContent);
        // See end of method for addition of articles

        Node footer = new Node("footer", body);
        Node footerDiv = new Node(footer);
        Node infoList = new Node("ul", footerDiv);
        Node copyListItem = new Node("li", infoList);
        Node copyright = new Node("p", copyListItem);
        Node taxListItem = new Node("li", infoList);
        Node tax = new Node("p", taxListItem);
        Node phoneListItem = new Node("li", infoList);
        Node phone = new Node("p", phoneListItem);

        // One example of many possibilities...
        phone.addAttribute("content", "0412 34 56 78");
        phone.addAttribute("class", "split.like.so");
        phone.addAttribute("id", "noSplitting");

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

        for (int x = 0; x < 10; x++) {
            Node article = new Node("article", mainContent);
            Node articleTitle = new Node("h2", article);
            Node articleDescription = new Node("p", article);
            Node articleLink = new Node("a", article);

            add(article);
            add(articleTitle);
            add(articleDescription);
            add(articleLink);
        }
    }
}
