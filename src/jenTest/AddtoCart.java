package jenTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AddtoCart {
 
  	public static WebDriver dr;
  	
  	@BeforeMethod
  	public static void loginIn(){
  		dr = new FirefoxDriver();
  		dr.get("http://beta.angelplastics.co.uk/");
  		dr.manage().window().maximize();
  		dr.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  		dr.findElement(By.id("login_username")).sendKeys("kelvin");
  		dr.findElement(By.id("login_password")).sendKeys("123test456");
  		dr.findElement(By.id("remember")).click();
  		dr.findElement(By.id("login")).click();
  	}
  	
  	@Test
  	public static void MainProduct() throws InterruptedException{
  		
  		dr.findElement(By.xpath(".//*[@id='view']/tbody/tr[3]/td[2]/a")).click();
  		List<WebElement> options = dr.findElements(By.xpath("html/body/div[1]/div[3]/div/div[2]/div[1]/div[3]/div/div/div/div[4]/div[1]/div[1]/a"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random();
  		int r=rand.nextInt(n);
  		String Str1="html/body/div[1]/div[3]/div/div[2]/div[1]/div[3]/div/div/div/div[4]/div[1]/div[1]/a[";
  		String Str2="]/div";
  		WebElement Mproduct=dr.findElement(By.xpath(Str1+r+Str2));
  		Mproduct.click();
  		WebElement ProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=ProdcutTile.getText();
  		System.out.print("Main Product title: "+Title);
  		System.out.print("\n");
  		if(Title.equalsIgnoreCase("Terrain Roof & Balcony Outlets")){
  			ProductPage();
  		} else{
  			SubProduct();
  		}
  		
  		
  	}
  	
  
  	public static void SubProduct() throws InterruptedException{
  		
  		List<WebElement> options = dr.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a"));
  		int n=options.size();
  		Random rand= new Random();
  		int rval=rand.nextInt(n);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=SProdcutTile.getText();
  		System.out.print("Product Category title: "+Title);
  		System.out.print("\n");
  		String[] subtoProduct ={"Solid Brown Colour Soffit", "20mm Thick Flat Tudor Board", "Solid Cream Colour Soffit", "Solid Black Colour Soffit", "Venting Products", "Feather Edge Cladding", "Black Window Trims & Angles", "Rosewood Window Trims & Angles", "Golden Oak Window Trims & Angles", "Mahoghany Window Trims & Angles", "White Woodgrain Window Trims", "Irish Oak Window Trims", "Cream Window Trims", "16mm White Bullnose Window Board", "Window Fitting Accessories","Temporary Rainwater Pipes", "Guttering Accessories", "Fascia & Soffit Accessories", "Foams & Fillers", "Cleaners", "110mm Imitation Cast Iron Soil", "WC Pan Connectors", "Overflow System", "Condensate Drainage Traps", "Flexible Wastes/Anti-Syphon Units", "Dentil Mouldings", "Mock Tudor Timbers", "Gallows Brackets & Corbels", "20mm Thick Flat Tudor Board", "Exterior Coving", "Decorative Bargeboards","Decorative Bargeboards", "Drainage Sundries", "Twinson Decking Range", "Dry Verge System for Tile & Slate", "Ubiflex Non Lead Flashing", "Flashband Materials", "Roof Coatings", "Weathering Slates", "Timber Fascia Backing", "Roofing Accessories", "Torch On Roofing Felt", "Polytop Fixings", "Standard Screws", "Miscellaneous Fixing Products", "Applicator Tools", "Miscellaneous Tools", "Cutting Tools", "Measuring Tools", "Fixing Tools"};
  		if(Arrays.asList(subtoProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			SubProductCategories();
  		}
  		
  	}
  	
  	
  	public static void SubProductCategories() throws InterruptedException{
  		
  		List<WebElement> options = dr.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a"));
  		TimeUnit.SECONDS.sleep(2);
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement SIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=SIProdcutTile.getText();
  		System.out.print("Product Sub Category title: "+Title);
  		System.out.print("\n");
  		String[] subcatProduct ={"Light Grey (approx RAL 7040)", "Hazy Grey (approx RAL 7046)", "Gale Grey (approx RAL 7016)", "Double Shiplap Embossed Cladding", "Featheredge Embossed Siding", "V Groove Embossed Cladding", "Standard Half Round", "Modern Squareline", "Victorian Ogee", "Polyflow (deep capacity)", "Sovereign Moulded Ogee", "Miniline (for sheds etc)", "150mm Industrial Size", "Cast Iron Effect Guttering in upvc", "Powder Coated Aluminium Guttering", "Terrain (Premium Upvc Range)", "Standard Round Pipe 68mm (2.5 inch)", "Standard Square Pipe 65mm", "82mm (3 inch) Round Pipe", "110mm (4 inch) Round Pipe", "68mm Round Terrain", "75mm Square Terrain", "82mm Round Terrain", "110mm Round Terrain", "Round Aluminium Downpipes", "Square & Rectangular Aluminium Downpipes", "Black 110mm Soil", "Grey 110mm Soil", "Brown 110mm Soil", "Black 82mm Soil", "Grey 82mm Soil", "32mm Solvent Weld Waste MuPVC", "32mm Grey Solvent Weld Waste", "40mm Solvent Weld Waste MuPVC"};
  		if(Arrays.asList(subcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			FinalSubProductCategories();
  		}
  	}
  	
  	
  	public static void FinalSubProductCategories(){
  		
  		List<WebElement> options = dr.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a"));
  		int n=options.size();
  		Random rand= new Random(System.currentTimeMillis());
  		int rval=rand.nextInt(n);
  		String Str3="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[8]/div[2]/div/a[";
  		String Str4="]/div";
  		WebElement Sproduct=dr.findElement(By.xpath(Str3+rval+Str4));
  		Sproduct.click();
  		WebElement FSIProdcutTile = dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[1]/div/h1"));
  		String Title=FSIProdcutTile.getText();
  		System.out.print("Product Final Sub Category title: "+Title);
  		System.out.print("\n");
  		String[] FIsubcatProduct ={"Half Round", "Victorian Ogee", "Moulded No 46 OG", "Beaded Half Round", "Beaded Deep Flow", "Crescent", "Corniche", "Rapidflow", "Streamline", "Omega", "Pushfit / Ringseal Black Soil", "Solvent Weld Black Soil", "Pushfit /Ringseal Grey Soil", "Solvent Weld Grey Soil", "Pushfit /Ringseal Brown Soil"};
  		if(Arrays.asList(FIsubcatProduct).contains(Title))
  		{
  			ProductPage();
  		} else{
  			EndofFuntion();
  		}
  	}
  	
  	
  	
  	
  	public static void ProductPage(){
  		
  		List<WebElement> Products = dr.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div"));
  		int n=Products.size();
  		System.out.println("Total number of products in the Page: "+n);
  		for(int i=1; i<=n; i++)
  		{
  			int[] a={3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
  			if(Arrays.asList(a).contains(i)){
  				break;
  			} else{
  			String Str5="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div[";
  			String Str6="]/div/div[2]/div[2]/div[3]/input";
  			Random num = new Random();
  			int value=num.nextInt(100)+1;
  			dr.findElement(By.xpath(Str5+i+Str6)).sendKeys(""+value);
  			String Str7="]/div/div[2]/div[4]/a";
  			dr.findElement(By.xpath(Str5+i+Str7)).click();
  			String Str8="html/body/div[1]/div[3]/div[1]/div[2]/div/div[3]/div[1]/div/div/div[4]/div[5]/div[2]/div[";
  			String Str9="]/div/h2";
  			WebElement ProductName= dr.findElement(By.xpath(Str8+i+Str9));
  			String ItemName=ProductName.getText();
  			System.out.println("The Selected product name is: "+ItemName);
//  			dr.switchTo().frame(0);
  			dr.findElement(By.xpath(".//*[@id='popup_ok']")).click();
  			}
  			
  		}
  		dr.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div[2]/div/div[1]/div[7]/ul/li[7]")).click();
  		
  		
  	}
  	
  	
  	public static void EndofFuntion(){
  		
  		dr.quit();
  	}
  	
  	
  	


}
