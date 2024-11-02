package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.service.InputParsingService;
import lotto.service.InputValidationService;
import lotto.service.LottoIssueService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidationService inputValidationService = new InputValidationService();
        InputParsingService inputParsingService = new InputParsingService();
        LottoIssueService lottoIssueService = new LottoIssueService();

        LottoController lottoController =
                new LottoController(
                        inputView, outputView, inputValidationService, inputParsingService, lottoIssueService);
        lottoController.runLotto();

        Console.close();
    }
}
