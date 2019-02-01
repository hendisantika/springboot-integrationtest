package com.hendisantika.springbootintegrationtest.repository;

import com.hendisantika.springbootintegrationtest.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integrationtest
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-01
 * Time: 08:05
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}