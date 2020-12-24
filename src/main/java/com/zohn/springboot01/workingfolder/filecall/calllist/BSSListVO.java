package com.zohn.springboot01.workingfolder.filecall.calllist;

import com.zohn.springboot01.workingfolder.filecall.calldetail.BSSVO;

import java.util.List;

public class BSSListVO {
    private List<BSSVO> bssvos;

    public List<BSSVO> getBssvos() {
        return bssvos;
    }

    public void setBssvos(List<BSSVO> bssvos) {
        this.bssvos = bssvos;
    }
}
