import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckSearchByYearUnhappyPath {

    @Parameterized.Parameter
    public int year;

    static Books bookShelf;
    public Books someBooks;

    @BeforeClass
    public static void readBooks() {
        Book[] sklad = new Book[]{
                new Book(1, "Добрі новини з Аральського моря", "Ірена Карпа", "#книголав", 2019, 592, 300.00F),
                new Book(2, "Тореадори з Васюківки", "Всеволод Нестайко", "А-ба-ба-га-ла-ма-га", 2013, 544, 130.00F),
                new Book(3, "Бог завжди подорожує інкогніто", "Лоран Гунель", "Книжковий клуб \"Клуб Сімейного Дозвілля\"", 2016, 416, 95.00F),
                new Book(4, "Моя бабуся просить їй вибачити", "Фредрік Бакман", "#книголав", 2017, 416, 200.00F),
                new Book(5, "Музей покинутих секретів", "Оксана Забужко", "Комора", 2015, 832, 220.00F),
                new Book(6, "Доки світло не згасне назавжди", "Макс Кідрук", "Книжковий клуб \"Клуб Сімейного Дозвілля\"", 2019, 560, 150.00F),
                new Book(7, "Гаррі Поттер і філософський камінь", "Джоан Роулінг", "А-ба-ба-га-ла-ма-га", 2016, 248, 460.00F),
                new Book(8, "Маленький принц", "Антуан де Сент-Экзюпери", "А-ба-ба-га-ла-ма-га", 2014, 64, 220.00F),
                new Book(9, "Гаррі Поттер і Келих Вогню", "Джоан Роулінг", "А-ба-ба-га-ла-ма-га", 2019, 464, 540.00F),
                new Book(10, "Маркетер", "Олег Сенцов", "Видавництво Старого Лева", 2019, 376, 150.00F),
                new Book(11, "Мексиканські хроніки", "Макс Кідрук", "Книжковий клуб \"Клуб Сімейного Дозвілля\"", 2016, 256, 95.00F),
                new Book(12, "Купите книгу - она смешная ", "Олег Сенцов", "Фолио", 2016, 219, 99.00F),
                new Book(13, "Подорож на Пуп Землі ", "Макс Кідрук", "Книжковий клуб \"Клуб Сімейного Дозвілля\"", 2016, 376, 100.00F),
                new Book(14, "Жизня", "Олег Сенцов", "Видавництво Старого Лева", 2019, 160, 90.00F)
        };
        bookShelf = new Books(sklad);
        System.out.println("\nThe bookshelf contents:");
        bookShelf.printBooks();
    }

    @Parameterized.Parameters(name="{index}: search for {0} should be null")
    public static Collection dataForSearchYearUnhappyPath() {
        return Arrays.asList(new Object[][]{
                {2025},
                {2027}
        });
    }

    @Test
    public void checkSearchYearUnhappyPath() {
        try {
            someBooks = bookShelf.searchYear(year);
            someBooks.printBooks();
            Assert.assertNull("\nThe test checks the search for books by year of publication with invalid data." +
                    "\nThese books are found with year of publication after " + year, someBooks);
        } catch (InvalidInputException err) {
            System.err.println(err.getMessage() + " with year of publication after  " + year);
        }
    }

}
