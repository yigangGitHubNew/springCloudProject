package org.spring.springboot.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCityDao {
	
	@Autowired
	private CityService cityService;

	@Autowired
	private CityDao cityDao;

	@Test
	public void testCityName(){
		City city = cityService.findCityByName("杭州");
		if(city == null){
			System.out.println("该条记录已经被锁住");
		}else{
			System.out.println("该城市名是："+city.getCityName());
		}
	}

	@Test
	public void test(){
		List<City> citys = cityDao.selectCityList();
		System.out.println(citys.size());
	}
	
	@Test
	public void testFindCityList() {
		List<City> citys = cityService.findCityList();
		System.out.println(citys.size());
	}
	
	@Test
	public void testGetPage() {
		Page<City> cityPage = cityService.getCityByPage();
		PageInfo<City> cityPages = new PageInfo<City>(cityPage);
		System.out.println(cityPage.getResult().size());
		System.out.println(JSON.toJSONString(cityPage));
		System.out.println(JSON.toJSONString(cityPages));
	}
}
