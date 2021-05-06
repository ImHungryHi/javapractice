package jdbc.jordiquotes.model;

public class Quote {
    private int id;
    private String author;
    private String quote;
    private int likes;
    private int dislikes;

    public Quote(int id, String author, String quote, int likes, int dislikes) {
        this.id = id;
        this.author = author;
        this.quote = quote;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }
}
