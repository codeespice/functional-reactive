package com.example.functional.reactive.unit5.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyDesignPattern {

    public static void main(String[] args){
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock("AAPL",318.65,10));
        stockList.add(new Stock("MSFT",166.86,45));
        stockList.add(new Stock("GOOGL",99,12));
        stockList.add(new Stock("AMZ",1400.25,45));
        stockList.add(new Stock("AAPL",318.65,8));
        stockList.add(new Stock("AMZ",1400.25,9));

       List<Stock> filteredStocks = StockFilters.filter(stockList,x->x.ticker.equals("AAPL")); //strategy is ticker
        filteredStocks.forEach(System.out::println);
        List<Stock> priceFilteredStocks = StockFilters.filter(stockList,x->x.price>100);//Strategy is price
        priceFilteredStocks.forEach(System.out::println);
    }
}


class Stock {
    String ticker;
    double price;
    int quantity;

    public Stock(String ticker,double price,int quantity){
        this.price=price;
        this.ticker=ticker;
        this.quantity=quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ticker='" + ticker + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}