package com.akburkut.tv.cms.akburkut.cache.controller;

import com.akburkut.tv.cms.akburkut.cache.entity.House;
import com.akburkut.tv.cms.akburkut.cache.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 16:31 2018/7/26
 * @Modified By:
 */
@RestController
public class HouseController {
    @Autowired
    private HouseRepository houseRepository;

    //http://localhost/saveHouse?id=1&houseName=别墅&houseSize=1220平方米
    @GetMapping("/saveHouse")
    @CachePut(value = "house", key = "#id")
    public House saveHouse(Integer id, String houseName, String houseSize){
        House house = new House(id,houseName, houseSize);
        houseRepository.save(house);
        return house;
    }

    //http://localhost/queryHouse?id=1
    @GetMapping("/queryHouse")
    @Cacheable(value = "house", key = "#id")
    public House queryHouse(Integer id){
        House house = houseRepository.findOne(id);
        return house;
    }

    //http://localhost/deleteHouse?id=1
    @GetMapping("/deleteHouse")
    @CacheEvict(value = "house", key = "#id")
    public String deleteHouse(Integer id){
        houseRepository.delete(id);
        return "success";
    }

    //http://localhost/deleteCache
    @GetMapping("/deleteCache")
    @CacheEvict(value = "house", allEntries = true)
    public void deleteCache() {}

}
