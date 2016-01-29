package jenTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Updated_AddtoCart {
 
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
  	public static void MainProduct() throws InterruptedException
  	{
  		System.out.print("********************************************************\n");
  		System.out.print("\tWelcome to Angel Plastics site\n");
  		System.out.print("********************************************************\n");
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[2]/div/div/section/section/ul")));
  		WebElement productlist=dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/section/ul"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =productlist.findElements(By.tagName("li"));
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int r=rand.nextInt(n);
  		String Str1="html/body/div[1]/div[2]/div/div/section/section/ul/li[";
  		String Str2="]/div/figure/a/img";
  		WebElement Mproduct=dr.findElement(By.xpath(Str1+r+Str2));
  		Mproduct.click();
  		WebElement ProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
  		String Title=ProdcutTile.getText();
  		System.out.print("Scenario : We are going to add product to cart by randomly selecting a product\n");
  		System.out.print("Main Product title: "+Title);
  		System.out.print("\n");
  		String[] DircetProductpage={"HOT & COLD PLUMBING SYSTEMS", "TERRAIN ROOF & BALCONY OUTLETS", "WATER BUTTS & ACCESSORIES"};
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
  	
  	public static void PlumbingWaste() throws InterruptedException
  	{
  		
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("li"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n+1);
  		String Str3="html/body/div[1]/div[2]/div/div/section/nav/ul/li[";
  		String Str4="]/a";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product Category title: "+Title);
  		System.out.print("\n");
  		String[] subtoProduct ={"WC Pan Connectors", "Overflow System", "Condensate Drainage Traps", "Flexible Wastes/Anti-Syphon Units"};
  		if(Arrays.asList(subtoProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			SubProductCategories();
  		}
  		
  	}
  	
  	
  
  	public static void SubProduct() throws InterruptedException
  	{
  		
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("li"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n+1);
  		String Str3="html/body/div[1]/div[2]/div/div/section/nav/ul/li[";
  		String Str4="]/a";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product Category title: "+Title);
  		System.out.print("\n");
  		String[] subtoProduct ={"Solid Brown Colour Soffit", "Millboard Decking", "GROUND GUARD LAWN PAVING TILE", "Fascia & Soffit Accessories", "Polytop Fixings" , "Pipe & Fittings", "375mm Wide Marbrex Wall Panels", "Universal Compression Waste", "Waste Traps", "Rosewood Fascia", "20mm Thick Flat Tudor Board", "Polystorm Modular Water Storage", "Solid Cream Colour Soffit", "Solid Black Colour Soffit", "Venting Products", "Feather Edge Cladding", "Black Window Trims & Angles", "Rosewood Window Trims & Angles", "Golden Oak Window Trims & Angles", "Mahoghany Window Trims & Angles", "White Woodgrain Window Trims", "Irish Oak Window Trims", "Cream Window Trims", "16mm White Bullnose Window Board", "Window Fitting Accessories", "Temporary Rainwater Pipes", "Guttering Accessories", "Fascia & Soffit Accessories", "Foams & Fillers", "Cleaners", "110mm Imitation Cast Iron Soil", "WC Pan Connectors", "Overflow System", "Condensate Drainage Traps", "Flexible Wastes/Anti-Syphon Units", "Dentil Mouldings", "Mock Tudor Timbers", "Gallows Brackets & Corbels", "20mm Thick Flat Tudor Board", "Exterior Coving", "Decorative Bargeboards","Decorative Bargeboards", "Drainage Sundries", "Twinson Decking Range", "Dry Verge System for Tile & Slate", "Ubiflex Non Lead Flashing", "Flashband Materials", "Roof Coatings", "Weathering Slates", "Timber Fascia Backing", "Roofing Accessories", "Torch On Roofing Felt", "Standard Screws", "Miscellaneous Fixing Products", "Applicator Tools", "MISCELLANEOUS TOOLS", "Cutting Tools", "Measuring Tools", "Fixing Tools"};
  		if(Arrays.asList(subtoProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			SubProductCategories();
  		}
  		
  	}
  	
  	
  	public static void SubProductCategories() throws InterruptedException
  	{
  		
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("li"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n+1);
  		String Str3="html/body/div[1]/div[2]/div/div/section/nav/ul/li[";
  		String Str4="]/a";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
  		String Title=SIProdcutTile.getText();
  		System.out.print("Product Sub Category title: "+Title);
  		System.out.print("\n");
  		String[] subcatProduct ={"Light Grey (approx RAL 7040)", "CARBONISED RANGE", "V Groove Rosewood Woodgrain", "9MM BLACK GLOSS CAPPING FASCIA BOARD", "Surface Drainage", "65mm Cast Iron Effect Square Pipe", "White Shiplap", "Black Woodgrain Shiplap", "Super Glue Products", "Access Fittings", "100mm x 75mm Cast Iron Effect Rectangular Pipe", "Room Liner Wall Cladding", "375mm Wide Marbrex Wall Panels", "Cast Iron Effect Hopper Heads", "V Groove Mahogany Woodgrain", "Budget Silicones", "16mm Black Maxi Fascia Board", "White Window Trims", "One Metre Wide Neptune Mega Panels", "Pipe & Fittings", "9mm Irish Oak Plain Soffits", "M-Boss Fascia (anthracite)", "V Groove Golden Oak Woodgrain", "9mm Irish Oak Capping Fascia", "9mm Mahogany Plain Soffits", "Cast Aluminium Ornamental Hopper Heads", "Mahogany Woodgrain Shiplap", "250mm Wide Marbrex Wall Panels", "Cartridge Glue Products", "Gale Grey (approx RAL 7016)", "V Groove Embossed Cladding", "Standard Half Round", "Modern Squareline", "Victorian Ogee", "Polyflow (deep capacity)", "Sovereign Moulded Ogee", "Miniline (for sheds etc)", "150mm Industrial Size", "Cast Iron Effect Guttering in upvc", "Powder Coated Aluminium Guttering", "Standard Round Pipe 68mm (2.5 inch)", "Standard Square Pipe 65mm", "82mm (3 inch) Round Pipe", "110mm (4 inch) Round Pipe", "68mm Round Terrain", "75mm Square Terrain", "82mm Round Terrain", "110mm Round Terrain", "Round Aluminium Downpipes", "Square & Rectangular Aluminium Downpipes", "Brown 110mm Soil", "32mm Solvent Weld Waste MuPVC", "32mm Grey Solvent Weld Waste"};
  		if(Arrays.asList(subcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			FinalSubProductCategories();
  		}
  	}
  	
  	
  	public static void FinalSubProductCategories() throws InterruptedException
  	{
  		
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("li"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n+1);
  		String Str3="html/body/div[1]/div[2]/div/div/section/nav/ul/li[";
  		String Str4="]/a";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement FSIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
  		String Title=FSIProdcutTile.getText();
  		System.out.print("Product Final Sub Category title: "+Title);
  		System.out.print("\n");
  		String[] FIsubcatProduct ={"Half Round", "Camel Embossed Shiplap", "Black Rapidflow", "Black Streamline","Pushfit /Ringseal Grey Soil","White 62mm Square Terrain", "Victorian Ogee", "100mm Half Round Cast Guttering","Moulded No 46 OG", "125mm x 100mm Moulded No 46 Lefthand System", "Beaded Half Round", "Beaded Deep Flow", "Crescent", "Corniche", "Streamline", "Omega"};
  		if(Arrays.asList(FIsubcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			FinalSubProductsubCategories();
  		}
  	}
  	
  	
  	public static void FinalSubProductsubCategories() throws InterruptedException
  	{
  		
  		WebDriverWait SubProduct = new WebDriverWait(dr, 25);
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/nav/ul"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("li"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n+1);
  		String Str3="html/body/div[1]/div[2]/div/div/section/nav/ul/li[";
  		String Str4="]/a";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement FSIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/h2"));
  		String Title=FSIProdcutTile.getText();
  		System.out.print("Product Final Category title: "+Title);
  		System.out.print("\n");
  		String[] FIcatProduct ={"Pipes, Bends, Connectors & Boss Pipes", "BROWN RAPIDFLOW GUTTERS", "Branches & Access Fittings", "Adaptors & Reducers", "Bracketry & Clips"};
  		if(Arrays.asList(FIcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			EndofFuntion();
  		}
  	}
  	
  
  	public static void ProductPage() throws InterruptedException
  	{
  		
  		WebDriverWait Productload = new WebDriverWait(dr, 25);
  		Productload.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[2]/div/div/section/section")));
  		WebElement proList = dr.findElement(By.xpath("html/body/div[1]/div[2]/div/div/section/section"));
  		List<WebElement> Products=new ArrayList<WebElement>();
  		Products=proList.findElements(By.className("products_container list_type clearfix m_bottom_5 m_left_0 m_right_0 isotope"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=Products.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n);
  		int r=rval;
  		String Str5="html/body/div[1]/div[2]/div/div/section/section";
		String Str6="]/div/figure/figcaption/div/div[2]/input";
		dr.findElement(By.xpath(Str5+r+Str6)).click();
		String Str7="]/div/figure/figcaption/div/div[1]/h4/a";
		String Str8="]/div/figure/figcaption/div/div[2]/p/span";
		WebElement ProductName= dr.findElement(By.xpath(Str5+r+Str7));
		ItemName=ProductName.getText();
		System.out.println("The Selected product name is: "+ItemName);
		WebElement ProductPrice= dr.findElement(By.xpath(Str5+r+Str8));
		ItemPrice=ProductPrice.getText();
		WebDriverWait waitForBuy = new WebDriverWait(dr,50);
		waitForBuy.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Str5+r+Str7)));
		dr.findElement(By.xpath(Str5+r+Str7)).click();
		CheckoutFunction();
			
  	}

		public static void CheckoutFunction(){
		String PS=dr.getPageSource();
		if((PS.contains(ItemName))){
			System.out.print("********************************************************\n");
	  		System.out.print("\tProduct details in the Checkout page is Correct\n");
	  		System.out.print("********************************************************\n");
		} else {
			System.out.print("********************************************************\n");
			System.out.println("Product details are Incorrect");
			System.out.print("********************************************************\n");
		}
		
  	}
  	@AfterMethod
  	public static void EndofFuntion(){
  		
//		dr.quit();
  	}
}
