package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Inheritance {
    /*
     * -----------------------------------------------------------------------------------------
     * ---------------------------------- ABSTRACT INHERITANCE ---------------------------------
     * -----------------------------------------------------------------------------------------
     */
    /*
     * -- Implementation of an abstract method and setting a parameter in the parent's class --
     */
    public static abstract class Money {
        private double amount;

        public Money(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return this.amount;
        }

        public abstract String getCurrencyName();
    }

    public static class USD extends Money {
        public USD(double amount) {
            // Interesting part is this here, this will set the amount property of the parent class to the passed parameter's value
            super(amount);
        }

        public String getCurrencyName() {
            return "USD";
        }
    }

    public static class Ruble extends Money {
        public Ruble(double amount) {
            super(amount);
        }

        public String getCurrencyName() {
            return "RUB";
        }
    }

    public static class Euro extends Money {
        public Euro(double amount) {
            super(amount);
        }

        public String getCurrencyName() {
            return "EUR";
        }
    }

    // imagine our main program starting here, if you will
    public static class InfoManagement {
        public InfoManagement(String forMoneyClasses) {
            USD usd = new USD(100);
            Ruble ruble = new Ruble(10);
            Euro euro = new Euro(200);

            System.out.println(usd.getCurrencyName() + ": " + usd.getAmount());
            System.out.println(ruble.getCurrencyName() + ": " + ruble.getAmount());
            System.out.println(euro.getCurrencyName() + ": " + euro.getAmount());
        }

        public InfoManagement(int forMovieFactory) {
            Movie soap = MovieFactory.getMovie("soapOpera");
            Movie cartoon = MovieFactory.getMovie("cartoon");
            Movie thriller = MovieFactory.getMovie("thriller");
            Movie nullMovie = MovieFactory.getMovie("invalidInput");

            if (soap instanceof SoapOpera) {
                // Do something with the soap object eg:
                SoapOpera.printStaticItem();    // static method
                SoapOpera soapera = (SoapOpera)soap;
                soapera.printItem();
            }
        }
    }

    static class MovieFactory {
        static Movie getMovie(String key) {
            Movie movie = null;

            // Create a SoapOpera object for the key "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            else if (key.equals("cartoon")) {
                movie = new Cartoon();
            }
            else if (key.equals("thriller")) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {}
    static class SoapOpera extends Movie {
        public void printItem() {
            System.out.println("I'm a boring soap opera. I prefer space opera, dude!");
        }
        public static void printStaticItem() {
            System.out.println("I'm a static soap opera.");
        }
    }
    static class Cartoon extends Movie {}
    static class Thriller extends Movie {}

    /*
     * -- Some more super (!) parent manipulation code --
     */
    public static class BigAnimal {
        protected String getSize() {
            return "like a dinosaur";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "like a cat";
        }
    }

    public static class Goose extends SmallAnimal {
        public String getSize() {
            return "A goose is small, " + super.getSize();
        }
    }

    public static class Dragon extends BigAnimal {
        public String getSize() {
            return "A dragon is big, " + super.getSize();
        }
    }

    /*
     * -- Some more super (!) parent manipulation code --
     */
    public static class InfoManagementBook {
        public InfoManagementBook(String forMoneyClasses) {
            USD usd = new USD(100);
            Ruble ruble = new Ruble(10);
            Euro euro = new Euro(200);

            System.out.println(usd.getCurrencyName() + ": " + usd.getAmount());
            System.out.println(ruble.getCurrencyName() + ": " + ruble.getAmount());
            System.out.println(euro.getCurrencyName() + ": " + euro.getAmount());
        }
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();
        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";

            if (this instanceof MarkTwainBook) output = markTwainOutput;
            else if (this instanceof AgathaChristieBook) output = agathaChristieOutput;

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {
        private String title;

        public MarkTwainBook(String title) {
            super("Mark Twain");
            this.title = title;
        }

        public MarkTwainBook getBook() {
            return this;
        }

        public String getTitle() {
            return this.title;
        }
    }

    public static class AgathaChristieBook extends Book {
        private String title;

        public AgathaChristieBook(String title) {
            super("Agatha Christie");
            this.title = title;
        }

        public AgathaChristieBook getBook() {
            return this;
        }

        public String getTitle() {
            return this.title;
        }
    }

    /*
     * -- Implementation of an interfaceexercises and identification of which child + acting on methods --
     */
    public interfaceexercises Person {
        class User implements Person {
            void live() {
                System.out.println("I usually just live.");
            }
        }

        class Loser implements Person {
            void doNothing() {
                System.out.println("I usually do nothing.");
            }
        }

        class Coder implements Person {
            void writeCode() {
                System.out.println("I usually write code.");
            }
        }

        class Programmer implements Person {
            void enjoy() {
                System.out.println("It's a wonderful life!");
            }
        }
    }

    // imagine our main program starting here, if you will
    public static class InfoManagementInterfaces {
        public InfoManagementInterfaces() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Person person = null;
            String key = null;

            // Here's the loop for reading the keys. Item 1
            while (true)
            {
                // Create an object. Item 2
                String input = reader.readLine();

                if (input.equals("user")) {
                    person = new Person.User();
                }
                else if (input.equals("loser")) {
                    person = new Person.Loser();
                }
                else if (input.equals("coder")) {
                    person = new Person.Coder();
                }
                else if (input.equals("programmer")) {
                    person = new Person.Programmer();
                }
                else {
                    break;
                }

                doWork(person); // Call doWork

            }
        }

        public static void doWork(Person person) {
            // Item 3
            if (person instanceof Person.User) {
                ((Person.User)person).live();
            }
            else if (person instanceof Person.Loser) {
                ((Person.Loser)person).doNothing();
            }
            else if (person instanceof Person.Coder) {
                ((Person.Coder)person).writeCode();
            }
            else if (person instanceof Person.Programmer) {
                ((Person.Programmer)person).enjoy();
            }
        }
    }
}
