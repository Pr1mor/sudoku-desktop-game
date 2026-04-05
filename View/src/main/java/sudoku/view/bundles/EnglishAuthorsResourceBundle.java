package sudoku.view.bundles;

import java.util.ListResourceBundle;

public class EnglishAuthorsResourceBundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                { "university", "University of Manitoba" },
                { "247026", "Pratham Patel" },
                { "247027", "Wojciech Kapica" },
        };

    }
}
