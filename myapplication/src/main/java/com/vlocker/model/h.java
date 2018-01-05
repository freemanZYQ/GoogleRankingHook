package com.vlocker.model;

class h implements Runnable {
    final /* synthetic */ LetterSortSideBar a;

    h(LetterSortSideBar letterSortSideBar) {
        this.a = letterSortSideBar;
    }

    public void run() {
        this.a.l.setVisibility(4);
    }
}
