package com.deepdiveusingjava.udemy.hashtable;

import com.deepdiveusingjava.udemy.model.Employee;

public class SimpleHashTable {

	private StoredEmployee[] hashTable;

	public SimpleHashTable() {
		hashTable = new StoredEmployee[10];
	}

	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);

		// Implementing linear probing
		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;
			if (hashedKey == hashTable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}

			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey + 1) % hashTable.length;
			}
		}

		// Avoiding collisions
		if (occupied(hashedKey)) {
			System.out.println("Sorry, there's already an employee at this position, " + hashedKey);
		} else {
			hashTable[hashedKey] = new StoredEmployee(key, employee);
		}
	}

	public Employee get(String key) {
		int hashedKey = findKey(key);
		if (hashedKey == -1) {
			return null;
		}

		if (hashTable[hashedKey] == null) {
			return null;
		} else {
			return hashTable[hashedKey].employee;
		}
	}

	public Employee remove(String key) {
		int hashedKey = findKey(key);
		Employee removedEmployee = null;

		if (hashedKey == -1) {
			return null;
		}

		removedEmployee = hashTable[hashedKey].employee;
		hashTable[hashedKey] = null;

// 		Rehashing;
//		StoredEmployee[] oldHashTable = hashTable;
//		oldHashTable = new StoredEmployee[hashTable.length];
//		for (int i = 0; i < oldHashTable.length; i++) {
//			if (oldHashTable[i] != null) {
//				put(oldHashTable[i].key, oldHashTable[i].employee);
//			}
//		}

		return removedEmployee;
	}

	private int hashKey(String key) {
		return key.length() % hashTable.length;
	}

	private int findKey(String key) {
		int hashedKey = hashKey(key);

		// Comparing the slot, and key
		// to find the correct hashedKey
		// of the employee.
		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		// Implementing linear probing
		int stopIndex = hashedKey;
		if (hashedKey == hashTable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}

		while (hashedKey != stopIndex && hashTable[hashedKey] != null && !hashTable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashTable.length;
		}

		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		} else {
			return -1;
		}
	}

	private boolean occupied(int index) {
		return hashTable[index] != null;
	}

	public void print() {
		for (StoredEmployee storedEmployee : hashTable) {
			if (storedEmployee == null) {
				System.out.println("Empty.");
			} else {
				System.out.println(storedEmployee.employee);
			}
		}
		System.out.println();
	}

}
