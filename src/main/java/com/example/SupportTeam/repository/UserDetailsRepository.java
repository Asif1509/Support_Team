package com.example.SupportTeam.repository;
import com.example.SupportTeam.entity.UsersDetails;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserDetailsRepository
        extends JpaRepository<UsersDetails, Long> {
       Optional<UsersDetails> findById(Long userId);
}