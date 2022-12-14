package com.sanderxavalon.passwordvalidation.core.validation;

import com.sanderxavalon.passwordvalidation.core.common.exception.ValidationException;
import com.sanderxavalon.passwordvalidation.core.common.response.StatusEnum;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(3)
@Component
public class NoSequencePasswordValidator extends PasswordValidator{

    @Override
    public void check(String password) {

        int fullBlockAmount = password.length();

        // make it even
        if(fullBlockAmount % 2 == 1) {
            fullBlockAmount = fullBlockAmount - 1;
        }

        for (; fullBlockAmount > 2; fullBlockAmount = fullBlockAmount - 2) {

            int compareStep = password.length() - fullBlockAmount;
            int movedStep = 0;

            for (; compareStep >= 0; compareStep--) {
                int fetchBlockUpperIndex = 0 + movedStep;
                int fetchBlockLowerIndex = fetchBlockUpperIndex + (fullBlockAmount/2);
                int compareBlockUpperIndex = fetchBlockLowerIndex;
                int compareBlockLowerIndex = compareBlockUpperIndex + (fullBlockAmount/2);
                String fetchBlock = password.substring(fetchBlockUpperIndex, fetchBlockLowerIndex);
                String compareBlock = password.substring(compareBlockUpperIndex, compareBlockLowerIndex);

                if (fetchBlock.equals(compareBlock)) {
                    throw new ValidationException(StatusEnum.PASSWORD_MUST_NOT_CONTAIN_A_SEQUENCE_LETTER_FOLLOW_BY_ANY_SAME_SEQUENCE);
                }
                movedStep++;
            }
        }
    }

}
