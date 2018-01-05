package com.vlocker.theme.model.a;

public enum f {
    Downloading(0),
    Pause(1),
    Installed(2),
    DownloadNotInstall(3),
    Planned(4),
    Update(5),
    Err(6);
    
    public int h;

    private f(int i) {
        this.h = i;
    }
}
