package com.bistu.concurrent.threadSafety.cas.atomic;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //获取unsafe对象
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        //获取reacher对象属性偏移量
        long idOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));
        //执行cas
        Teacher teacher = new Teacher();
        unsafe.compareAndSwapInt(teacher, idOffset, 0, 1);
        unsafe.compareAndSwapObject(teacher, nameOffset, null, "张三");

        System.out.println(teacher);
    }
}

@Data
class Teacher {
    volatile int id;
    volatile String name;
}


