package edu.hw7;

import java.util.List;
import org.junit.jupiter.api.Test;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3dot5Test {
    @Test
    void givenPersonDBWhenAddingAndFindingByNamePeopleThenReturn() throws InterruptedException {
        Task3.PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new Task3.PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Task3.Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Task3.Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(
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

        sleep(100);

        assertThat(personDatabaseReadWriteLockRealization.findByName("Tim")).isEqualTo(
            List.of(new Task3.Person(1, "Tim", "Gagarina 30", "+7478447")
            ));
    }

    @Test
    void givenPersonDBWhenAddingAndFindingByAddressPeopleThenReturn() throws InterruptedException {
        Task3.PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new Task3.PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Task3.Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Task3.Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(
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

        sleep(100);

        assertThat(personDatabaseReadWriteLockRealization.findByAddress("Torina 10")).isEqualTo(
            List.of(new Task3.Person(2, "Tom", "Torina 10", "+74121257")
            ));
    }

    @Test
    void givenPersonDBWhenAddingAndFindingByPhoneNumberPeopleThenReturn() throws InterruptedException {
        Task3.PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new Task3.PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Task3.Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Task3.Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(
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

        sleep(100);

        assertThat(personDatabaseReadWriteLockRealization.findByPhone("+2352351")).isEqualTo(
            List.of(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351")
            ));
    }

    @Test
    void givenPersonDBWhenParallelAddingAndFindingPeopleByNameThenReturn() throws InterruptedException {
        Task3.PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new Task3.PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Task3.Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Task3.Person(2, "Tom", "Torina 10", "+74121257"));

                assertThat(personDatabaseReadWriteLockRealization.findByName("Tom"))
                    .isEqualTo(new Task3.Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(
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
        Task3.PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new Task3.PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Task3.Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Task3.Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                    assertThat(personDatabaseReadWriteLockRealization.findByAddress("Bimireno 30"))
                        .isEqualTo(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351"));
                }
            };
        Thread th1 = new Thread(runnable1);
        Thread th2 = new Thread(runnable2);

        th1.start();
        th2.start();
    }

    @Test
    void givenPersonDBWhenParallelAddingAndFindingPeopleByPhoneThenReturn() throws InterruptedException {
        Task3.PersonDatabaseReadWriteLockRealization
            personDatabaseReadWriteLockRealization = new Task3.PersonDatabaseReadWriteLockRealization();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                personDatabaseReadWriteLockRealization.add(new Task3.Person(1, "Tim", "Gagarina 30", "+7478447"));
                personDatabaseReadWriteLockRealization.add(new Task3.Person(2, "Tom", "Torina 10", "+74121257"));
            }
        },
            runnable2 = new Runnable() {
                @Override
                public void run() {
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(5, "Kamila", "Bimireno 30", "+2352351"));
                    personDatabaseReadWriteLockRealization.add(new Task3.Person(
                        12,
                        "Niemand",
                        "Kokorina 10",
                        "+72352357"
                    ));
                    assertThat(personDatabaseReadWriteLockRealization.findByPhone("+72352357"))
                        .isEqualTo(List.of(new Task3.Person(
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
