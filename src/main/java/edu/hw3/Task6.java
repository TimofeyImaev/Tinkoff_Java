package edu.hw3;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Task6 {
    private Task6() {

    }

    class Stock {
        int price;

        public Stock(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
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

    static class stockExchange implements StockMarket {
        PriorityQueue<Stock> sharesInOrder;
        TreeMap<Stock, Integer> deletedShares;

        @Override
        public void add(Stock stock) {
            sharesInOrder.add(stock);
        }

        @Override
        public void remove(Stock stock) {
            if (deletedShares.containsKey(stock)) {
                deletedShares.put(stock, deletedShares.get(stock) + 1);
            } else {
                deletedShares.put(stock, 1);
            }
        }

        @Override
        public Stock mostValuableStock() {
            Stock mostExpensiveStock = sharesInOrder.peek();

            while (deletedShares.containsKey(mostExpensiveStock)
                && deletedShares.get(mostExpensiveStock).compareTo(1) >= 0) {
                deletedShares.put(mostExpensiveStock, deletedShares.get(mostExpensiveStock) - 1);
                sharesInOrder.remove();

                mostExpensiveStock = sharesInOrder.peek();
            }

            return mostExpensiveStock;
        }
    }
}
