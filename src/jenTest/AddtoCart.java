package jenTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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

public class AddtoCart {
 
  	public static WebDriver dr;
  	public static String ItemName, ItemPrice, ItemStockCode;
  	
  	@BeforeMethod
  	public static void loginIn()
  	{
  		dr = new FirefoxDriver();
  		dr.get("http://beta.angelplastics.co.uk/");
  		dr.manage().window().maximize();
  		dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
  		dr.findElement(By.id("login_username")).sendKeys("kelvin");
  		dr.findElement(By.id("login_password")).sendKeys("123asd!@#");
  		dr.findElement(By.id("remember")).click();
  		dr.findElement(By.id("login")).click();
  	}
  	
  	@Test(enabled=true, priority=1)
  	public static void MainProduct() throws InterruptedException
  	{
  		System.out.print("********************************************************\n");
  		System.out.print("\tWelcome to Angel Plastics site\n");
  		System.out.print("********************************************************\n");
  		dr.findElement(By.xpath(".//*[@id='view']/tbody/tr[3]/td[2]/a")).click();
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[1]/div[3]/div/div/div/div[4]/div[1]/div[1]"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("a"));
  		int n=options.size();
  		Random rand= new Random();
  		int r=rand.nextInt(n);
  		String Str1="html/body/div[1]/div[3]/div/div[2]/div[1]/div[3]/div/div/div/div[4]/div[1]/div[1]/a[";
  		String Str2="]/div";
  		WebElement Mproduct=dr.findElement(By.xpath(Str1+r+Str2));
  		Mproduct.click();
  		WebElement ProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=ProdcutTile.getText();
  		System.out.print("Scenario : We are going to add product to cart by randomly selecting a product\n");
  		System.out.print("Main Product title: "+Title);
  		System.out.print("\n");
  		if(Title.equalsIgnoreCase("Terrain Roof & Balcony Outlets"))
  		{
  			ProductPage();
  		} if(Title.equalsIgnoreCase("Garden Decking"))
  		{
  			GardenDECProduct();
  		} if(Title.equalsIgnoreCase("PlumbingWaste")){
  			
  			PlumbingWaste();
  		}
  		else
  		{
  			SubProduct();
  		}
  		
  	}
  	
