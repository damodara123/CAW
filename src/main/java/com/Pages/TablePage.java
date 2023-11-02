package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Base.BrowserSetup;

public class TablePage extends BrowserSetup{
	//String actual,expected;
	public By TBDataButton = By.xpath("//*[text()='Table Data']");
	
	public By TextBox = By.id("jsondata");
	
	public By RefershButton = By.id("refreshtable");
	
	public By TbRow = By.xpath("//table//tr[2]");
	
	public void buttonClick()
	{
		clickElement(TBDataButton);
	}
	
	public void TextBox()
	{
		
		enterText(TextBox, "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]");
	}

	public void BtnClick()
	{
		clickElement(RefershButton);
	}
	
	public void tabledata()
	{
		List<WebElement> rows =driver.findElements(By.xpath(("//table//tr")));
		int rowcnt = rows.size();
		//System.out.println(rowcnt);
		//for(int i =2;i<=rowcnt;i++)
		//{
			String actual1 =driver.findElement(By.xpath("//table//tr[2]")).getText();
			String expected1 ="Bob 20 male";
			Assert.assertEquals(actual1, expected1);
			
			String actual2 =driver.findElement(By.xpath("//table//tr[3]")).getText();
			String expected2 ="George 42 male";
			Assert.assertEquals(actual2, expected2);
			
			String actual3 =driver.findElement(By.xpath("//table//tr[4]")).getText();
			String expected3 ="Sara 42 female";
			Assert.assertEquals(actual3, expected3);
			
			String actual4 =driver.findElement(By.xpath("//table//tr[5]")).getText();
			String expected4 ="Conor 40 male";
			Assert.assertEquals(actual4, expected4);
			
			String actual5 =driver.findElement(By.xpath("//table//tr[6]")).getText();
			String expected5 ="Jennifer 42 female";
			Assert.assertEquals(actual5, expected5);
		//}
		
		
	}
}
