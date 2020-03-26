package com.es.user.jwt.repository.custom;



import com.es.user.jwt.entity.Address;

import java.util.List;


public interface AddressCustomRepository {

    List<Address> getAddress(String nameLike);

}
