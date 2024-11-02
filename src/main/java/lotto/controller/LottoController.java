package lotto.controller;

import java.util.List;
import lotto.constant.OutputMessage;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.service.InputParsingService;
import lotto.service.InputValidationService;
import lotto.service.LottoIssueService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationService inputValidationService;
    private final InputParsingService inputParsingService;
    private final LottoIssueService lottoIssueService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            InputValidationService inputValidationService,
            InputParsingService inputParsingService,
            LottoIssueService lottoIssueService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidationService = inputValidationService;
        this.inputParsingService = inputParsingService;
        this.lottoIssueService = lottoIssueService;
    }

    public void runLotto() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        List<Lotto> issuedLotto = lottoIssueService.issueLotto(purchasePrice);
    }

    private PurchasePrice inputPurchasePrice() {
        outputView.printMessage(OutputMessage.PURCHASE_PRICE_INPUT_MESSAGE);
        String rawPurchasePrice = inputView.inputContent();
        inputValidationService.validatePurchasePrice(rawPurchasePrice);
        return inputParsingService.parsePurchasePrice(rawPurchasePrice);
    }
}
