package com.csdn.demo.web;

import net.rubyeye.xmemcached.CASOperation;
import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControl {
    @Autowired
    private MemcachedClient memcachedClient;

    @RequestMapping("/CheckSetAndGetValue")
    public String CheckSetAndGetValue() {
        try {
            memcachedClient.set("csdn", 0, "Hello csdn 2019");
            String value = memcachedClient.get("csdn");
            return value;
        } catch (Exception ex) {
            return "";
        }
    }


    @RequestMapping("/DeleteSetValue")
    public String DeleteSetValue() {
        try {
            memcachedClient.delete("csdn");
            String value = memcachedClient.get("csdn");
            return value;
        } catch (Exception ex) {
            return "我错了";
        }
    }

    @RequestMapping("/CheckAdd")
    public String CheckAdd() {
        try {
            memcachedClient.set("csdn2019", 0, "Hello csdn 2019");
            memcachedClient.add("csdn2019", 0, "2019");
            String value = memcachedClient.get("csdn2019");
            return value;
        } catch (Exception ex) {
            return "CheckAdd 我错了";
        }
    }

    @RequestMapping("/CheckReplace")
    public String CheckReplace() {
        try {
            memcachedClient.replace("csdn2019", 0, "my csdn");
            String value = memcachedClient.get("csdn2019");
            return value;
        } catch (Exception ex) {
            return "CheckReplace 我错了";
        }
    }

    @RequestMapping("/CheckAppendAndPrepend")
    public String CheckAppendAndPrepend() {
        try {
            memcachedClient.append("csdn2019", " 2020");
            memcachedClient.prepend("csdn2019", "2018 ");
            String value = memcachedClient.get("csdn2019");
            return value;
        } catch (Exception ex) {
            return "CheckAppendAndPrepend 我错了";
        }
    }

    @RequestMapping("/DeleteWithNoReply")
    public void DeleteWithNoReply() {
        try {
            memcachedClient.deleteWithNoReply("csdn2018");
        } catch (Exception ex) {

        }
    }

    @RequestMapping("/IncrAndDecr")
    public void IncrAndDecr() throws Exception {
        memcachedClient.delete("MyIncr");
        memcachedClient.delete("MyDecr");
        System.out.println(memcachedClient.incr("MyIncr", 5, 8));
        System.out.println(memcachedClient.incr("MyIncr", 3));
        System.out.println(memcachedClient.incr("MyIncr", 2));
        System.out.println(memcachedClient.decr("MyDecr", 1, 9));
        System.out.println(memcachedClient.decr("MyDecr", 2));
    }

    @RequestMapping("/Counter")
    public void Counter() throws Exception {
        Counter counter = memcachedClient.getCounter("counter1", 11);
        System.out.println("counter=" + counter.get());

        long c1 = counter.incrementAndGet();
        System.out.println("counter=" + c1);

        long c2 = counter.decrementAndGet();
        System.out.println("counter=" + c2);

        long c3 = counter.addAndGet(-8);
        System.out.println("counter=" + c3);

    }

    @RequestMapping("/Cas")
    public void Cas() throws Exception {
        memcachedClient.set("MyCas", 0, 2019);
        GetsResponse<Integer> result = memcachedClient.gets("MyCas");
        System.out.println("MyCas 值 " + result.getValue());

        long cas = result.getCas();
        //尝试将a的值更新为200
        if (!memcachedClient.cas("MyCas", 0, 200, cas)) {
            System.err.println("更新失败了");
        }
        System.out.println("MyCas 值 " + memcachedClient.get("MyCas"));

        memcachedClient.cas("MyCas", 0, new CASOperation<Integer>() {
            public int getMaxTries() {
                return 1;
            }

            public Integer getNewValue(long currentCAS, Integer currentValue) {
                return 300;
            }
        });

        System.out.println("MyCas 值 " + memcachedClient.get("MyCas"));

    }

    @RequestMapping("/MyTouch")
    public String MyTouch() throws Exception {
        memcachedClient.set("MyTouch", 2, "MyTouch Value");
        Thread.sleep(3000);
        String value = memcachedClient.get("MyTouch");
        return value;
    }


}
