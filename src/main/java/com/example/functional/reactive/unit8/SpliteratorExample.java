package com.example.functional.reactive.unit8;

import com.example.functional.reactive.unit6.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorExample {
    public static void main(String args[]){
        Path path = Paths.get("/Users/adwaita/RadhaKrishna/Development/Install/git_repo/functional-reactive/src/main/java/com/example/functional/reactive/unit8/Books.txt");
        try(Stream<String> lines = Files.lines(path)){
          Spliterator<String> baseSpliterator = lines.spliterator();
          Spliterator<Book> bookSpliterator = new BookSpliterator(baseSpliterator);
            StreamSupport.stream(bookSpliterator,false)
                    .forEach(System.out::println);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
