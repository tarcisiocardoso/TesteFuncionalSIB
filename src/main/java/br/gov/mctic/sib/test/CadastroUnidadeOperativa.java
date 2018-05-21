package br.gov.mctic.sib.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroUnidadeOperativa {
	public static WebDriver driver = null;
	public static Actions builder = null;
	public static WebElement element = null;
	public static final int tempo = 300;

	public static void main(String[] args) {
		init();

		try {
			login();
			
			instituicaoNaoCadastrada();

			addUnidadeOperativa();

			// sair();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void init() {
		System.setProperty("webdriver.chrome.driver", "/home/tarcisio/trabalho/java/selenium/chromedriver");
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
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.out.println("FirefoxDriver não encontrado. Siga isntruções do projeto para executar o teste");
				System.exit(-1);

				// System.out.println("Dessa forma a execuão dos teste ocorrerá em segundo
				// plano");
				// driver = new HtmlUnitDriver();

			}
		}
//		driver.manage().window().maximize();
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

		driver.get("http://localhost:8092/sib/private/solicitacao-cqb/inserir");

		Thread.sleep(tempo);
		builder = new Actions(driver);

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.id("cnpj")) != null;
			}
		});

	}

	private static void addUnidadeOperativa() throws Exception {

		//element = driver.findElement(By.className("md-stepper-indicator ng-scope md-active"));
		
		Thread.sleep(tempo);
		element = driver.findElement(By.name("btn_proximo"));
		Thread.sleep(tempo);
		element.click();
		element.sendKeys(Keys.TAB);
		
		Thread.sleep(tempo);
		element = driver.findElement(By.name("btn_proximo"));
		element.click();
		element.sendKeys(Keys.TAB);
		
		
		Thread.sleep(tempo);
		element = driver.findElement(By.id("cadastroUnidade"));
		System.out.println( element.getTagName() );
		Thread.sleep(tempo);
		element.click();
		Thread.sleep(tempo);
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.name("nomeUnidade")).getText() != null;
			}
		});

		
		element = driver.findElement(By.name("nomeUnidade"));
		element.sendKeys("teste autoatico cadadastro unidade");
		Thread.sleep(tempo);
		
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys("Descrição teste teste automatico unidade").build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);

		builder.sendKeys("unidade@gmail.com").build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys("unidade@gmail.com").build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);

		builder.sendKeys("(11) 11111-1111").build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
				
		builder.sendKeys("(22) 22222-2222").build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys("73.805-125").build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		
		
		builder.sendKeys("11111111").build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys("11111111").build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys("SSP").build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		
		builder.sendKeys("GO").build().perform(); Thread.sleep(tempo);
		builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		
		
		List<WebElement> itens = driver.findElements(By.xpath("(//button[@class='md-stepper-indicator ng-scope'])"));// driver.findElement(By.name("codigoPostal"));
		System.out.println("==================");
		for (WebElement e: itens) {
			System.out.println(e.getText());
			if( e.getText().indexOf('2')>= 0 ) {
				e.click();
				Thread.sleep(tempo);
				break;
			}
		}
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.name("nomeUnidade")).getText() != null;
			}
		});
		

		
		
		/*
		 * element = driver.findElement(By.name("cnpj"));
		 * element.sendKeys("25.044.174/0001-87"); element.sendKeys(Keys.TAB);
		 * 
		 * Thread.sleep(tempo); (new WebDriverWait(driver, 10)).until(new
		 * ExpectedCondition<Boolean>() { public Boolean apply(WebDriver d) { return
		 * !d.findElement(By.name("razaoSocial")).getAttribute("value").isEmpty(); } });
		 * 
		 * element =
		 * driver.findElement(By.name("contatoInstituicaoemailInstitucional")); //
		 * Thread.sleep(tempo); element.sendKeys("sib_inst_nao_cadastrada@gmail.com");
		 * Thread.sleep(tempo); element.sendKeys(Keys.ENTER); Thread.sleep(tempo);
		 * 
		 * 
		 * builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		 * builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		 * builder.sendKeys("(11) 11111-1111").build().perform(); Thread.sleep(tempo);
		 * builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		 * builder.sendKeys("(22) 22222-2222").build().perform(); Thread.sleep(tempo);
		 * builder.sendKeys(Keys.TAB).build().perform(); Thread.sleep(tempo);
		 * 
		 * element = driver.findElement(By.name("contatoInstituicaocomplemento"));
		 * element.sendKeys("complemento inst_nao_cadastrada");
		 * element.sendKeys(Keys.TAB); Thread.sleep(tempo);
		 * 
		 * element = driver.findElement(By.name("responsavelLegalInstituicaocpf"));
		 * element.sendKeys("324.759.368-35"); element.sendKeys(Keys.TAB);
		 * Thread.sleep(tempo); (new WebDriverWait(driver, 10)).until(new
		 * ExpectedCondition<Boolean>() { public Boolean apply(WebDriver d) { return
		 * !d.findElement(By.name("responsavelLegalInstituicaonome")).getAttribute(
		 * "value").isEmpty(); } });
		 */

	}
	private static void instituicaoNaoCadastrada() throws Exception {

		element = driver.findElement(By.name("cnpj"));
		element.sendKeys("25.044.174/0001-87");
		element.sendKeys(Keys.TAB);

		Thread.sleep(tempo);
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return !d.findElement(By.name("razaoSocial")).getAttribute("value").isEmpty();
			}
		});
		
		element = driver.findElement(By.name("contatoInstituicaoemailInstitucional"));
//
		Thread.sleep(tempo);
		element.sendKeys("sib_inst_nao_cadastrada@gmail.com");
		Thread.sleep(tempo);
		element.sendKeys(Keys.ENTER);
		Thread.sleep(tempo);


	}


}
