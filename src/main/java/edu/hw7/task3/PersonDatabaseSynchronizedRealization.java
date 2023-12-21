package edu.hw7.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonDatabaseSynchronizedRealization implements PersonDatabase {
    private final Map<Integer, Person> personById = new HashMap<>();
    private final Map<String, List<Integer>> idByName = new HashMap<>();
    private final Map<String, List<Integer>> idByAddress = new HashMap<>();
    private final Map<String, List<Integer>> idByPhone = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
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
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personById.get(id);

        if (person != null) {
            idByName.get(person.name()).remove(person.id());
            idByAddress.get(person.address()).remove(person.id());
            idByPhone.get(person.phoneNumber()).remove(person.id());
            personById.remove(person.id());
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
