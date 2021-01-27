package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    /*
    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.google.com");
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Iniciando Pruebas...");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        //assertEquals("HandBook Devops", driver.getTitle());
        assertEquals("HandBook Devops - Buscar con Google", driver.getTitle());
    } */
    @Test
    public void existsBuyAmazon()
    {
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        // identify image
        WebElement l =driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/81B4f4soNAL._AC_UY218_.jpg']"));
        //getAttribute() to get src of image
        System.out.println("Src attribute is: "+ l.getAttribute("src"));
        String attr = l.getAttribute("src");
        //verificar si la imagen existe
        	
		if ( attr == null || attr.equals("")) {	
            System.out.println("No encontrada la imagen");							
        } else {			
           	System.out.println("Imagen Encontrada, hago click");
            l.click();		

            //Buscar el Boton Comprar y la Palabra Disponible
            String disponibleTxT = driver.findElement(By.xpath("//span[@class = 'a-size-medium a-color-success']")).getText();
            System.out.println(disponibleTxT);
            
            if(disponibleTxT.equals("Disponible.")){

                Boolean displayBotonComprar = driver.findElement(By.xpath("//*[@id='buy-now-button']")).isDisplayed();
                if (displayBotonComprar)
                {
                    System.out.println("Se puede comprar , ejecutar futuro click.");
                }
                else
                {
                    System.out.println("No se puede Comprar, falta boton.");
                }
            }else {
                System.out.println("No se puede Comprar, cantidad no disponible.");
            }

        }	

        driver.close(); // Cierra el navegador actual abierto por el Script 
        driver.quit();  // Cierra todas las sesiones abiertas por el Script	

    } 
}
