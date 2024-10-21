package com.shahriar.Java_webinar.Repository;

import com.shahriar.Java_webinar.Entity.StudentAccount;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<StudentAccount, Long> {
    Optional<StudentAccount> findByEmail(String gmail);
}
