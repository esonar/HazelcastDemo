package org.example;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastTest {
    public static void main(String[] args) {
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        IMap<Integer, Person> personMap = client.getMap("personMap");

        // Put 10,000 Person objects
        for (int i = 0; i < 10000; i++) {
            personMap.put(i, new Person("Person" + i));
        }

        // Retrieve and print a sample Person object
        Person person = personMap.get(5000);
        System.out.println("Retrieved Person: " + person.getName());

        client.shutdown();
    }
}