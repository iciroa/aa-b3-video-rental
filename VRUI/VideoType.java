package VRUI;

public enum VideoType {
    VHS {
        int getPentalty() {
            return 1;
        }

        int getLimit() {
            return 5;
        }

    },
    CD {
        int getPentalty() {
            return 2;
        }

        int getLimit() {
            return 3;
        }

    },
    DVD {
        int getPentalty() {
            return 3;
        }

        int getLimit() {
            return 2;
        }

    };

    abstract int getPentalty();

    abstract int getLimit();
}
