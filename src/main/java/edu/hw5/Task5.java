package edu.hw5;

public class Task5 {
    private Task5() {

    }

    static boolean licensePlateValidation(String licensePlate) {
        return licensePlate.matches("^[АВЕКМНОРСТУХ]{1}[0-9]{3}[АВЕКМНОРСТУХ]{2}[0-9]{2,3}$");
    }
}
