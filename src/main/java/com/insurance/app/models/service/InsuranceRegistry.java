package com.insurance.app.models.service;

import com.insurance.app.models.model.InsuredPerson;
import java.util.ArrayList;
import java.util.List;

public class InsuranceRegistry {
    private List<InsuredPerson> registry = new ArrayList<>();

    public void addInsuredPerson(InsuredPerson person) {
        registry.add(person);
    }

    public List<InsuredPerson> getAll() {
        return registry;
    }

    public List<InsuredPerson> search(String firstName, String lastName) {
        List<InsuredPerson> results = new ArrayList<>();
        for (InsuredPerson p : registry) {
            if (p.getFirstName().equalsIgnoreCase(firstName) &&
                    p.getLastName().equalsIgnoreCase(lastName)) {
                results.add(p);
            }
        }
        return results;
    }
}
