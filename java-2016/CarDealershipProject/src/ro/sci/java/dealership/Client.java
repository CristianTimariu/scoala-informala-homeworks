package ro.sci.java.dealership;

import ro.sci.java.dealership.BankAccount;

/**
 * 
 * @author Timy
 *
 */

public class Client {

	private String name;
	private Address address;
	private BankAccount bankAccount;
	private String id;

	/**
	 * Constructor for Client
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param bankAccount
	 */
	public Client(String id, String name, Address address, BankAccount bankAccount) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.bankAccount = bankAccount;
	}

	// Getters & setters
	public String getName() {
		return name;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Client name: " + name + "\nAddress| " + address.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bankAccount == null) ? 0 : bankAccount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
