package sudoku.view.bundles;

import java.util.ListResourceBundle;

public class PolishAuthorsResourceBundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                { "university", "Uniwersytet Manitoby" },
                { "247026", "Pratham Patel" },
                { "247027", "Wojciech Kapica" },
        };

    }
}
