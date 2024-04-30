package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

//      1. Открой главную страницу веб-сайта интернет-магазина Wildberries: https://www.wildberries.ru/.
        driver.get("https://www.wildberries.ru/");

//      2. Найди поле поиска на странице и введи в него название товара (например, "мобильный телефон").
        WebElement searchField = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchField.click();
        Thread.sleep(1000);

        searchField.sendKeys("мобильный телефон");

//      3. Нажми на кнопку "Поиск" или "Найти".
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='applySearchBtn']"));
        Thread.sleep(1000);
        searchButton.click();
        Thread.sleep(1000);

//      4. В результате поиска выбери первый товар из списка и кликни по нему, чтобы перейти на страницу товара.
        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='product-card-list']/article[1]"));
        Thread.sleep(1000);
        firstProduct.click();
        Thread.sleep(1000);

//      5. Найди и кликни по кнопке "Добавить в корзину".
        WebElement basketButton = driver.findElement(By.xpath("//button[@class='btn-main']"));
        Thread.sleep(1000);
        basketButton.click();
        Thread.sleep(1000);

//      6. Перейди в корзину и проверь, что товар добавился.
        WebElement goBasket = driver.findElement(By.xpath("//a[@class='btn-base j-go-to-basket']"));
        Thread.sleep(1000);
        goBasket.click();
        Thread.sleep(1000);

        WebElement addedProduct = driver.findElement(By.xpath("//div[@class='basket-list__accordion accordion']"));
        if (addedProduct.isDisplayed()) {
            System.out.println("Товар добавлен в корзину");
        }

        driver.quit();
    }
}