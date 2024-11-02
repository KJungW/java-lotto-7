package lotto.model;

import java.util.List;

public class BonusNumber {

    public static final String NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE = "0이하의 보너스 번호는 허용하지 않습니다.";
    public static final String BANNED_NUMBER_MESSAGE = "당첨 번호와 중복되는 보너스 번호는 허용하지 않습니다.";

    private final int number;

    public BonusNumber(int number, List<Integer> bannedNumbers) {
        validatePositiveNumber(number);
        validateBan(number, bannedNumbers);
        this.number = number;
    }

    private void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateBan(int number, List<Integer> bannedNumbers) {
        boolean isBannedNumber = bannedNumbers.stream()
                .anyMatch(bannedNumber -> bannedNumber.equals(number));
        if (isBannedNumber) {
            throw new IllegalArgumentException(BANNED_NUMBER_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
