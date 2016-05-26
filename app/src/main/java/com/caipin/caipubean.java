package com.caipin;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 16-5-18.
 */
public class caipubean implements Serializable{

    /**
     * caiid : 5
     * cainame : 梅菜扣肉
     * img : ../caitu/t010dfacca5aae890fa.jpg
     * caijiage : 20
     * houdongjia : 0
     * danweiid : 1
     * danweiname : 例
     * leixingid : 2
     * leixingname : 套餐
     */

    private List<RowsBean> rows;

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        private int caiid;
        private String cainame;
        private String img;
        private int caijiage;
        private int houdongjia;
        private int danweiid;
        private String danweiname;
        private int leixingid;
        private String leixingname;

        public int getCaiid() {
            return caiid;
        }

        public void setCaiid(int caiid) {
            this.caiid = caiid;
        }

        public String getCainame() {
            return cainame;
        }

        public void setCainame(String cainame) {
            this.cainame = cainame;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getCaijiage() {
            return caijiage;
        }

        public void setCaijiage(int caijiage) {
            this.caijiage = caijiage;
        }

        public int getHoudongjia() {
            return houdongjia;
        }

        public void setHoudongjia(int houdongjia) {
            this.houdongjia = houdongjia;
        }

        public int getDanweiid() {
            return danweiid;
        }

        public void setDanweiid(int danweiid) {
            this.danweiid = danweiid;
        }

        public String getDanweiname() {
            return danweiname;
        }

        public void setDanweiname(String danweiname) {
            this.danweiname = danweiname;
        }

        public int getLeixingid() {
            return leixingid;
        }

        public void setLeixingid(int leixingid) {
            this.leixingid = leixingid;
        }

        public String getLeixingname() {
            return leixingname;
        }

        public void setLeixingname(String leixingname) {
            this.leixingname = leixingname;
        }
    }
}
