package com.zoopla.testcases;

import org.testng.annotations.Test;

import com.zoopla.PageObjetcs.PropertySearch;

public class TC_Search_Property_001 extends BaseClass{
	@Test
	public void search()
	{
		PropertySearch search=new PropertySearch(driver);
		search.property_search();
		
		search.serachbtn();
		
		search.sort();
		
		search.pricelist();
		
	}

}
