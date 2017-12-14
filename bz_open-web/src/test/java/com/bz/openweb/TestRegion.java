package com.bz.openweb;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.openweb.core.service.merchant.MerchantRegistService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRegion {
	@Autowired
	private MerchantRegistService merchantRegist;
	@Test
	public void testGetRegion() {
		Map<Integer,String> nextReginMap = merchantRegist.getSubordinateRegionById(1);
		System.out.println(nextReginMap);
	}
}
