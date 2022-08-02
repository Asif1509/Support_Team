package com.example.SupportTeam.repository;

import com.example.SupportTeam.entity.Comments;
import com.example.SupportTeam.entity.ExecutiveAvailability;
import com.example.SupportTeam.entity.UsersDetails;
import com.example.SupportTeam.enums.DataTypeEnum;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface ExecutiveAvailabilityRepository
                    extends JpaRepository<ExecutiveAvailability, Long>{
    ExecutiveAvailability findTopByOpAvailabilityType(DataTypeEnum.OpAvailabilityType opAvailabilityType);

    }


























//
//    @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
//    User findUserByUserStatusAndUserName(@Param("status") Integer userStatus,
//                                         @Param("name") String userName);


