package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    void givenQuerysWhenSimulatingStockMarketThenReturnedMostValuableStock1() {
        Task6.Stock stock1 = new Task6.Stock(5);
        Task6.Stock stock2 = new Task6.Stock(7);
        Task6.Stock stock3 = new Task6.Stock(3);
        Task6.Stock stock4 = new Task6.Stock(9);
        Task6.StockExchange stockExchange = new Task6.StockExchange();
        Task6.Stock expectedMostValuableStock = new Task6.Stock(9);

        stockExchange.add(stock1);
        stockExchange.add(stock2);
        stockExchange.add(stock3);
        stockExchange.add(stock4);

        Task6.Stock actualMostValuableStock = stockExchange.mostValuableStock();

        assertTrue(actualMostValuableStock.equals(expectedMostValuableStock));
    }

    @Test
    void givenQuerysWhenSimulatingStockMarketThenReturnedMostValuableStock2() {
        Task6.Stock stock1 = new Task6.Stock(5);
        Task6.Stock stock2 = new Task6.Stock(7);
        Task6.Stock stock3 = new Task6.Stock(3);
        Task6.Stock stock4 = new Task6.Stock(9);
        Task6.StockExchange stockExchange = new Task6.StockExchange();
        Task6.Stock expectedMostValuableStock = new Task6.Stock(7);

        stockExchange.add(stock1);
        stockExchange.add(stock2);
        stockExchange.add(stock3);
        stockExchange.add(stock4);
        stockExchange.remove(stock4);

        Task6.Stock actualMostValuableStock = stockExchange.mostValuableStock();

        assertTrue(actualMostValuableStock.equals(expectedMostValuableStock));
    }

    @Test
    void givenQuerysWhenSimulatingStockMarketThenReturnedMostValuableStock3() {
        Task6.Stock stock1 = new Task6.Stock(9);
        Task6.Stock stock2 = new Task6.Stock(5);
        Task6.Stock stock3 = new Task6.Stock(3);
        Task6.Stock stock4 = new Task6.Stock(9);
        Task6.StockExchange stockExchange = new Task6.StockExchange();
        Task6.Stock expectedMostValuableStock = new Task6.Stock(9);

        stockExchange.add(stock1);
        stockExchange.add(stock2);
        stockExchange.add(stock3);
        stockExchange.add(stock4);
        stockExchange.remove(stock4);

        Task6.Stock actualMostValuableStock = stockExchange.mostValuableStock();

        assertTrue(actualMostValuableStock.equals(expectedMostValuableStock));
    }

    @Test
    void givenQuerysWhenSimulatingStockMarketThenReturnedMostValuableStock4() {
        Task6.Stock stock1 = new Task6.Stock(9);
        Task6.Stock stock2 = new Task6.Stock(37);
        Task6.Stock stock3 = new Task6.Stock(7);
        Task6.Stock stock4 = new Task6.Stock(35);
        Task6.Stock stock5 = new Task6.Stock(45);
        Task6.StockExchange stockExchange = new Task6.StockExchange();
        Task6.Stock expectedMostValuableStock = new Task6.Stock(37);

        stockExchange.add(stock1);
        stockExchange.add(stock2);
        stockExchange.add(stock3);
        stockExchange.add(stock4);
        stockExchange.add(stock5);
        stockExchange.remove(stock4);
        stockExchange.remove(stock3);
        stockExchange.remove(stock5);
        stockExchange.remove(stock1);

        Task6.Stock actualMostValuableStock = stockExchange.mostValuableStock();

        assertTrue(actualMostValuableStock.equals(expectedMostValuableStock));
    }

    @Test
    void givenQuerysWhenSimulatingStockMarketThenReturnedMostValuableStock5() {
        Task6.Stock stock1 = new Task6.Stock(9);
        Task6.Stock stock2 = new Task6.Stock(37);
        Task6.Stock stock3 = new Task6.Stock(7);
        Task6.Stock stock4 = new Task6.Stock(35);
        Task6.Stock stock5 = new Task6.Stock(45);
        Task6.StockExchange stockExchange = new Task6.StockExchange();
        Task6.Stock expectedMostValuableStock = null;

        stockExchange.add(stock1);
        stockExchange.add(stock2);
        stockExchange.add(stock3);
        stockExchange.add(stock4);
        stockExchange.add(stock5);
        stockExchange.remove(stock4);
        stockExchange.remove(stock3);
        stockExchange.remove(stock5);
        stockExchange.remove(stock1);
        stockExchange.remove(stock2);

        Task6.Stock actualMostValuableStock = stockExchange.mostValuableStock();

        assertTrue(actualMostValuableStock == null);
    }
}
