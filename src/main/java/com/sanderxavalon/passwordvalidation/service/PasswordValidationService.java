package com.sanderxavalon.passwordvalidation.service;

import com.sanderxavalon.passwordvalidation.core.validation.NoOpsValidator;
import com.sanderxavalon.passwordvalidation.core.validation.PasswordValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordValidationService {

    private PasswordValidator headNode;

    public PasswordValidationService(List<PasswordValidator> nodeList) {

        if (nodeList.isEmpty()) {

            this.headNode = new NoOpsValidator();

        } else {

            for (int i = 0; i < nodeList.size(); i++) {

                PasswordValidator currentNode = nodeList.get(i);

                int nextNumber = i + 1;

                PasswordValidator nextNode = nextNumber >= nodeList.size() ? new NoOpsValidator() : nodeList.get(nextNumber);

                currentNode.setNext(nextNode);

            }

            this.headNode = nodeList.get(0);

        }
    }

    public void validatePassword(String password) {
        headNode.check(password);
    }

}
