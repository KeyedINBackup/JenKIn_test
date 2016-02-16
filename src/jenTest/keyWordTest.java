package jenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import objectRepositry.*;

public class keyWordTest {
 
  	public static WebDriver dr;
  	public static String ItemName, ItemPrice, ItemStockCode;
  	
  	@BeforeMethod
  	public static void loginIn()
  	{
  		dr = new FirefoxDriver();
  		dr.get("http://dev.angelplastics.co.uk/");
  		dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
  		dr.manage().window().maximize();
  		String winhandle =dr.getWindowHandle();
  		dr.findElement(By.xpath("html/body/div[1]/header/section[1]/div/div/div[1]/ul/li[1]/a")).click();
  		for(String win: dr.getWindowHandles()){
  			dr.switchTo().window(win);
  			dr.findElement(By.id("login_username")).sendKeys("kelvin");
			dr.findElement(By.id("login_password")).sendKeys("123asd!@#");
			dr.findElement(By.xpath("html/body/div[1]/div[1]/section/form/ul/li[4]/input")).click();
  		}
  		dr.switchTo().window(winhandle);
  	}
  	
  	@Test(enabled=true, priority=1)
  	public static void MainProduct() throws InterruptedException, IOException
  	{
  		File file=new File("C://Selenium//jenkindemo//src//objectRepositry//PageObjects");
  		FileInputStream input=new FileInputStream(file);
  		Properties prop= new Properties();
  		prop.load(input);
  		System.out.print("********************************************************\n");
  		System.out.print("\tWelcome to Angel Plastics site\n");
  		System.out.print("********************************************************\n");
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("ProductMainList"))));
  		WebElement productlist=dr.findElement(By.xpath(prop.getProperty("ProductMainList")));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =productlist.findElements(By.id("expList"));
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int r=rand.nextInt(n)+1;
  		String Str1=prop.getProperty("String1");
  		String Str2=prop.getProperty("String2");
  		WebElement Mproduct=dr.findElement(By.xpath(Str1+r+Str2));
  		Mproduct.click();
  		ScreenCapture();
  		WebElement ProdcutTile = dr.findElement(By.xpath(prop.getProperty("ProdcutTileHeading")));
  		String Title=ProdcutTile.getText();
  		System.out.print("Scenario : We are going to add product to cart by randomly selecting a product\n");
  		System.out.print("Main Product title: "+Title);
  		System.out.print("\n");
  		String[] DircetProductpage={"TERRAIN ROOF & BALCONY OUTLETS", "WATER BUTTS & ACCESSORIES"};
  		if(Arrays.asList(DircetProductpage).contains(Title))
  		{
  			ProductPage();
  		}if(Title.equalsIgnoreCase("PlumbingWaste")){
  			
  			PlumbingWaste();
  		}
  		else
  		{
  			SubProduct();
  		}
  		
  	}
  	
  	public static void PlumbingWaste() throws InterruptedException, IOException
  	{
  		File file=new File("C://Selenium//jenkindemo//src//objectRepositry//PageObjects");
  		FileInputStream input=new FileInputStream(file);
  		Properties prop= new Properties();
  		prop.load(input);
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("ProductMainList"))));
  		WebElement subproduct=dr.findElement(By.xpath(prop.getProperty("ProductMainList")));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("div"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n)+1;
  		String Str3=prop.getProperty("String3");
  		String Str4=prop.getProperty("String4");
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		ScreenCapture();
  		WebElement SProdcutTile = dr.findElement(By.xpath(prop.getProperty("ProdcutTileHeading")));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product Category title: "+Title);
  		System.out.print("\n");
  		String[] subtoProduct ={"WC PAN CONNECTORS", "PUSHFIT WASTE SYSTEM", "WASTE TRAPS", "SOLVENT WELD WASTE MUPVC", "Universal Compression Waste", "OVERFLOW SYSTEM", "CONDENSATE DRAINAGE TRAPS", "FLEXIBLE WASTES/ANTI-SYPHON UNITS"};
  		if(Arrays.asList(subtoProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			SubProductCategories();
  		}
  		
  	}
  	
  	
  
  	public static void SubProduct() throws InterruptedException, IOException
  	{
  		
  		File file=new File("C://Selenium//jenkindemo//src//objectRepositry//PageObjects");
  		FileInputStream input=new FileInputStream(file);
  		Properties prop= new Properties();
  		prop.load(input);
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("ProductMainList"))));
  		WebElement subproduct=dr.findElement(By.xpath(prop.getProperty("ProductMainList")));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("div"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n)+1;
  		String Str3=prop.getProperty("String3");
  		String Str4=prop.getProperty("String4");
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		ScreenCapture();
  		WebElement SProdcutTile = dr.findElement(By.xpath(prop.getProperty("ProdcutTileHeading")));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product Category title: "+Title);
  		System.out.print("\n");
  		String[] subtoProduct ={"SOLID BROWN COLOUR SOFFIT", "IMITATION CAST IRON", "GOLDEN OAK WOODGRAIN WINDOW TRIMS & ANGLES", "CREAM WOODGRAIN", "STANDARD WHITE WINDOW TRIMS", "INTERIOR COVING/CORNICE", "GROUND GUARD LAWN PAVING TILE", "FASCIA & SOFFIT ACCESSORIES", "POLYTOP FIXINGS" , "PIPE & FITTINGS", "375MM WIDE MARBREX WALL PANELS", "WASTE TRAPS", "ROSEWOOD FASCIA", "20MM THICK FLAT TUDOR BOARD", "SOLID CREAM COLOUR SOFFIT", "SOLID BLACK COLOUR SOFFIT", "VENTING PRODUCTS", "FEATHER EDGE CLADDING", "BLACK WINDOW TRIMS & ANGLES", "ROSEWOOD WINDOW TRIMS & ANGLES", "GOLDEN OAK WINDOW TRIMS & ANGLES", "MAHOGHANY WINDOW TRIMS & ANGLES", "WHITE WOODGRAIN WINDOW TRIMS", "IRISH OAK WINDOW TRIMS", "CREAM WINDOW TRIMS", "16MM WHITE BULLNOSE WINDOW BOARD", "WINDOW FITTING ACCESSORIES", "TEMPORARY RAINWATER PIPES", "GUTTERING ACCESSORIES", "FASCIA & SOFFIT ACCESSORIES", "FOAMS & FILLERS", "CLEANERS", "110MM IMITATION CAST IRON SOIL", "WC PAN CONNECTORS", "OVERFLOW SYSTEM", "CONDENSATE DRAINAGE TRAPS", "FLEXIBLE WASTES/ANTI-SYPHON UNITS", "DENTIL MOULDINGS", "MOCK TUDOR TIMBERS", "GALLOWS BRACKETS & CORBELS", "20MM THICK FLAT TUDOR BOARD", "EXTERIOR COVING", "DECORATIVE BARGEBOARDS","DECORATIVE BARGEBOARDS", "DRAINAGE SUNDRIES", "TWINSON DECKING RANGE", "DRY VERGE SYSTEM FOR TILE & SLATE", "UBIFLEX NON LEAD FLASHING", "ROOF COATINGS", "WEATHERING SLATES", "TIMBER FASCIA BACKING", "ROOFING ACCESSORIES", "TORCH ON ROOFING FELT", "STANDARD SCREWS", "MISCELLANEOUS FIXING PRODUCTS", "APPLICATOR TOOLS", "MISCELLANEOUS TOOLS", "CUTTING TOOLS", "MEASURING TOOLS", "FIXING TOOLS"};
  		if(Arrays.asList(subtoProduct).contains(Title)|| (Title.endsWith(" UNDERGROUND")))
  		{
  			ProductPage();
  		} else{
  			SubProductCategories();
  		}
  		
  	}
  	
  	
  	public static void SubProductCategories() throws InterruptedException, IOException
  	{
  		
  		File file=new File("C://Selenium//jenkindemo//src//objectRepositry//PageObjects");
  		FileInputStream input=new FileInputStream(file);
  		Properties prop= new Properties();
  		prop.load(input);
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("ProductMainList"))));
  		WebElement subproduct=dr.findElement(By.xpath(prop.getProperty("ProductMainList")));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("div"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n)+1;
  		String Str3=prop.getProperty("String3");
  		String Str4=prop.getProperty("String4");
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		ScreenCapture();
  		WebElement SProdcutTile = dr.findElement(By.xpath(prop.getProperty("ProdcutTileHeading")));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product sub Category title: "+Title);
  		System.out.print("\n");
  		String[] subcatProduct ={"LIGHT GREY (APPROX RAL 7040)", "16MM BLACK GLOSS MAXI FASCIA BOARDS", "22MM POLYPLUMB", "15MM POLYPLUMB", "SWISH ANTHRACITE GREY RAL 7016 GUTTERING", "ROSEWOOD WOODGRAIN SHIPLAP", "150MM HALF ROUND STEEL GUTTER (BLACK COATED)", "32MM WHITE PUSHFIT WASTE", "CARBONISED RANGE", "V GROOVE ROSEWOOD WOODGRAIN", "9MM BLACK GLOSS CAPPING FASCIA BOARD", "SURFACE DRAINAGE", "65MM CAST IRON EFFECT SQUARE PIPE", "WHITE SHIPLAP", "BLACK WOODGRAIN SHIPLAP", "ACCESS FITTINGS", "100MM X 75MM CAST IRON EFFECT RECTANGULAR PIPE", "ROOM LINER WALL CLADDING", "375MM WIDE MARBREX WALL PANELS", "CAST IRON EFFECT HOPPER HEADS", "V GROOVE MAHOGANY WOODGRAIN", "BUDGET SILICONES", "16MM BLACK MAXI FASCIA BOARD", "WHITE WINDOW TRIMS", "ONE METRE WIDE NEPTUNE MEGA PANELS", "PIPE & FITTINGS", "9MM IRISH OAK PLAIN SOFFITS", "M-BOSS FASCIA (ANTHRACITE)", "V GROOVE GOLDEN OAK WOODGRAIN", "9MM IRISH OAK CAPPING FASCIA", "9MM MAHOGANY PLAIN SOFFITS", "CAST ALUMINIUM ORNAMENTAL HOPPER HEADS", "MAHOGANY WOODGRAIN SHIPLAP", "250MM WIDE MARBREX WALL PANELS", "CARTRIDGE GLUE PRODUCTS", "GALE GREY (APPROX RAL 7016)", "STANDARD HALF ROUND", "MODERN SQUARELINE", "VICTORIAN OGEE", "POLYFLOW (DEEP CAPACITY)", "SOVEREIGN MOULDED OGEE", "MINILINE (FOR SHEDS ETC)", "150MM INDUSTRIAL SIZE", "CAST IRON EFFECT GUTTERING IN UPVC", "POWDER COATED ALUMINIUM GUTTERING", "STANDARD ROUND PIPE 68MM (2.5 INCH)", "STANDARD SQUARE PIPE 65MM", "82MM (3 INCH) ROUND PIPE", "110MM (4 INCH) ROUND PIPE", "68MM ROUND TERRAIN", "75MM SQUARE TERRAIN", "82MM ROUND TERRAIN", "110MM ROUND TERRAIN", "ROUND ALUMINIUM DOWNPIPES", "BROWN 110MM SOIL", "32MM SOLVENT WELD WASTE MUPVC", "32MM GREY SOLVENT WELD WASTE"};
  		if(Arrays.asList(subcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			FinalSubProductCategories();
  		}
  	}
  	
  	
  	public static void FinalSubProductCategories() throws InterruptedException, IOException
  	{
  		
  		File file=new File("C://Selenium//jenkindemo//src//objectRepositry//PageObjects");
  		FileInputStream input=new FileInputStream(file);
  		Properties prop= new Properties();
  		prop.load(input);
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("ProductMainList"))));
  		WebElement subproduct=dr.findElement(By.xpath(prop.getProperty("ProductMainList")));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("div"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n)+1;
  		String Str3=prop.getProperty("String3");
  		String Str4=prop.getProperty("String4");
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		ScreenCapture();
  		WebElement SProdcutTile = dr.findElement(By.xpath(prop.getProperty("ProdcutTileHeading")));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product sub final Category title: "+Title);
  		System.out.print("\n");
  		String[] FIsubcatProduct ={"HALF ROUND", "CAMEL EMBOSSED SHIPLAP", "112MM OGEE CAST GUTTERING", "BLACK RAPIDFLOW", "BLACK STREAMLINE","PUSHFIT /RINGSEAL GREY SOIL","WHITE 62MM SQUARE TERRAIN", "VICTORIAN OGEE", "100MM HALF ROUND CAST GUTTERING","MOULDED NO 46 OG", "125MM X 100MM MOULDED NO 46 LEFTHAND SYSTEM", "BEADED HALF ROUND", "BEADED DEEP FLOW", "CRESCENT", "CORNICHE", "STREAMLINE", "OMEGA"};
  		if(Arrays.asList(FIsubcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			FinalSubProductsubCategories();
  		}
  	}
  	
  	
  	public static void FinalSubProductsubCategories() throws InterruptedException, IOException
  	{
  		
  		File file=new File("C://Selenium//jenkindemo//src//objectRepositry//PageObjects");
  		FileInputStream input=new FileInputStream(file);
  		Properties prop= new Properties();
  		prop.load(input);
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("ProductMainList"))));
  		WebElement subproduct=dr.findElement(By.xpath(prop.getProperty("ProductMainList")));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("div"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n)+1;
  		String Str3=prop.getProperty("String3");
  		String Str4=prop.getProperty("String4");
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		ScreenCapture();
  		WebElement SProdcutTile = dr.findElement(By.xpath(prop.getProperty("ProdcutTileHeading")));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product Final Category title: "+Title);
  		System.out.print("\n");
  		String[] FIcatProduct ={"PIPES, BENDS, CONNECTORS & BOSS PIPES", "GRAPHITE GREY 7024 HI-CAP GUTTER", "BROWN 65MM SQUARE PIPE", "BLACK XTRAFLO GUTTER SYSTEM", "BROWN RAPIDFLOW GUTTERS", "BRANCHES & ACCESS FITTINGS", "ADAPTORS & REDUCERS", "BRACKETRY & CLIPS"};
  		if(Arrays.asList(FIcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			EndofFuntion();
  		}
  	}
  	
  
  	public static void ProductPage() throws InterruptedException, IOException
  	{
  		File file=new File("C://Selenium//jenkindemo//src//objectRepositry//PageObjects");
  		FileInputStream input=new FileInputStream(file);
  		Properties prop= new Properties();
  		prop.load(input);
  		WebDriverWait Productload = new WebDriverWait(dr, 25);
  		Productload.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(prop.getProperty("ProductMainList"))));
  		WebElement proList = dr.findElement(By.xpath(prop.getProperty("ProductMainList")));
  		List<WebElement> Products=new ArrayList<WebElement>();
  		Products=proList.findElements(By.tagName("figure"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=Products.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n);
  		int r=rval;
  		String Str5=prop.getProperty("ADDtoCartSelect");
		String Str6=prop.getProperty("ADDtoCart");
		String Str7=prop.getProperty("ProductName");
		String Str8=prop.getProperty("ProductPrice");
		WebElement ProductName= dr.findElement(By.xpath(Str5+r+Str7));
		ItemName=ProductName.getText();
		ItemName = ItemName.replaceAll("[\r\n]+", " ");
		System.out.println("The Selected product name is: "+ItemName);
		WebElement ProductPrice= dr.findElement(By.xpath(Str5+r+Str8));
		ItemPrice=ProductPrice.getText();
		System.out.println("The Selected product Price is: "+ItemPrice);
		WebDriverWait waitForBuy = new WebDriverWait(dr,50);
		waitForBuy.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Str5+r+Str7)));
		dr.findElement(By.xpath(Str5+r+Str6)).click();
		ScreenCapture();
		CheckoutFunction();
		
  	}

		public static void CheckoutFunction() throws IOException{
		String PS=dr.getPageSource();
		
		if((PS.contains(ItemName))){
			System.out.print("********************************************************\n");
	  		System.out.print("\tProduct details in the Checkout page is Correct\n");
	  		System.out.print("********************************************************\n");
		} else {
			System.out.print("********************************************************\n");
			System.out.println("\tProduct details are Incorrect");
			System.out.print("********************************************************\n");
		}
		
  	}
		
		public static void ScreenCapture() throws IOException{
			File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			String filename="Screenshot"+System.currentTimeMillis();
			FileUtils.copyFile(scrFile, new File("c:\\sel_screen\\"+filename+".png"));
		}
		
  	@AfterMethod
  	public static void EndofFuntion(){
  		
//	dr.quit();
  	}
}
