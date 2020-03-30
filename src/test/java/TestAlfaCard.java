import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestAlfaCard {

    @Test
    void startService() {
        open("http://localhost:9999");
        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=name] input").setValue("Иннокентий");
        form.$("[data-test-id=phone] input").setValue("+70001112233");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}

