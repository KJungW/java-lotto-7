package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.WinningType;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningCriteria;
import lotto.model.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculationServiceTest {

    private LottoCalculationService lottoCalculationService;

    @BeforeEach
    void beforeEach() {
        lottoCalculationService = new LottoCalculationService();
    }

    @DisplayName("입력된_로또에_대한_당첨_결과_계산")
    @Test
    void 입력된_로또에_대한_당첨_결과_계산() {
        WinningCriteria winningCriteria = makeWinningCriteria(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> issuedLotto = List.of(
                new Lotto(List.of(1, 12, 13, 14, 15, 16)), new Lotto(List.of(1, 2, 13, 14, 15, 16)),
                new Lotto(List.of(1, 2, 3, 14, 15, 16)), new Lotto(List.of(1, 2, 3, 4, 15, 16)),
                new Lotto(List.of(1, 2, 3, 4, 5, 16)), new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        WinningResult actualWinningResult = lottoCalculationService.calculateWinning(issuedLotto, winningCriteria);

        assertThat(actualWinningResult.getCountPerWinningType().get(WinningType.FIRST)).isEqualTo(1);
        assertThat(actualWinningResult.getCountPerWinningType().get(WinningType.SECOND)).isEqualTo(1);
        assertThat(actualWinningResult.getCountPerWinningType().get(WinningType.THIRD)).isEqualTo(1);
        assertThat(actualWinningResult.getCountPerWinningType().get(WinningType.FORT)).isEqualTo(1);
        assertThat(actualWinningResult.getCountPerWinningType().get(WinningType.FIFTH)).isEqualTo(1);
        assertThat(actualWinningResult.getCountPerWinningType().get(WinningType.NONE)).isEqualTo(2);
    }

    WinningCriteria makeWinningCriteria(List<Integer> winningNumber, int bonusNumber) {
        Lotto winningLotto = new Lotto(winningNumber);
        BonusNumber winningBonusNumber = new BonusNumber(bonusNumber, winningNumber);
        return new WinningCriteria(winningLotto, winningBonusNumber);
    }

}