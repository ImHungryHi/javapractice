package code.haml;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

public class Node extends HashMap<String, String> {
    private Node parent;
    private NodeList children = new NodeList();   // added for querying ease
    //private HashMap<String, String> attributes;

    public Node(String tagName) {
        super();
        put("tagName", tagName);
        //put("address", this.toString());
    }

    // Only divs are allowed here, and divs aren't root elements...
    public Node(Node parent) {
        super();
        put("tagName", "div");
        //put("address", this.toString());
        setParent(parent);
    }

    public Node(String tagName, Node parent) {
        //this.attributes = new HashMap<>();
        super();
        put("tagName", tagName);
        //put("address", this.toString());
        setParent(parent);
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
        ArrayList<String> result = new ArrayList<>();

        for (String key : keySet()) {
            result.add(key);
        }

        return result;
    }

    public void addChild(Node node) {
        if (node.equals(this)) {
            throw new InvalidParameterException("A node can't be its own child, dingus!");
        }

        Node nodeParent = node.getParent();

        if (nodeParent == null || !nodeParent.equals(this)) {
            node.setParent(this);
        }

        children.add(node);
    }

    public void setParent(Node node) {
        if (node.equals(this)) {
            throw new InvalidParameterException("Can't add a node onto itself as parent.");
        }

        this.parent = node;
        this.parent.addChild(this);
    }

    public int getLevel() {
        if (parent == null) {
            return 0;
        }

        return parent.getLevel() + 1;
    }

    public Node getParent() {
        return this.parent;
    }

    public NodeList getChildren() {
        return this.children;
    }

    public String getContent() { return getValue("content"); }
}
