package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();
    public Task1() {

    }

    public sealed interface Expr {
        double evaluate();

        record Constant(double num) implements Expr {

            @Override
            public double evaluate() {
                return this.num;
            }
        }

        record Negate(Expr c) implements Expr {

            @Override
            public double evaluate() {
                LOGGER.trace("{} to negative", this.c);
                return -this.c.evaluate();
            }
        }

        record Exponent(Expr first, double num) implements Expr {
            @Override
            public double evaluate() {
                LOGGER.trace("{} in power {}", this.first, this.num);
                return Math.pow(this.first.evaluate(), num);
            }
        }

        record Addition(Expr first, Expr second) implements Expr {
            @Override
            public double evaluate() {
                LOGGER.trace("{} + {}", this.first, this.second);
                return this.first.evaluate() + this.second.evaluate();
            }
        }

        record Multiplication(Expr first, Expr second) implements Expr {
            @Override
            public double evaluate() {
                LOGGER.trace("{} * {}", first, second);
                return this.first.evaluate() * this.second.evaluate();
            }
        }
    }

}
