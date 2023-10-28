package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private static final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void getTransaction(FruitTransaction transaction) {
        fruitDao.putToDb(transaction.getFruit(), transaction.getQuantity());
    }
}
