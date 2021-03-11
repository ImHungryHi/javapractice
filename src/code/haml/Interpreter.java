package code.haml;

import java.util.ArrayList;

public class Interpreter {
    private ArrayList<String> lines = new ArrayList<>();
    private String hamlContent = "";
}

/*
 Rules of engagement:
 - Each tag has its own line.
 - Indentation by 2 spaces or 1 tab makes a tag a child of the tag above, 1 indentation back
 - A tag starts with a percent sign %, followed by the tagname eq %p, %h1, %section
    -> no %? the tag is automatically a div
 - Classes start with a period . and follow a tagname (or are the beginning in case of a defaulted div) or an id
 - Ids start with a hashtag # and follow a tagname (or are the beginning in case of a defaulted div) or a class
 - HTML tags are passed through unmodified (in case you encounter a HTML statement, don't default to div)
 - Tag body follows a tag with spaces
 */