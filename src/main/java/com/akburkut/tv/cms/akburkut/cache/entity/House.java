package com.akburkut.tv.cms.akburkut.cache.entity;

import javax.persistence.*;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 16:24 2018/7/26
 * @Modified By:
 */
@Entity
public class House {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(length = 10)
    private String houseName;
    private String houseSize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize;
    }

    public House(String houseName, String houseSize) {
        this.houseName = houseName;
        this.houseSize = houseSize;
    }

    public House(int id,String houseName, String houseSize) {
        this.id = id;
        this.houseName = houseName;
        this.houseSize = houseSize;
    }

    public House() {}

}
