package com.example.transactionpropagations.service;

import com.example.transactionpropagations.repo.AuthorRepository;
import com.example.transactionpropagations.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.transactionpropagations.model.Author;
import com.example.transactionpropagations.model.Book;

import java.util.List;

@Service
public class    LibraryService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void callWithoutTransaction(TransactionalProcessor processor){
        processor.execute();
    }

    @Transactional
    public void callWithinTransaction(TransactionalProcessor processor){
        processor.execute();
    }


    /**
     * This method demonstrates the REQUIRED propagation behavior.
     * If the caller is already in a transaction, the method will execute within that transaction.
     * Otherwise, a new transaction will be created for the method.
     */
    @Transactional(label = "Propagation.REQUIRED")
    public void requiredPropagation() {
        // Creating a new author and a book within a REQUIRED transaction
        Author author = new Author();
        author.setName("John Doe");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Sample Book");
        book.setAuthor(author);
        bookRepository.save(book);

        // Retrieving entities within the same transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();
    }

    /**
     * This method demonstrates the SUPPORTS propagation behavior.
     * If the caller is already in a transaction, the method will execute within that transaction.
     * Otherwise, the method will execute outside of a transaction.
     */
    @Transactional(propagation = Propagation.SUPPORTS,label = "Propagation.SUPPORTS")
    public void supportsPropagation() {
        // Attempting to read entities within a SUPPORTS transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();
    }

    /**
     * This method demonstrates the MANDATORY propagation behavior.
     * If the caller is already in a transaction, the method will execute within that transaction.
     * Otherwise, an exception will be thrown.
     */
    @Transactional(propagation = Propagation.MANDATORY,label = "Propagation.MANDATORY")
    public void mandatoryPropagation() {
        // Attempting to read entities within a MANDATORY transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();
    }

    /**
     * This method demonstrates the REQUIRES_NEW propagation behavior.
     * this method will be executed in a new transaction, regardless of the transactional context of the caller.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,label = "Propagation.REQUIRES_NEW")
    public void requiresNewPropagation() {
        Author author = new Author();
        author.setName("Jane Doe");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Another Book");
        book.setAuthor(author);
        bookRepository.save(book);

        // Retrieving entities within the same transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();
    }



    /**
     * This method demonstrates the NOT_SUPPORTED propagation behavior.
     * If the caller is already in a transaction, the transaction will be suspended and the method will execute outside of the transaction.
     * Otherwise, the method will execute outside of a transaction.
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED,label = "Propagation.NOT_SUPPORTED")
    public void notSupportedPropagation() {
        // Attempting to read entities within a NOT_SUPPORTED transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();
    }

    /**
     * This method demonstrates the NEVER propagation behavior.
     * If the caller is already in a transaction, an exception will be thrown.
     * Otherwise, the method will execute outside of a transaction.
     */
    @Transactional(propagation = Propagation.NEVER,label = "Propagation.NEVER")
    public void neverPropagation() {
        // Attempting to read entities within a NEVER transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();
    }

    /**
     * This method demonstrates the Nested propagation behavior.
     * If the caller is already in a transaction, the method will execute within that transaction.
     * Otherwise, a new transaction will be created for the method.
     */
    @Transactional(propagation = Propagation.NESTED,label = "Propagation.NESTED")
    public void nestedPropagation() {
        // Creating a new author and a book within a NESTED transaction
        Author author = new Author();
        author.setName("John Doe");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Sample Book");
        book.setAuthor(author);
        bookRepository.save(book);

        // Retrieving entities within the same transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();
    }

    /**
     * This method demonstrates the isolation level READ_COMMITTED.
     * This is the default isolation level for Spring transactions.
     * It means that a transaction will only be able to read entities that have already been committed.
     * This is the most common isolation level in production systems.
     * It provides a good balance between performance and data integrity.
     * It is also the default isolation level for most relational databases.
     *
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void readCommittedIsolation() {
        // Attempting to read entities within a READ_COMMITTED transaction
        List<Author> authors = authorRepository.findAll();
        List<Book> books = bookRepository.findAll();

    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

