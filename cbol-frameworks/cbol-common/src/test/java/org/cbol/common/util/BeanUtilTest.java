package org.cbol.common.util;

import org.cbol.common.Student;
import org.cbol.common.StudentVO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaowenlei
 * @date 2023年11月25日 3:32 下午
 */
public class BeanUtilTest {

    @Test
    public void testBeanUtilConvertMethod1() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(2);

        StudentVO studentVO = new StudentVO();

        StudentVO convert = BeanUtil.convert(student, studentVO);
        Assert.assertEquals(student.getName(),convert.getName());
        Assert.assertEquals(student.getAge(),convert.getAge());
    }

    @Test
    public void testBeanUtilConvertMethod2() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(2);

        StudentVO convert = BeanUtil.convert(student, StudentVO.class);
        Assert.assertNotNull(convert);
        Assert.assertEquals(student.getName(),convert.getName());
        Assert.assertEquals(student.getAge(),convert.getAge());
    }

    @Test
    public void testBeanUtilConvertMethod3() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(2);
        Student student1 = new Student("李四", 5);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);

        List<StudentVO> convert = BeanUtil.convert(students, StudentVO.class);
        Assert.assertEquals(students.size(),convert.size());

    }

}
