package com.platformcommon.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformcommon.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
