package com.example.SupportTeam.service;
import com.example.SupportTeam.dto.UsersData;
import com.example.SupportTeam.dto.VehicleDTO;
import com.example.SupportTeam.entity.ExecutiveAvailability;
import com.example.SupportTeam.entity.Issue;
import com.example.SupportTeam.entity.UsersDetails;
import com.example.SupportTeam.entity.Vehicle;
import com.example.SupportTeam.enums.DataTypeEnum;
import com.example.SupportTeam.repository.UserDetailsRepository;
import com.example.SupportTeam.repository.ExecutiveAvailabilityRepository;
import com.example.SupportTeam.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository usersDetailsRepository;
    @Autowired
    private ExecutiveAvailabilityRepository executiveAvailabilityRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public void addNewOperator(UsersData usersData) {
        UsersDetails usersDetails = new UsersDetails();
        usersDetails.setName(usersData.getName());
        usersDetails.setAddress(usersData.getAddress());
        usersDetails.setContact(usersData.getContact());
        usersDetails.setUserType(DataTypeEnum.UserType.OPERATOR);
        usersDetails = usersDetailsRepository.save(usersDetails);
        for(VehicleDTO vehicleDTO : usersData.getVehicle()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(vehicleDTO.getVehicleNo());
            vehicle.setVehicleNo(vehicleDTO.getVehicleNo());
            vehicle.setVehicleNo(vehicleDTO.getVehicleNo());
            vehicle.setUserId(usersDetails);
            vehicleRepository.save(vehicle);
        }
    }

    public void addNewAdmin(UsersData usersData) {
        UsersDetails usersDetails=new UsersDetails();
        usersDetails.setName(usersData.getName());
        usersDetails.setAddress(usersData.getAddress());
        usersDetails.setContact(usersData.getContact());
        usersDetails.setUserType(DataTypeEnum.UserType.ADMIN);
        usersDetails=usersDetailsRepository.save(usersDetails);
    }

    public void addNewExecutive(UsersData usersData) {
        UsersDetails usersDetails=new UsersDetails();
        usersDetails.setName(usersData.getName());
        usersDetails.setAddress(usersData.getAddress());
        usersDetails.setContact(usersData.getContact());
        usersDetails.setUserType(DataTypeEnum.UserType.EXECUTIVE);
        usersDetails=usersDetailsRepository.save(usersDetails);

        ExecutiveAvailability executiveAvailability=new ExecutiveAvailability();
        executiveAvailability.setOpAvailabilityType(DataTypeEnum.OpAvailabilityType.AVAILABLE);
        executiveAvailability.setUserId(usersDetails);
        executiveAvailability=executiveAvailabilityRepository.save(executiveAvailability);
    }

    public void assignNewIssue(Issue userDetails) {
    }
}
