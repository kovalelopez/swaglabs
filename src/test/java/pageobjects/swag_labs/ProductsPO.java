package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class ProductsPO {

    public void validateList() {
        appendToReportElementHighlight(getElement(By.className("inventory_list")));
        Assert.assertTrue(getElement(By.className("inventory_list")).isDisplayed(),
                "A lista de produtos não foi carregada");
    }

    public int countProducts(){
        return getDriver().findElements(By.className("inventory_item")).size();
    }

    public void validateProductsQuantity(int size){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        appendToReport();
        Assert.assertEquals(size,countProducts(),"A quantidade foi diferente");
    }

    /**
     * @param product - é o produto que será capturado e verificado o valor
     *                Carrego uma lista com os produtos da classe inventory_item
     *                Percorro a lista buscando o nome do produto nos elementos da lista
     *                Eu atribuo o elemento a um WebElement quando o título for correspodente
     * */
    public WebElement getProduct(String product) {
        WebElement list = getElement(By.className("inventory_list"));
        List<WebElement> products = list.findElements(By.className("inventory_item"));
        WebElement item = null;
        for (WebElement p:products
             ) {
            if (p.getText().contains(product)) {
                item = p;
                break;
            }
        }
        /*
        * Caso o produto não seja encontrado, o WebElement permanecerá nulo. Dessa forma,
        * a execução será interrompida por meio da instrução abaixo.
        * */
        Assert.assertNotNull(item, "O produto " +product+ " não foi encontrado");
        return item;
    }

    /**
     * @param product - produto que deve ser capturado o preço
     *                Chamo o método getProduct que retorna elemento produto
     *                Dentro do elemento é realizado um findElement() na classe inventory_item_price
     *                O valor do preço é atribuído a uma String price e retornado
     * */
    public String getPrice(String product) {
        WebElement item = getProduct(product);
        String price = item.findElement(By.className("inventory_item_price")).getText();
        return price;
    }

    public List<String> getPrices(List<String> products) {
        List<String> prices = new ArrayList<>();
        for (String product:products
             ) {
            prices.add(getPrice(product));
        }
        return prices;
    }

    /**
     * @param product
     * @param price - preço a ser comparado que foi informado na feature
     *              Chamo o método que retorna o preço de um elemento
     *              A validação preço capturado no produto é comparada com o preço passado por parâmetro
     * */
    public void validatePriceProduct(String price, String product) {
        appendToReportElementHighlight(getProduct(product));
        String productPrice = getPrice(product);
        Assert.assertTrue(productPrice.contains(price), "Os preços estão divergentes");
    }
    public void addProduct(){
        elementClick(By.xpath("//*[contains(text(),'Add to cart')]"));
    }
    public void addProducts(List<String> products) {
        for (String product:products
        ) {
            WebElement p = getProduct(product);
            p.findElement(By.tagName("button")).click();
        }
    }
    public void validateAddCartText(String product, String text){
        sleep(2);
        String textProduct = getProduct(product).findElement(By.tagName("button")).getText();
        appendToReportElementHighlight(getProduct(product).findElement(By.tagName("button")));
        Assert.assertEquals(text, textProduct);
    }

    public void accessCart() {
        elementClick(By.id("shopping_cart_container"));
    }

    public WebElement getProductComponent(String product, By by) {
        WebElement productComponent = getProduct(product).findElement(by);
        return productComponent;
    }
    public void accessProductDescription(String product) {
        sleep(1);
        WebElement component = getProductComponent(product, By.className("inventory_item_name"));
        component.click();
        appendToReport();
    }
}
