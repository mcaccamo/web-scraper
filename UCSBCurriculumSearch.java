package mytestpack;
//import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML;
import org.jsoup.*;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class UCSBCurriculumSearch {
    
    
    public static ArrayList<String> lectures = new ArrayList<String>();

    public static ArrayList<String>  loadCourses() 
    {
	WebDriver driver = new FirefoxDriver();
	
	driver.get("https://my.sa.ucsb.edu/public/curriculum/coursesearch.aspx");
	String [] subject = {"ANTH" , "ART", "ART CS", "ARTHI", "ARTST", "AS AM", "ASTRO", "BIOL",
			     "BIOL CS", "BMSE","BL ST", "CH E", "CHEM CS", "CHEM", "CH ST", "CHIN", "CLASS",
			     "COMM", "C LIT", "CMPSC", "CMPSCCS", "CMPTG", "CMPTGCS", "CNCSP", "DANCE", "DYNS",
			     "EARTH", "EACS", "EEMB", "ECON", "ED", "ECE", "ENGR", "ENGL", "ESM", "ENV S", "ESS",
			     "ES", "FEMST", "FAMST", "FLMST", "FR", "GEN S", "GEN SCS", "GEOG", "GER", "GPS", "GLOBL",
			     "GREEK", "HEB", "HIST", "INT", "INT CS", "ITAL", "JAPAN", "KOR", "LATIN", "LAIS", "LING",
			     "LIT", "LIT CS", "MARSC", "MATRL", "MATH", "MATH CS", "ME", "MAT", "ME ST", "MES",
			     "MS", "MCDB", "MUS", "MUS CS", "MUS A", "PHIL", "PHYS", "PHYS CS", "POL S", "PORT", "PSY", "RG ST",
			     "RENST", "SLAV", "SOC", "SPAN", "SHS", "PSTAT", "TMP", "THTR", "WRIT", "W&L", "W&L CS"};
	    
	int deptSize = subject.length;
	    
	    
	//Select depts = new Select(driver.findElement(By.id("ctl00_pageContent_courseList")));
	// index 87 = pstat
	
	
	
	String [] qrtrs = {"FALL 2016"," SUMMER 2016","SPRING 2016","WINTER 2016","FALL 2015","SUMMER 2015", "SPRING 2015","WINTER 2015", "FALL 2014","SUMMER 2014", "SPRING 2014"};
	
	int qrtrSize = qrtrs.length;
	
	Select qrtr = new Select(driver.findElement(By.id("ctl00_pageContent_quarterList")));
	//index 1 is summer
	qrtr.selectByIndex(0);

	int indexOfSelectedqrtr = 0;
	
	
	
	

	
	for(int i =0; i < deptSize; i++){
	    Select depts = new Select(driver.findElement(By.id("ctl00_pageContent_courseList"))); //need to do this here idk why
	    
	    depts.selectByIndex(i);
	    
	    
	    //depts.selectByIndex(i);
	    //qrtr.selectByIndex(0);
	    driver.findElement(By.id("ctl00_pageContent_searchButton")).click(); //click search 
	    //int size = tr.size();

	    String html = driver.getPageSource(); //get html as a stringn
	     
	    Document doc = Jsoup.parse(html); //create doc?
	    
	    doc.select("tr.CourseInfoRow").select("div").remove();
	    
	    
	    String tds = doc.select("tr.CourseInfoRow").text();
	    
	    System.out.println(tds);
	    
	    lectures.add(tds);





	    
	    
	     
	    

	    
	}
	
	return lectures;
	
	
    }