package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PopularItemsPage;
import utils.PageTitleUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseTest {

    private PopularItemsPage popularItemsPage;

    // przed kazdym testem
    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);
        popularItemsPage= new PopularItemsPage(driver);
    }

    @Test
    public void shouldSeeBestSellersItemsOnHomePage() {


        WebElement button = driver.findElement(By.cssSelector("a[class='blockbestsellers']"));
        button.click();

        List<String> productNames = popularItemsPage.getProductNames();

//        List<WebElement> productNames = driver.findElements(By.cssSelector("#blockbestsellers .product-name"));
//        List<WebElement> productNamesByXpath = driver.findElements(By.xpath("//*[@id='homefeatured']//*[@class='product-name']"));

//        List<WebElement> productWithEmptyName = productNames.stream()
//                .filter(el -> el.getText().isEmpty())
//                .collect(Collectors.toList());

        List<String> productsWithEmptyName = productNames.stream()
                .filter(element -> element.isEmpty())
                .collect(Collectors.toList());

        assertThat(productsWithEmptyName).isEmpty();

    }


}
