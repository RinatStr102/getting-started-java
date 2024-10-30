import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubWikiTest {
    @BeforeAll
    public static void setUp() {
       Configuration.holdBrowserOpen = true;
    }

    @Test
    public void verifySoftAssertionsPageContainsJUnit5Example() {

        Object open;open ("https://github.com");

        $("button.header-search-button").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("#wiki-tab").click();
    }
}
