package edu.hw3;

import java.util.PriorityQueue;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    private static final Logger LOGGER = LogManager.getLogger();

    private Task6() {

    }

    static class Stock implements Comparable<Stock> {
        int price;

        Stock(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public int compareTo(Stock stock) {
            return stock.price - this.price;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }

            Stock stock = (Stock) obj;
            return stock.price == this.price;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    interface StockMarket {
        /** Добавить акцию */
        void add(Stock stock);

        /** Удалить акцию */
        void remove(Stock stock);

        /** Самая дорогая акция */
        Stock mostValuableStock();
    }

    static class StockExchange implements StockMarket {
        PriorityQueue<Stock> sharesInOrder;
        TreeMap<Stock, Integer> deletedShares;

        StockExchange() {
            this.sharesInOrder = new PriorityQueue<>();
            this.deletedShares = new TreeMap<>();
        }

        @Override public void add(Stock stock) {
            LOGGER.trace("Adding stock with price {}", stock.price);
            sharesInOrder.add(stock);
        }

        @Override public void remove(Stock stock) {
            LOGGER.trace("Removing stock with price {}", stock.price);

            if (deletedShares.containsKey(stock)) {
                deletedShares.put(stock, deletedShares.get(stock) + 1);
            } else {
                deletedShares.put(stock, 1);
            }
        }

        @Override public Stock mostValuableStock() {
            Stock mostExpensiveStock = sharesInOrder.peek();

            if (mostExpensiveStock == null) {
                return null;
            }
            while (deletedShares.containsKey(mostExpensiveStock)
                && deletedShares.get(mostExpensiveStock).compareTo(1) >= 0) {
                deletedShares.put(mostExpensiveStock, deletedShares.get(mostExpensiveStock) - 1);
                sharesInOrder.remove();

                mostExpensiveStock = sharesInOrder.peek();
                if (mostExpensiveStock == null) {
                    return null;
                }
            }

            LOGGER.trace("MostValuableStock price is {}", mostExpensiveStock.price);

            return mostExpensiveStock;
        }
    }
}
