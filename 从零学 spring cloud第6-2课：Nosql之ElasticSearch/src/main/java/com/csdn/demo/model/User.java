package com.csdn.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//文档（document）	存入索引库原始的数据。比如每一条商品信息，就是一个文档
//索引库（indices)	indices是index的复数，代表许多的索引，
//类型（type）	    类型是模拟mysql中的table概念，一个索引库下可以有不同类型的索引，比如商品索引，订单索引，其数据格式不同。不过这会导致索引库混乱，因此未来版本中会移除这个概念
//分片（shard）     数据拆分后的各个部分
//副本（replica）   每个分片的复制
//字段（field）	    文档中的属性
//映射配置（mappings）	字段的数据类型、属性、是否索引、是否存储等特性
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(indexName = "user", type = "user", shards = 1, replicas = 0, refreshInterval = "-1")
public class User {
    @Id
    private String id;
    private String userName;
    private String address;
    private int age;

    public User(String userName, String address, int age) {
        this.userName = userName;
        this.address = address;
        this.age = age;
    }
}
