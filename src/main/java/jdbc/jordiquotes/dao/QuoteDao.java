package jdbc.jordiquotes.dao;
import jdbc.jordiquotes.model.Quote;

public interface QuoteDao {
    Quote getRandomQuote();
    void likeQuote(Quote quote);
    void dislikeQuote(Quote quote);
}
