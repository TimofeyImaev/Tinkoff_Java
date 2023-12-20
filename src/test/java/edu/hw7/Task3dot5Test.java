package edu.hw7;

import java.util.List;
import edu.hw7.task3.Person;
import edu.hw7.task3.PersonDatabaseReadWriteLockRealization;
import org.junit.jupiter.api.Test;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3dot5Test {
    @Test
    void givenPersonDBWhenAddingAndFindingByNamePeopleThenReturn() throws InterruptedException {
        PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                }
            };
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        assertThat(personDatabaseReadWriteLockRealization.findByName("Tim")).isEqualTo(
            List.of(new Person(1, "Tim", "Gagarina 30", "+7478447")
            ));
    }

    @Test
    void givenPersonDBWhenAddingAndFindingByAddressPeopleThenReturn() throws InterruptedException {
        PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                }
            };
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        assertThat(personDatabaseReadWriteLockRealization.findByAddress("Torina 10")).isEqualTo(
            List.of(new Person(2, "Tom", "Torina 10", "+74121257")
            ));
    }

    @Test
    void givenPersonDBWhenAddingAndFindingByPhoneNumberPeopleThenReturn() throws InterruptedException {
        PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                }
            };
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        assertThat(personDatabaseReadWriteLockRealization.findByPhone("+2352351")).isEqualTo(
            List.of(new Person(5, "Kamila", "Bimireno 30", "+2352351")
            ));
    }

    @Test
    void givenPersonDBWhenParallelAddingAndFindingPeopleByNameThenReturn() throws InterruptedException {
        PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Person(2, "Tom", "Torina 10", "+74121257"));

                assertThat(personDatabaseReadWriteLockRealization.findByName("Tom"))
                    .isEqualTo(new Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                }
            };
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();
    }

    @Test
    void givenPersonDBWhenParallelAddingAndFindingPeopleByAddressThenReturn() throws InterruptedException {
        PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                    assertThat(personDatabaseReadWriteLockRealization.findByAddress("Bimireno 30"))
                        .isEqualTo(new Person(5, "Kamila", "Bimireno 30", "+2352351"));
                }
            };
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();
    }

    @Test
    void givenPersonDBWhenParallelAddingAndFindingPeopleByPhoneThenReturn() throws InterruptedException {
        PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                    assertThat(personDatabaseReadWriteLockRealization.findByPhone("+72352357"))
                        .isEqualTo(List.of(new Person(
                            12,
                            "Niemand",
                            "Kokorina 10",
                            "+72352357"
                        )));
                }
            };
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();
    }
}
