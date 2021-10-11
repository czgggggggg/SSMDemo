package com.bupt.factory;

import com.bupt.bean.Animal;

/**
 * @Author czgggggggg
 * @Date 2021/10/11
 * @Description
 */
public class InstanceFactory {
    public Animal createAnimal(){
        return new Animal();
    }
}
