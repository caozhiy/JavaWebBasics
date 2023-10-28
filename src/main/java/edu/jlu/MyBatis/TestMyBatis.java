package edu.jlu.MyBatis;

import edu.jlu.MyBatis.TestMapper.TestMapper;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import edu.jlu.MyLombok.*;

public class TestMyBatis {
    public static void main(String[] args) throws IOException {
        testMapper();

    }

    public static void first() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Files.newInputStream(Paths.get("mybatis-config.xml")));

        @Cleanup
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

//        List<Employee> list = sqlSession.selectList("selectEmployee");
//        list.forEach(System.out::println);


        System.out.println(sqlSession.selectOne("selectTargetEmployee", 84791).toString());
        Employee target = sqlSession.selectOne("selectTargetEmployee", 84791);
        System.out.println(target.getClass());

    }

    public static void test() {
        @Cleanup
        SqlSession sqlSession = MyBatisUtil.getSession(true);

        List<Employee> list = sqlSession.selectList("selectEmployee");
        list.forEach(System.out::println);

    }

    public static void testMapper() {
        @Cleanup
        SqlSession sqlSession = MyBatisUtil.getSession(true);
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        List<Employee> employees = mapper.selectEmployee();
        employees.forEach(System.out::println);


    }
}
