package com.services;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.entities.CartEntity;
import com.exceptions.CartException;
import com.exceptions.InvalidCustomerIdException;
import com.repository.ICartRepository;
import com.repository.IProductRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartServiceImpl.class)
class CartServiceImplTest {
	
	@MockBean
	ICartRepository iCartRepository;
	
	@MockBean
	IProductRepository iProductRepository;
	
	@Autowired
	ICartService iCartService;
	
	@Test
	void testaddCart01() throws CartException,InvalidCustomerIdException {

		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
		Mockito.when(iCartRepository.saveAndFlush(cartEntity)).thenReturn(cartEntity);
		assertNotNull(cartEntity);		
	}
	
	@Test
	void testDeleteorder01() throws InvalidCustomerIdException {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
        
        Mockito.when(iCartRepository.save(cartEntity)).thenReturn(cartEntity);
        iCartRepository.deleteById(cartEntity.getId());
        Assert.assertNotEquals(cartEntity, new CartEntity());
	}
		
	@Test
	void testgetAllCustomers01() {
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
        
		CartEntity cartEntity1 = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(1258.35);
		cartEntity.setProductName("shoe");
		cartEntity.setQuantity(1);
		cartEntity.setTotal(1050.25);
        
        List<CartEntity> cartlist = new ArrayList<>();
        cartlist.add(cartEntity);
        cartlist.add(cartEntity1);
        Mockito.when(iCartRepository.findAll()).thenReturn(cartlist);
	}
}
