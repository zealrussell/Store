package com.zeal.store.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/18 12:43
 */

// 标识购物车数据 ValueObject
public class CartVO implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private String title;
    private String image;
    private Long realPrice;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartVO)) return false;
        CartVO cartVO = (CartVO) o;
        return Objects.equals(cid, cartVO.cid) && Objects.equals(uid, cartVO.uid) && Objects.equals(pid, cartVO.pid) && Objects.equals(price, cartVO.price) && Objects.equals(num, cartVO.num) && Objects.equals(title, cartVO.title) && Objects.equals(image, cartVO.image) && Objects.equals(realPrice, cartVO.realPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, uid, pid, price, num, title, image, realPrice);
    }


}
