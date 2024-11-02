package lotto.service;

import java.util.List;
import lotto.constant.LottoConfiguration;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;

public class InputParsingService {

    public PurchasePrice parsePurchasePrice(String rawPurchasePrice) {
        int price = Integer.parseInt(rawPurchasePrice);
        return new PurchasePrice(price);
    }

    public Lotto parseWinningLotto(String rawWinningNumber) {
        List<String> separatedNumber = List.of(rawWinningNumber.split(LottoConfiguration.WINNING_NUMBER_DELIMITER));
        List<Integer> winningNumbers = separatedNumber.stream().map(Integer::parseInt).toList();
        return new Lotto(winningNumbers);
    }
}
