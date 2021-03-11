package code.haml;

import java.util.ArrayList;
import java.util.HashMap;

public class Node extends HashMap<String, String> {
    private Node parent;
    //private HashMap<String, String> attributes;

    public Node() {
        super();
    }

    public Node(Node parent) {
        //this.attributes = new HashMap<>();
        super();
        this.parent = parent;
    }

    public void addAttribute(String key, String value) {
        put(key, value);
    }

    public String getValue(String key) {
        if (this.containsKey(key)) {
            return this.get(key);
        }

        return null;
    }

    public ArrayList<String> getAttributeNames() {
        ArrayList<String> result = new ArrayList<String>();

        for (String key : keySet()) {
            result.add(key);
        }

        return result;
    }

    public String getContent() {
        return getValue("content");
    }
}
