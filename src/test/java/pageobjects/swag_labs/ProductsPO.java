package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;
import static utils.Utils.sleep;

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
    public void addProduct(String product){
        getProduct(product).findElement(By.tagName("button")).click();
    }
    public void validateAddCartText(String product, String text){
        sleep(2);
        String textProduct = getProduct(product).findElement(By.tagName("button")).getText();
        appendToReportElementHighlight(getProduct(product).findElement(By.tagName("button")));
        Assert.assertEquals(text, textProduct);
    }
}
