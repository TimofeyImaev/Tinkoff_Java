package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {
    private static final Logger LOGGER = LogManager.getLogger();

    public Task2() {

    }

    public static class Rectangle {
        private int width;
        private int height;

        void setWidth(int width) {
            LOGGER.trace("Set rectangle width on {}", width);
            this.width = width;
        }

        void setHeight(int height) {
            LOGGER.trace("Set rectangle height on {}", height);
            this.height = height;
        }

        double area() {
            LOGGER.trace("Get area of rectangle with width: {} and height: {}", this.width, this.height);
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        void setSide(int sideLength) {
            LOGGER.trace("Set square side on {}", sideLength);
            super.setHeight(sideLength);
            super.setWidth(sideLength);
        }
    }
}
