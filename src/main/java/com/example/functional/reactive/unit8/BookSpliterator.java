package com.example.functional.reactive.unit8;

import com.example.functional.reactive.unit6.Book;

import java.util.Spliterator;
import java.util.function.Consumer;

public class BookSpliterator implements  Spliterator<Book> {
    private String name;
    private String author ;
    private String genre;
    private double rating;
    private Spliterator<String> baseSpliterator;
    BookSpliterator(Spliterator<String> baseSpliterator){
        this.baseSpliterator=baseSpliterator;
    }
    @Override
    public boolean tryAdvance(Consumer<? super Book> action) {
       if(baseSpliterator.tryAdvance(name->this.name=name) &&
        baseSpliterator.tryAdvance(author->this.author=author) &&
        baseSpliterator.tryAdvance(genre->this.genre=genre) &&
        baseSpliterator.tryAdvance(rating->this.rating=Double.valueOf(rating))){
           Book book = new Book(this.name,this.author,this.genre,this.rating);
           action.accept(book);
           return true;
       }

        return false;
    }

    @Override
    public Spliterator<Book> trySplit() { //for parallelization
        return null;
    }

    @Override
    public long estimateSize() {
        return baseSpliterator.estimateSize()/4; // since 4 lines for each object
    }

    @Override
    public int characteristics() {
        return baseSpliterator.characteristics();
    }
}
