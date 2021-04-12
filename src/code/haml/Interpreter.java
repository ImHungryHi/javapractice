package code.haml;

import java.util.ArrayList;
import java.io.*;

public class Interpreter {
    private final ArrayList<String> STOPWORDS = new ArrayList<>() {{
        add("stop");
        add("exit");
        add("bye");
    }};
    private ArrayList<String> lines = new ArrayList<>();
    private NodeList nodes = new NodeList();
    private String hamlContent = "";

    public void readFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!STOPWORDS.contains(input)) {
            lines.add(input);

            // Bring on the next iteration, or not...
            input = reader.readLine();

            // This line's sole purpose is to save memory on while loop conditional statements
            input = input.toLowerCase();
        }
    }

    public void readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String input = reader.readLine();

        while(reader != null) {
            lines.add(input);
            input = reader.readLine();
        }
    }

    public void parse() {
        String line = "",
                tagName = "",
                classNames = "",
                idName = "",
                content = "";
        int x = 0,
                level = 0,
                idxClass = -1,
                idxId = -1,
                idxContent = -1,
                idxAttributeStart = -1,
                idxAttributeEnd = -1,
                idxNextElement = -1;

        for (x = 0; x < lines.size(); x++) {
            line = lines.get(x);

            // Where do we insert this?
            while (line.charAt(1) == ' ' || line.charAt(0) == '\t') {
                level++;

                if (line.charAt(1) == ' ') {
                    line = line.substring(2);
                }
                else if (line.charAt(0) == '\t') {
                    line = line.substring(1);
                }
            }

            // Trim the final left space, if any, to clean up the line
            if (line.charAt(0) == ' ') {
                line = line.substring(1);
            }

            // Where is what?
            idxClass = line.indexOf(".");
            idxId = line.indexOf("#");
            idxAttributeEnd = line.indexOf("{");
            idxAttributeEnd = line.indexOf("}");
            idxContent = line.indexOf("=", Math.max(0, idxAttributeEnd));

            if (idxContent < 0) {
                idxContent = line.indexOf(" ", Math.max(0, idxAttributeEnd));
            }

            // What do we insert?
            if (line.charAt(0) == '%') {
                if (idxId > 0) {
                    idxNextElement = idxId;
                }
                if (idxClass > 0 && idxClass < idxNextElement) {
                    idxNextElement = idxClass;
                }
                if (idxAttributeEnd > 0 && idxAttributeEnd < idxNextElement) {
                    idxNextElement = idxAttributeEnd;
                }
                if (idxContent > 0 && idxContent < idxNextElement) {
                    idxNextElement = idxContent;
                }

                if (idxNextElement < 0) {
                    tagName = line.substring(1);
                }
                else {
                    tagName = line.substring(1, idxNextElement);
                    line = line.substring(idxNextElement);
                }
            }
            else {
                tagName = "div";
            }
            // Here ends the tagname search, on to the parsing
        }
    }

    public void export(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(hamlContent);
        writer.close();
    }
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
 - Tag body follows a tag with spaces (content, not tag "body" specifically)
 - Backslases \ can escape haml objects into pure text (eg \= @title => = @title)
 - set attributes in accolades, attribute names start with a colon, in general (eg %html{:xmlns => "http://www.w3.org/1999/xhtml", "xml:lang" => "en", :lang => "en"} )
 - an alternative way of writing attributes is using parentheses (eg %html(xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en") )
 - directly close off a tag by ending with a forward slash (eg %br/ => <br />)
 - additionally, when starting a line with a forward slash, it turns into a comment (eg / yo, sup => <!-- yo, sup -->)
    -> also, a line with only a forward slash creates a block comment until the indent turns back to the current level (eg / on indent level 2,
       lines on indent levels 3 and up will be commented until a new line is started on indent level 2)
 - haml-only comments with -# (java-only, in our case)
 - delete whitespace (newline) before and after current line with "<" or ">"
 - &= will filter out html entities (& turns into &amp; etc)

 Examples:
 %div#wrapperDiv
  .contentBlock#automaticDiv
    %h2(id="subtitle" class="subtitle") How to make up examples
    -# Please don't use this randomness, but do allow it. BeeTeeDubs: this is a comment, you like it?
    %p.bodyText#pHeader This is a prelude to what follows in the content
    %p{:id => "pIntro", :class => "bodyText"} This is my content, what do you think?
    %p(id="pBody" class="bodyText") My second body.
      %br/ I'll allow this kind of parsing, but not as a child node!
      %span Span and BR tags will be read as text into a paragraph, not a node object.
      <span>Although I'd prefer if you would use <br /> html format, even in haml</span>
      /this (is the same as)
      <!-- this -->
      /
        this
        is
        a
        comment
        block (or block comment, whatever tickles your fancy)
      -# although this won't be shown in html
    %p#pFooter.bodyText
      For completeness' sake, let's conclude this block of text and move on.
      -# Don't forget, we can break out into a new line and still be contained inside the p-block pFooter.
      \%span.insideClass#emphSpan Look ma, no hands! And just so we're on the same line: ><
      <span>I'm NOT clear text, unlike the above one. I'm my own span!</span>
      &= Ya'll want tea & biscuits?
      -# Becomes Ya&apos;ll want tea &amp; biscuits?
 */
