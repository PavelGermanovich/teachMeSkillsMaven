package homework.lesson13.task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "related books")
public class RelatedBooks {
    @XmlElement(name = "Book")
    private List<Book> relatedBooks = new ArrayList<>();

    public void addBookToList(Book book) {
        relatedBooks.add(book);
    }

    public List getRelatedBooks() {
        return relatedBooks;
    }
}
