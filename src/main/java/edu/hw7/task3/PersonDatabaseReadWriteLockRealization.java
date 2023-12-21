package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class PersonDatabaseReadWriteLockRealization implements PersonDatabase {
    private final Map<Integer, Person> personById = new HashMap<>();
    private final Map<String, List<Integer>> idByName = new HashMap<>();
    private final Map<String, List<Integer>> idByAddress = new HashMap<>();
    private final Map<String, List<Integer>> idByPhone = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();

        try {
            personById.put(person.id(), person);

            List<Integer> byNameList = idByName.getOrDefault(person.name(), new ArrayList<>());
            byNameList.add(person.id());
            idByName.put(person.name(), byNameList);

            List<Integer> byAddressList = idByAddress.getOrDefault(person.address(), new ArrayList<>());
            byAddressList.add(person.id());
            idByAddress.put(person.address(), byAddressList);

            List<Integer> byPhoneList = idByPhone.getOrDefault(person.phoneNumber(), new ArrayList<>());
            byPhoneList.add(person.id());
            idByPhone.put(person.phoneNumber(), byPhoneList);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();

        try {
            Person person = personById.get(id);

            if (person != null) {
                idByName.get(person.name()).remove(person.id());
                idByAddress.get(person.address()).remove(person.id());
                idByPhone.get(person.phoneNumber()).remove(person.id());
                personById.remove(person.id());
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        List<Person> answer = List.of();

        try {
            answer = getPersonListByTag(idByName, name);
        } finally {
            lock.readLock().unlock();
        }
        return answer;
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        List<Person> answer = List.of();

        try {
            answer = getPersonListByTag(idByAddress, address);
        } finally {
            lock.readLock().unlock();
        }
        return answer;
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        List<Person> answer = List.of();

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
