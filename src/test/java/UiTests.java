import Pages.AuthPage;
import Pages.VariantPage;
import Utils.ResourceUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UiTests extends TestBase {

    AuthPage authPage = new AuthPage(webDriver);
    VariantPage variantPage = new VariantPage(webDriver);

    String email = ResourceUtil.getResources("email");
    String password = ResourceUtil.getResources("password");
    String firstVariant = ResourceUtil.getResources("firstVariant");
    String secondVariant = ResourceUtil.getResources("secondVariant");
    String expectedText = "Есть такое выражение: руке следует ждать помощи только от плеча.";
    String secondExpectedText = "The requested URL was not found on this server.";

    public UiTests() throws Exception {
    }

    @Test
    public void firstTest(){
        authPage
                .insertEmail(email)
                .insertPassword(password)
                .clickToSubmitButton()
                .chooseVariantOfAges(firstVariant)
                .clickToButtonSend();
        Assert.assertTrue(variantPage.checkTextFromPage(expectedText),
                "Message don't contains expected text");
    }

    @Test
    public void secondTest(){
        authPage
                .insertEmail(email)
                .insertPassword(password)
                .clickToSubmitButton()
                .chooseVariantOfAges(secondVariant)
                .clickToButtonSend();
        Assert.assertTrue(variantPage.checkTextFromPage(secondExpectedText),
                "Message don't contains expected text");
    }
}
