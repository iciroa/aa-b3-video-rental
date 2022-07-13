package VRUI;

public enum VideoType {
    VHS {
        int getPentalty() {
            return 1;
        }

        int getLimit() {
            return 1;
        }

    },
    CD {
        int getPentalty() {
            return 2;
        }

        int getLimit() {
            return 1;
        }

    },
    DVD {
        int getPentalty() {
            return 3;
        }

        int getLimit() {
            return 1;
        }

    };

    abstract int getPentalty();

    abstract int getLimit();
}
