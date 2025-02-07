package core.basesyntax.model;

public class FruitTransaction {
    private Operation operation;
    private String fruit;
    private int quantity;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String stringOption;

        Operation(String code) {
            this.stringOption = code;
        }

        public static Operation getCode(String inputCode) {
            for (Operation operationType : Operation.values()) {
                if (operationType.stringOption.equals(inputCode)) {
                    return operationType;
                }
            }
            throw new RuntimeException("There is no such option: " + inputCode
                    + ", select from existing ones");
        }
    }
}
