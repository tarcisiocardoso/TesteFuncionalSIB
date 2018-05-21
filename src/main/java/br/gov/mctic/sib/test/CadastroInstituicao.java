package br.gov.mctic.sib.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroInstituicao {

	public static WebDriver driver = null;
	public static Actions builder = null;
	public static WebElement element = null;
	public static final int tempo = 300;

	public static void main(String[] args) {
		init();

		try {
			login();

			instituicao();

			responsavelLegal();

			// sair();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void init() {
		// System.setProperty("webdriver.chrome.driver", "/home/tarcisio/trabalho/java/selenium/chromedriver");
		if (System.getProperty("webdriver.chrome.driver") != null) {
			try {
				driver = new ChromeDriver();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.out.println("ChormeDriver não encontrado, usando o FirefoxDriver");
				System.clearProperty("webdriver.chrome.driver");
				init();
			}
		} else {
			try {
				driver = new FirefoxDriver();
			}catch( Exception e) {
				System.err.println(e.getMessage());
				System.out.println("FirefoxDriver não encontrado. Siga isntruções do projeto para executar o teste");
				System.exit(-1);
				
				//System.out.println("Dessa forma a execuão dos teste ocorrerá em segundo plano");
				//driver = new HtmlUnitDriver();
				
			}
		}
		driver.manage().window().maximize();
	}

	private static void responsavelLegal() throws Exception {
		// element.submit();

		// builder..sendKeys("perto de algum lugar").build().perform();

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(tempo);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		StringBuilder sb = new StringBuilder();
		sb.append("angular.element(document.querySelector('sib-campo-foto')).controller().responsavelLegal.foto='data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAHElEQVQI12P4//8/w38GIAXDIBKE0DHxgljNBAAO9TXL0Y4OHwAAAABJRU5ErkJggg=='");
		js.executeScript(sb.toString());
		
		
		
		//
		element = driver.findElement(By.xpath("(//input[@name='cpf'])[1]"));// driver.findElement(By.name("codigoPostal"));
		System.out.println(element.getText());

		element.sendKeys("324.759.368-35");
		element.sendKeys(Keys.TAB);

		// System.out.println("-->"+driver.findElement(By.name("nome")).getAttribute("value")
		// );
		// List<WebElement> inputs = driver.findElements(By.xpath("//input"));
		// for (WebElement e : inputs) {
		// System.out.println( e.getAttribute("name")+ ": "+e.getAttribute("value") );
		// }

		Thread.sleep(tempo);
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return !driver.findElement(By.name("nome")).getAttribute("value").isEmpty();
			}
		});

		builder.sendKeys(Keys.TAB).build().perform();

		builder.sendKeys("121212121").build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("SSP").build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("GO").build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("fe").build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("marta@gmail.com").build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("marta@gmail.com").build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("(11) 11111-1111").build().perform();
		Thread.sleep(tempo);

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("(22) 22222-2222").build().perform();
		Thread.sleep(tempo);

	}

	private static void sair() throws Exception {
		System.out.println("nome da pagina" + driver.getTitle());

		Thread.sleep(tempo);
		driver.quit();
	}

	private static void instituicao() throws Exception {

		element = driver.findElement(By.id("cnpj"));
		element.sendKeys("60.409.075/0305-74");
		element.sendKeys(Keys.TAB);

		Thread.sleep(tempo);
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return !d.findElement(By.id("razaoSocial")).getAttribute("value").isEmpty();
			}
		});

		element = driver.findElement(By.name("tipo"));
		System.out.println(element.getText());

		Thread.sleep(tempo);
		element.sendKeys("P");
		Thread.sleep(tempo);
		// element.sendKeys(Keys.ENTER);
		// Thread.sleep(tempo);

		element = driver.findElement(By.name("noComercial"));
		element.sendKeys("Teste automatizado");
		Thread.sleep(tempo);
		element = driver.findElement(By.name("emailAcesso"));
		element.sendKeys("teste@gmail.com");
		Thread.sleep(tempo);
		element = driver.findElement(By.name("confirmarEmail"));
		element.sendKeys("teste@gmail.com");
		Thread.sleep(tempo);

		element = driver.findElement(By.name("telefone1"));
		element.sendKeys("(11) 11111-1111");
		Thread.sleep(tempo);
		element = driver.findElement(By.name("telefone2"));
		element.sendKeys("(11) 11111-2222");
		Thread.sleep(tempo);

		//element = driver.findElement(By.xpath("(.//*[@name='cep'])[2]"));// driver.findElement(By.name("codigoPostal"));
		element = driver.findElement(By.name("cep"));// driver.findElement(By.name("codigoPostal"));
		element.sendKeys("73.805-125");
		element.sendKeys(Keys.TAB );
		Thread.sleep(tempo);
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println("--->" + d.findElement(By.xpath("(//input[@name='bairro'])[2]")).getAttribute("value") );
				return !d.findElement(By.xpath("(//input[@name='bairro'])[2]")).getAttribute("value").isEmpty();
			}
		});

		builder.sendKeys("304").build().perform();

		builder.sendKeys(Keys.TAB).build().perform();
		builder.sendKeys("perto de algum lugar").build().perform();

		Thread.sleep(tempo);

	}

	public static void login() throws Exception {

		driver.get("http://localhost:8080/sib-backend/rest/usuario/autenticado");

		Thread.sleep(300);

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.name("username")) != null;
			}
		});

		// Find the text input element by its name
		element = driver.findElement(By.name("username"));

		element.sendKeys("marta.costa");
		element = driver.findElement(By.name("password"));
		Thread.sleep(tempo);
		element.sendKeys("Mctic@321");

		Thread.sleep(tempo);

		element.submit();

		String fonte = driver.findElement(By.tagName("pre")).getText();
		System.out.println(fonte);

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.tagName("pre")).getText() != null;
			}
		});

		driver.get("http://localhost:8092/sib/private/manter-instituicao/cadastrar-instituicao");

		Thread.sleep(tempo);
		builder = new Actions(driver);

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("cnpj")) != null;
			}
		});

	}
}
