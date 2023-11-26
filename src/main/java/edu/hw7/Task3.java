package edu.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class Task3 {

    interface PersonDatabase {
        void add(Person person);

        void delete(int id);

        List<Person> findByName(String name);

        List<Person> findByAddress(String address);

        List<Person> findByPhone(String phone);
    }

    public record Person(int id, String name, String address, String phoneNumber) {
        @Override
        public boolean equals(Object person) {
            if (person == null || person.getClass() != Person.class) {
                return false;
            }

            if (person == this) {
                return true;
            }

            return this.id == ((Person) person).id && this.name.equals(((Person) person).name)
                && this.address.equals(((Person) person).address)
                && this.phoneNumber.equals(((Person) person).phoneNumber);
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    static class PersonDatabaseReadWriteLockRealization implements PersonDatabase {
        private final Map<Integer, Person> personById = new HashMap<>();
        private final Map<String, List<Integer>> idByName = new HashMap<>();
        private final Map<String, List<Integer>> idByAddress = new HashMap<>();
        private final Map<String, List<Integer>> idByPhone = new HashMap<>();
        private final ReadWriteLock lock = new ReentrantReadWriteLock();

        @Override
        public synchronized void add(Person person) {
            lock.writeLock().lock();

            try {
                personById.put(person.id, person);

                List<Integer> byNameList = idByName.getOrDefault(person.name, new ArrayList<>());
                byNameList.add(person.id);
                idByName.put(person.name, byNameList);

                List<Integer> byAddressList = idByAddress.getOrDefault(person.address, new ArrayList<>());
                byAddressList.add(person.id);
                idByAddress.put(person.address, byAddressList);

                List<Integer> byPhoneList = idByPhone.getOrDefault(person.phoneNumber, new ArrayList<>());
                byPhoneList.add(person.id);
                idByPhone.put(person.phoneNumber, byPhoneList);
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public synchronized void delete(int id) {
            lock.writeLock().lock();

            try {
                Person person = personById.get(id);

                if (person != null) {
                    idByName.get(person.name).remove(person.id);
                    idByAddress.get(person.address).remove(person.id);
                    idByPhone.get(person.phoneNumber).remove(person.id);
                    personById.remove(person.id);
                }
            } finally {
                lock.writeLock().unlock();
            }
        }

        @Override
        public synchronized List<Person> findByName(String name) {
            lock.readLock().lock();
            List<Person> answer = null;

            try {
                answer = getPersonListByTag(idByName, name);
            } finally {
                lock.readLock().unlock();
            }
            return answer;
        }

        @Override
        public synchronized List<Person> findByAddress(String address) {
            lock.readLock().lock();
            List<Person> answer = null;

            try {
                answer = getPersonListByTag(idByAddress, address);
            } finally {
                lock.readLock().unlock();
            }
            return answer;
        }

        @Override
        public synchronized List<Person> findByPhone(String phone) {
            lock.readLock().lock();
            List<Person> answer = null;

            try {
                answer = getPersonListByTag(idByPhone, phone);
            } finally {
                lock.readLock().unlock();
            }
            return answer;
        }

        private List<Person> getPersonListByTag(Map<String, List<Integer>> map, String key) {
            List<Integer> listOfIds = map.get(key);

            if (listOfIds == null) {
                return new ArrayList<>();
            }

            return listOfIds.stream().map(personById::get)
                .collect(Collectors.toList());
        }
    }

    static class PersonDatabaseSynchronizedRealization implements PersonDatabase {
        private final Map<Integer, Person> personById = new HashMap<>();
        private final Map<String, List<Integer>> idByName = new HashMap<>();
        private final Map<String, List<Integer>> idByAddress = new HashMap<>();
        private final Map<String, List<Integer>> idByPhone = new HashMap<>();

        @Override
        public synchronized void add(Person person) {
            personById.put(person.id, person);

            List<Integer> byNameList = idByName.getOrDefault(person.name, new ArrayList<>());
            byNameList.add(person.id);
            idByName.put(person.name, byNameList);

            List<Integer> byAddressList = idByAddress.getOrDefault(person.address, new ArrayList<>());
            byAddressList.add(person.id);
            idByAddress.put(person.address, byAddressList);

            List<Integer> byPhoneList = idByPhone.getOrDefault(person.phoneNumber, new ArrayList<>());
            byPhoneList.add(person.id);
            idByPhone.put(person.phoneNumber, byPhoneList);
        }

        @Override
        public synchronized void delete(int id) {
            Person person = personById.get(id);

            if (person != null) {
                idByName.get(person.name).remove(person.id);
                idByAddress.get(person.address).remove(person.id);
                idByPhone.get(person.phoneNumber).remove(person.id);
                personById.remove(person.id);
            }
        }

        @Override
        public synchronized List<Person> findByName(String name) {
            return getPersonListByTag(idByName, name);
        }

        @Override
        public synchronized List<Person> findByAddress(String address) {
            return getPersonListByTag(idByAddress, address);
        }

        @Override
        public synchronized List<Person> findByPhone(String phone) {
            return getPersonListByTag(idByPhone, phone);
        }

        private List<Person> getPersonListByTag(Map<String, List<Integer>> map, String key) {
            List<Integer> listOfIds = map.get(key);

            if (listOfIds == null) {
                return new ArrayList<>();
            }

            return listOfIds.stream().map(personById::get)
                .collect(Collectors.toList());
        }
    }

}
