enum Auswahl {
    SPIELEN(1),
    HIGHSCORE(2),
    REGELWERK(3),
    BEENDEN(4);

    final int index;

    Auswahl(int index) {
        this.index = index;
    }
}