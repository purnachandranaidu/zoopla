package com.zoopla.PageObjetcs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertySearch {
	WebDriver ldriver;
	public PropertySearch(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="q")WebElement Searchtxt;
	@FindBy(id="search-submit")WebElement Searchbtn;
	public void property_search()
	{
		Searchtxt.sendKeys("London");
		try {
			Thread.sleep(3000);
			WebElement dropdown = ldriver.findElement(By.id("ui-id-1"));
			List<WebElement> options = dropdown.findElements(By.tagName("li"));
			System.out.println(options.size());
			for(int i=0;i<options.size();i++)
			{
				ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				options.get(i).click();
				break;
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void serachbtn()
	{
		Searchbtn.click();
	}
	
	public void sort()
	{
		Select pricedropdown=new Select(ldriver.findElement(By.xpath("//select[@name='results_sort']")));
		pricedropdown.selectByIndex(2);
	}
	
	public void pricelist()
	{
		WebElement price=ldriver.findElement(By.xpath(".//*[@class='listing-results clearfix js-gtm-list']//div[2]/a"));
		List<WebElement> options=price.findElements(By.xpath("//a[@class='listing-results-price text-price']"));
		System.out.println(options.size());
		
		//options.get(5).click();
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
			options.get(i).click();
			
			System.out.println("Hello");
			
		}
		
	}
	
	

}
