package com.skilldistillery.tudorjpa.Data;

import java.util.List;

import com.skilldistillery.tudorjpa.entities.Address;


public interface TutDAOAddress {
	public List<Address> findAllAddresses();
	public Address createAddresses(Address add);
	public Address updateAddresses(int id, Address add);
	public Address findAddressesById(int id);
	public boolean deleteAddresses(int id);

}
