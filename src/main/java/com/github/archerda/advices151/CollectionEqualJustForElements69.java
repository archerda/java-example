package com.github.archerda.advices151;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 集合类, 不关心具体的实现类, 只有所有的元素相等, 并且长度也相等就表明2个List相等, 与具体的容器类型无关.
 * Created by luohd on 16/12/27.
 */
public class CollectionEqualJustForElements69 {

    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("A");

        Vector<String> stringVector = new Vector<>();
        stringVector.add("A");

        System.out.println(stringArrayList.equals(stringVector));
    }
}
