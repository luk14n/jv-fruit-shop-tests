package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileParserServiceImplTest {
    private static final String INVALID_OPTION1 = "x,banana,12";
    private static final String INVALID_OPTION2 = "y,apple,7";
    private static final String INVALID_VALUE1 = "b,banana,value";
    private static final String INVALID_VALUE2 = "p,apple,value1";
    private static final String INVALID_INPUT1 = "b-fruit1-value";
    private static final String INVALID_INPUT2 = "p-fruit2-value2";
    private static FileParserService recordsParser;

    @BeforeAll
    static void beforeAll() {
        recordsParser = new FileParserServiceImpl();
    }

    @Test
    void parse_emptyList_Ok() {
        List<String> list = new ArrayList<>();
        List<FruitTransaction> expected = new ArrayList<>();
        List<FruitTransaction> actual = recordsParser.parse(list);
        assertEquals(expected, actual);
    }

    @Test
    void parse_invalidOption_notOk() {
        List<String> list = new ArrayList<>();
        list.add(INVALID_OPTION1);
        list.add(INVALID_OPTION2);
        assertThrows(RuntimeException.class,
                () -> recordsParser.parse(list));
    }

    @Test
    void parse_invalidValue_notOk() {
        List<String> list = new ArrayList<>();
        list.add(INVALID_VALUE1);
        list.add(INVALID_VALUE2);
        assertThrows(NumberFormatException.class,
                () -> recordsParser.parse(list));
    }

    @Test
    void parse_invalidInput_notOk() {
        List<String> list = new ArrayList<>();
        list.add(INVALID_INPUT1);
        list.add(INVALID_INPUT2);
        assertThrows(RuntimeException.class,
                () -> recordsParser.parse(list));
    }

    @Test
    void parse_nullInput_NotOk() {
        assertThrows(RuntimeException.class,
                () -> recordsParser.parse(null));
    }
}