  	public static void GardenDECProduct() throws InterruptedException
	{
  		
  		WebDriverWait GardenSubProduct = new WebDriverWait(dr, 25);
  		GardenSubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[1]/div")));
  		dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[1]/div")).click();
  		WebElement GSProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=GSProdcutTile.getText();
  		System.out.print("Garden Decking Product Category title: "+Title);
  		System.out.print("\n");
  		WebDriverWait Productload = new WebDriverWait(dr, 25);
  		Productload.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div")));
  		WebElement proList = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]"));
  		List<WebElement> Products=new ArrayList<WebElement>();
  		Products=proList.findElements(By.className("product-details"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=Products.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n);
  		int r=rval;
  		int[] a={0, 1, 4, 7, 10, 13, 16, 19, 22};
		int d=Arrays.binarySearch(a, r);
		String Str5="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div[";
		String Str6="]/div/div[2]/div[2]/div[3]/input";
		String Str7="]/div/div/div[2]/div[2]/div[3]/input";
		if(d>=0)
		{
			r++;
		} 
		else
		{
		Random num = new Random();
		int value=num.nextInt(100)+1;
		int[] b={2, 3, 11, 12, 14};
		int[] c={5, 6, 8, 9, 15, 17, 18};
		if(Arrays.asList(b).contains(r)){
			dr.findElement(By.xpath(Str5+r+Str7)).sendKeys(""+value);
		}
		else if(Arrays.asList(c).contains(r)){
			dr.findElement(By.xpath(Str5+r+Str6)).sendKeys(""+value);
		}
		
		String Str7a="]/div/div[2]/div[4]/a";
		WebDriverWait waitForBuy = new WebDriverWait(dr,50);
		waitForBuy.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Str5+r+Str7a)));
		dr.findElement(By.xpath(Str5+r+Str7)).click();
		String Str8="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div[";
		String Str9="]/div/h2";
		String Str10="]/div/div[2]/div[1]/h3";
		String Str11="]/div/div[2]/div[1]/h5";
		WebElement ProductName= dr.findElement(By.xpath(Str8+r+Str9));
		ItemName=ProductName.getText();
		System.out.println("The Selected product name is: "+ItemName);
		WebElement ProductPrice= dr.findElement(By.xpath(Str8+r+Str10));
		ItemPrice=ProductPrice.getText();
		System.out.println("The Selected product Price is: "+ItemPrice);
		WebElement ProductStockCode= dr.findElement(By.xpath(Str8+r+Str11));
		ItemStockCode=ProductStockCode.getText();
		System.out.println("The Selected product Stock Code is: "+ItemStockCode);
		WebDriverWait wait = new WebDriverWait(dr,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='popup_ok']")));
		dr.findElement(By.xpath(".//*[@id='popup_ok']")).click();
		WebDriverWait ViewCart = new WebDriverWait(dr, 25);
		ViewCart.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/span/a[1]")));
		dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/span/a[1]")).click();
		CheckoutFunction();
		}
 		
  		
  	}

  	public static void PlumbingWaste() throws InterruptedException
  	{
  		
  		WebDriverWait PW = new WebDriverWait(dr, 25);
  		PW.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("a"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n+1);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
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
  		SubProduct.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("a"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n+1);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product Category title: "+Title);
  		System.out.print("\n");
  		String[] subtoProduct ={"Solid Brown Colour Soffit", "Fascia & Soffit Accessories", "Polytop Fixings" , "Pipe & Fittings", "375mm Wide Marbrex Wall Panels", "Universal Compression Waste", "Waste Traps", "Rosewood Fascia", "20mm Thick Flat Tudor Board", "Polystorm Modular Water Storage", "Solid Cream Colour Soffit", "Solid Black Colour Soffit", "Venting Products", "Feather Edge Cladding", "Black Window Trims & Angles", "Rosewood Window Trims & Angles", "Golden Oak Window Trims & Angles", "Mahoghany Window Trims & Angles", "White Woodgrain Window Trims", "Irish Oak Window Trims", "Cream Window Trims", "16mm White Bullnose Window Board", "Window Fitting Accessories", "Temporary Rainwater Pipes", "Guttering Accessories", "Fascia & Soffit Accessories", "Foams & Fillers", "Cleaners", "110mm Imitation Cast Iron Soil", "WC Pan Connectors", "Overflow System", "Condensate Drainage Traps", "Flexible Wastes/Anti-Syphon Units", "Dentil Mouldings", "Mock Tudor Timbers", "Gallows Brackets & Corbels", "20mm Thick Flat Tudor Board", "Exterior Coving", "Decorative Bargeboards", "Decorative Bargeboards", "Drainage Sundries", "Twinson Decking Range", "Dry Verge System for Tile & Slate", "Ubiflex Non Lead Flashing", "Flashband Materials", "Roof Coatings", "Weathering Slates", "Timber Fascia Backing", "Roofing Accessories", "Torch On Roofing Felt", "Standard Screws", "Miscellaneous Fixing Products", "Applicator Tools", "Miscellaneous Tools", "Cutting Tools", "Measuring Tools", "Fixing Tools"};
  		if(Arrays.asList(subtoProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			SubProductCategories();
  		}
  		
  	}
  	
  	
  	public static void SubProductCategories() throws InterruptedException
  	{
  		
  		WebDriverWait SubProductCat = new WebDriverWait(dr, 25);
  		SubProductCat.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("a"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=SIProdcutTile.getText();
  		System.out.print("Product Sub Category title: "+Title);
  		System.out.print("\n");
  		String[] subcatProduct ={"Light Grey (approx RAL 7040)", "160mm Industrial Half Round Range by Brett Martin", "Surface Drainage", "65mm Cast Iron Effect Square Pipe", "White Shiplap", "Black Woodgrain Shiplap", "Super Glue Products", "Access Fittings", "100mm x 75mm Cast Iron Effect Rectangular Pipe", "Room Liner Wall Cladding", "375mm Wide Marbrex Wall Panels", "Cast Iron Effect Hopper Heads", "V Groove Mahogany Woodgrain", "Budget Silicones", "16mm Black Maxi Fascia Board", "White Window Trims", "One Metre Wide Neptune Mega Panels", "Pipe & Fittings", "9mm Irish Oak Plain Soffits", "M-Boss Fascia (anthracite)", "V Groove Golden Oak Woodgrain", "9mm Irish Oak Capping Fascia", "9mm Mahogany Plain Soffits", "Cast Aluminium Ornamental Hopper Heads", "Mahogany Woodgrain Shiplap", "250mm Wide Marbrex Wall Panels", "Cartridge Glue Products", "Gale Grey (approx RAL 7016)", "V Groove Embossed Cladding", "Standard Half Round", "Modern Squareline", "Victorian Ogee", "Polyflow (deep capacity)", "Sovereign Moulded Ogee", "Miniline (for sheds etc)", "150mm Industrial Size", "Cast Iron Effect Guttering in upvc", "Powder Coated Aluminium Guttering", "Standard Round Pipe 68mm (2.5 inch)", "Standard Square Pipe 65mm", "82mm (3 inch) Round Pipe", "110mm (4 inch) Round Pipe", "68mm Round Terrain", "75mm Square Terrain", "82mm Round Terrain", "110mm Round Terrain", "Round Aluminium Downpipes", "Square & Rectangular Aluminium Downpipes", "Brown 110mm Soil", "32mm Solvent Weld Waste MuPVC", "32mm Grey Solvent Weld Waste"};
  		if(Arrays.asList(subcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			FinalSubProductCategories();
  		}
  	}
  	
  	
  	public static void FinalSubProductCategories() throws InterruptedException
  	{
  		
  		WebDriverWait FinalSub = new WebDriverWait(dr, 25);
  		FinalSub.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("a"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement FSIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
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
  		
  		WebDriverWait FinalSub = new WebDriverWait(dr, 25);
  		FinalSub.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a")));
  		WebElement subproduct=dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div"));
  		List<WebElement> options=new ArrayList<WebElement>();
  		options =subproduct.findElements(By.tagName("a"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement FSIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=FSIProdcutTile.getText();
  		System.out.print("Product Final Category title: "+Title);
  		System.out.print("\n");
  		String[] FIcatProduct ={"Pipes, Bends, Connectors & Boss Pipes", "Branches & Access Fittings", "Adaptors & Reducers", "Bracketry & Clips"};
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
  		Productload.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div")));
  		WebElement proList = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]"));
  		List<WebElement> Products=new ArrayList<WebElement>();
  		Products=proList.findElements(By.className("product-details"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=Products.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n);
  		int r=rval;
  		int[] a={0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
		int d=Arrays.binarySearch(a, r);
		if(d>=0)
		{
			r++;
		} 
		else
		{
		String Str5="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div[";
		String Str6="]/div/div[2]/div[2]/div[3]/input";
		Random num = new Random();
		int value=num.nextInt(100)+1;
		dr.findElement(By.xpath(Str5+r+Str6)).sendKeys(""+value);
		String Str7="]/div/div[2]/div[4]/a";
		WebDriverWait waitForBuy = new WebDriverWait(dr,50);
		waitForBuy.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Str5+r+Str7)));
		dr.findElement(By.xpath(Str5+r+Str7)).click();
		String Str8="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div[";
		String Str9="]/div/h2";
		String Str10="]/div/div[2]/div[1]/h3";
		String Str11="]/div/div[2]/div[1]/h5";
		WebElement ProductName= dr.findElement(By.xpath(Str8+r+Str9));
		ItemName=ProductName.getText();
		System.out.println("The Selected product name is: "+ItemName);
		WebElement ProductPrice= dr.findElement(By.xpath(Str8+r+Str10));
		ItemPrice=ProductPrice.getText();
		System.out.println("The Selected product Price is: "+ItemPrice);
		WebElement ProductStockCode= dr.findElement(By.xpath(Str8+r+Str11));
		ItemStockCode=ProductStockCode.getText();
		System.out.println("The Selected product Stock Code is: "+ItemStockCode);
		WebDriverWait wait = new WebDriverWait(dr,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='popup_ok']")));
		dr.findElement(By.xpath(".//*[@id='popup_ok']")).click();
		WebDriverWait ViewCart = new WebDriverWait(dr, 25);
		ViewCart.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/span/a[1]")));
		dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div/span/a[1]")).click();
		CheckoutFunction();
			}
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
		WebDriverWait saveCart = new WebDriverWait(dr, 25);
  		saveCart.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='admin_login_form']/a[2]")));
  		dr.findElement(By.xpath(".//*[@id='admin_login_form']/a[2]")).click();
  		dr.findElement(By.xpath(".//*[@id='header_top']/div[2]/div[2]/div[1]/a")).click();
  	}
  	@AfterMethod
  	public static void EndofFuntion(){
  		
//		dr.quit();
  	}
}
