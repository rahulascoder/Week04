package com.day2_Collections.map_Interface;

import java.util.*;

class Policy {

    //attributes
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;

    //constructor
    public Policy(String policyNumber, String policyholderName, Date expiryDate) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                '}';
    }
}

public class InsurancePolicyManagement {
    // Using HashMap for storing policies by number
    private Map<String, Policy> policyMap;
    // Using linkedlist maintain insertion order
    private LinkedHashMap<String, Policy> orderedPolicies;
    // Sorting by expiry date
    private TreeMap<Date, Policy> sortedByExpiry;

    public InsurancePolicyManagement() {
        policyMap = new HashMap<>();
        orderedPolicies = new LinkedHashMap<>();
        sortedByExpiry = new TreeMap<>();
    }

    // Add a new policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicies.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

    // Retrieving a policy by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.getOrDefault(policyNumber, null);
    }

    // List policies expiring within the next 30 days
    public void listExpiringPolicies() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = calendar.getTime();

        System.out.println("\nPolicies Expiring in the Next 30 Days:");
        for (Map.Entry<Date, Policy> entry : sortedByExpiry.entrySet()) {
            if (entry.getKey().before(thresholdDate)) {
                System.out.println(entry.getValue());
            }
        }
    }

    // List policies by policyholder name
    public void listPoliciesByHolder(String holderName) {
        System.out.println("\nPolicies for " + holderName + ":");
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                System.out.println(policy);
            }
        }
    }

    // Removing expired policies
    public void removeExpiredPolicies() {
        Date today = new Date();
        Iterator<Map.Entry<Date, Policy>> iterator = sortedByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Date, Policy> entry = iterator.next();
            if (entry.getKey().before(today)) {
                String policyNumber = entry.getValue().getPolicyNumber();
                policyMap.remove(policyNumber);
                orderedPolicies.remove(policyNumber);
                iterator.remove();
                System.out.println("Removed expired policy: " + policyNumber);
            }
        }
    }

    // Displaying all policies in order of insertion
    public void displayAllPolicies() {
        System.out.println("\nAll Policies (Insertion Order):");
        orderedPolicies.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagement policySystem = new InsurancePolicyManagement();

        // Creating sample policies
        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.JANUARY, 15);
        policySystem.addPolicy(new Policy("P1001", "Alice", cal.getTime()));

        cal.set(2024, Calendar.FEBRUARY, 20);
        policySystem.addPolicy(new Policy("P1002", "Bob", cal.getTime()));

        cal.set(2024, Calendar.MARCH, 10);
        policySystem.addPolicy(new Policy("P1003", "Alice", cal.getTime()));

        cal.set(2024, Calendar.JANUARY, 25);
        policySystem.addPolicy(new Policy("P1004", "David", cal.getTime()));

        // Retrieving a policy
        System.out.println("\nRetrieved Policy: " + policySystem.getPolicyByNumber("P1002"));

        // Listing expiring policies
        policySystem.listExpiringPolicies();

        // Listing policies by policyholder
        policySystem.listPoliciesByHolder("Alice");

        // Removing expired policies
        policySystem.removeExpiredPolicies();

        // Displaying all policies
        policySystem.displayAllPolicies();
    }
}
