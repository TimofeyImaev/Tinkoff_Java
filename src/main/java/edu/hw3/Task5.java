package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {
    private static final Logger LOGGER = LogManager.getLogger();

    private Task5() {

    }

    public static Object[] parseContacts(String[] names, String order) {
        if (names == null) {
            return new Object[] {};
        }

        ArrayList<String> namesList = new ArrayList<String>(Arrays.asList(names));
        int reverseOrder;
        LOGGER.trace("Sorting {} in {} order", names, order);

        if (order.equals("DESC")) {
            reverseOrder = -1;
        } else {
            reverseOrder = 1;
        }

        Collections.sort(namesList, (p1, p2) -> {
            String[] p1Split = p1.split(" ");
            String[] p2Split = p2.split(" ");

            if (p1Split.length == 2 && p2Split.length == 2) {
                return reverseOrder * p1Split[p1Split.length - 1].compareTo(p2Split[p2Split.length - 1]);
            } else {
                return reverseOrder * p1Split[0].compareTo(p2Split[0]);
            }
        });

        LOGGER.trace("Sorted array: {}", namesList);

        return namesList.stream().map(
            name -> {
                Contact newContact = new Contact();

                newContact.parseStringToNames(name);

                return newContact;
            }
        ).toArray();
    }

    public static class Contact {
        private String firstName;
        private String secondName;

        public Contact() {
            this.firstName = "";
            this.secondName = "";
        }

        public Contact(String firstName) {
            this.firstName = firstName;
            this.secondName = "";
        }

        public Contact(String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }

        String getFirstName() {
            return firstName;
        }

        String getSecondName() {
            return secondName;
        }

        @Override
        public boolean equals(Object otherContact) {
            if (otherContact == null || !this.getClass().equals(otherContact.getClass())) {
                return false;
            }

            if (this.secondName == null ^ ((Contact) otherContact).secondName == null) {
                return false;
            }

            if (this == otherContact) {
                return true;
            }

            return ((Contact) otherContact).firstName.equals(this.firstName)
                && ((Contact) otherContact).secondName.equals(this.secondName);
        }

        @Override
        public int hashCode() {
            return firstName.hashCode();
        }

        @Override
        public String toString() {
            return this.firstName + this.secondName;
        }

        void parseStringToNames(String toParse) {
            String[] names = toParse.split(" ");

            if (names.length >= 1) {
                this.firstName = names[0];
            }
            if (names.length >= 2) {
                this.secondName = names[1];
            }
        }
    }
}
