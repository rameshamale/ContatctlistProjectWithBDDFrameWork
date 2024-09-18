package Pages;

import Definations.Hooks;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Methods {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public Methods(WebDriver driver,WebDriverWait wait, Actions actions) {
        this.driver=driver;
        this.wait = wait;
        this.actions = actions;
    }

    By title = By.className("main-header");

    public WebElement element(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement elementUntillClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clearInputField(By locator) throws InterruptedException {
        WebElement element= element(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element);
        Thread.sleep(1000);
    }


    public List<WebElement> elements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void sendKeys(By locator, String string) {
        element(locator).sendKeys(string);
    }

    public void sendKeysEnter(By locator, String string) {

        sendKeys(locator, string);
        sendKeys(locator, "" + Keys.ENTER);
    }

    public void dateSendKeys(By locator, String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.chord(Keys.CONTROL, "a"), date);
    }

    public void clear(By locator) {
        element(locator).clear();
    }

    public int arrayListToInt(String[] items, String list) {
        return ArrayUtils.indexOf(items, list);
    }

    public void click(By locator) {
        element(locator).click();
    }

    public void clickWithIndex(By locator, int index) {
        elements(locator).get(index).click();
    }

    public String getText(By locator) {
        return element(locator).getText();
    }

    public String getTexts(By locator, int i) {
        return elements(locator).get(i).getText();
    }

    public void clickActionsWithIndex(By locator, int i) {
        actions.click(elements(locator).get(i)).build().perform();
    }

    public void clickActions(By locator) {
        actions.click(element(locator)).build().perform();
    }

    public void doubleClick(By locator) {
        actions.doubleClick(element(locator)).build().perform();
    }

    public void rightClick(By locator) {
        actions.contextClick(element(locator)).build().perform();
    }

    public void moveToElement(By locator) {
        actions.moveToElement(element(locator)).perform();
    }

    public void moveToElements(By locator, int index) {
        actions.moveToElement(elements(locator).get(index)).perform();
    }

    public void javaExecutorScrollIntoView(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element(locator));
    }

    public void javaExecutorClick(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element(locator));
    }

    public String getTitleName() {
        return getText(title);
    }

    /* SELECT_METHODS */
    public Select select(WebElement element) {
        return new Select(element);
    }

    public void selectByVisibleText(By locator, String text) {
        select(element(locator)).selectByVisibleText(text);
    }

    public void selectWithIndex(By locator, int index) {
        select(element(locator)).selectByIndex(index);
    }

    public void selectByValue(By locator, String value) {
        select(element(locator)).selectByValue(value);
    }

    public boolean selectIsMultiple(By locator) {
        select(element(locator)).isMultiple();
        return true;
    }

    public void deselectByValue(By locator, String value) {
        select(element(locator)).deselectByValue(value);
    }

    public void deselectAll(By locator) {
        select(element(locator)).deselectAll();
    }

    public void getOptions(By locator) {
        List<WebElement> option = select(element(locator)).getOptions();
        System.out.println("The options you can choose to select are: ");
        for (WebElement options : option)
            System.out.println(options.getText());
    }

    public void getAllSelectedOptions(By locator) {
        System.out.println("The selected values options are: ");
        List<WebElement> selectedOptions = select(element(locator)).getAllSelectedOptions();
        for (WebElement selectedOption : selectedOptions)
            System.out.println(selectedOption.getText());
    }

    public void keyDownControlActions(By locator, int i) {
        actions.keyDown(elements(locator).get(i), Keys.CONTROL).perform();
    }

    /* ALERTS_FRAMES_METHODS */
    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Alert switchToAlert() {
        return switchTo().alert();
    }

    public void acceptAlert() {
        switchToAlert().accept();
    }

    public void alertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void dismissAlert() {
        switchToAlert().dismiss();
    }

    public String getCurrentTab() {
        return driver.getWindowHandle();
    }

    public ArrayList<String> get_all_tabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    public void switch_to_tab(ArrayList<String> tab, int index) {
        switchTo().window(tab.get(index));
    }

    public void switch_to_window(ArrayList<String> window, int index) {
        switchTo().window(window.get(index));
    }

    public void switchToMainWindow() {
        switchTo().defaultContent();
    }

    public void availableFrameAndSwitchToIt(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public void switchToFrame(By locator) {
        switchTo().frame(element(locator));
    }

    public void switchToFrameByIndex(int index) {
        switchTo().frame(index);
    }

    public void switchToFrameByName(String name) {
        switchTo().frame(name);
    }

    public void switchToParentFrame() {
        switchTo().parentFrame();
    }

    //Slider & DragAndDrop
    public int widthOfElement(By locator) {
        return element(locator).getSize().getWidth();
    }

    public void clickAndHoldSlider(By locator, int x, int y, int x1, int y1) {
        actions.clickAndHold(element(locator)).moveByOffset(x, y).moveByOffset(x1, y1).release().perform();
    }

    public void dragAndDropWebElements(By locator1, By locator2, int i, int j) {
        actions.dragAndDrop(elements(locator1).get(i), elements(locator2).get(j)).build().perform();
    }

    public void dragAndDropElement(By locator1, By locator2) {
        actions.dragAndDrop(element(locator1), element(locator2)).build().perform();
    }

    public void dragAndDropByOffset(By locator, int x, int y) {
        actions.dragAndDropBy(element(locator), x, y).build().perform();
    }

    public void dragAndDropByOffsetWithIndex(By locator, int index, int x, int y) {
        actions.dragAndDropBy(elements(locator).get(index), x, y).build().perform();
    }


    //Loader
    public void loader(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void uploadFileWithAutoIt(By locator, String path) throws InterruptedException, IOException {
        javaExecutorScrollIntoView(locator);
        moveToElement(locator);
        clickActions(locator);
        Thread.sleep(5000);
        Runtime.getRuntime().exec(path);
    }

    public void clickOnContactByNameInWebTable(By locator, String name) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Wait for table

                List<WebElement> rows = tableElement.findElements(By.tagName("tr")); // Locate rows

                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(By.tagName("td"));  // Locate cells
                    for (WebElement cell : cells) {
                        if (cell.getText().equals(name)) {
                            cell.click();
                            return; // Exit once the cell is clicked
                        }
                    }
                }
                return; // Exit if no match found
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts >= 3) {
                    throw e;
                }
            }
        }
    }

    public void clickOnRandomContact(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); // Wait for table
                List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

                // Ensure there is at least one contact to click on
                if (rows.size() > 1) {
                    // Pick a random row index (excluding the header row if there is one)
                    int randomRowIndex = new Random().nextInt(rows.size());
                    WebElement randomRow = rows.get(randomRowIndex);
                    List<WebElement> cells = randomRow.findElements(By.tagName("td"));
                    int randomCellIndex = new Random().nextInt(cells.size());
                    WebElement randomCell = cells.get(randomCellIndex);
                    randomCell.click();
                    break;
                } else {
                    throw new RuntimeException("No contacts found in the table.");
                }
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts >= 3) {
                    throw e;
                }
            }

        }
    }

}

