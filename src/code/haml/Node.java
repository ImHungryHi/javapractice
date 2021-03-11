package code.haml;

import java.util.HashMap;

public class Node {
    private Node parent;
    private HashMap<String, String> attributes;

    public Node() {
        attributes = new HashMap<>();
    }

    public Node(Node parent) {
        this.parent = parent;
        this.attributes = new HashMap<>();
    }

    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getValue(String key) {
        if (attributes.containsKey(key)) {
            return attributes.get(key);
        }

        return null;
    }

    public String getContent() {
        return getValue("content");
    }
}
