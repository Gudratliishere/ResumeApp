package com.company.dto;

import com.company.resume.etinity.EmploymentHistory;
import com.company.resume.etinity.User;
import com.company.resume.etinity.UserSkill;
import com.company.resume.service.inter.CountryServiceInter;
import com.company.resume.service.inter.EmploymentHistoryServiceInter;
import com.company.resume.service.inter.SkillServiceInter;
import com.company.resume.service.inter.UserSkillServiceInter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDTO
{

    Integer id;

    @NotNull
    @NotBlank(message = "Name cannot be empty!")
    String name;

    @NotNull
    @NotBlank(message = "Surname cannot be empty!")
    String surname;
    
    String email;
    String phone;
    String profileDescription;
    String address;
    Date birthdate = new Date(0);
    List<UserSkillDTO> userSkillList;
    List<EmploymentHistoryDTO> empHistoryList;
    CountryDTO birthplace = new CountryDTO("Azerbaijan", null, null);
    CountryDTO nationality = new CountryDTO(null, "Azerbeijani", null);

    public UserDTO()
    {
    }

    public UserDTO(Integer id, String name, String surname, String email, String phone, String profileDescription, String address,
            Date birthdate, List<UserSkillDTO> userSkillList, List<EmploymentHistoryDTO> empHistoryList, CountryDTO birthplace,
            CountryDTO nationality)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthdate = birthdate;
        this.userSkillList = userSkillList;
        this.empHistoryList = empHistoryList;
        this.birthplace = birthplace;
        this.nationality = nationality;
    }

    public static UserDTO of(User user)
    {
        //Convert list of UserSkill to list of UserSkillDTO
        List<UserSkill> userSkills = user.getUserSkillList();
        List<UserSkillDTO> userSkillDTOs = new ArrayList<>();

        userSkills.forEach((userSkill) -> userSkillDTOs.add(UserSkillDTO.of(userSkill)));

        //Convert list of EmploymentHistory to list of EmploymentHistoryDTO
        List<EmploymentHistory> employmentHistorys = user.getEmploymentHistoryList();
        List<EmploymentHistoryDTO> employmentHistoryDTOs = new ArrayList<>();

        employmentHistorys.forEach((employmentHistory)
                -> employmentHistoryDTOs.add(EmploymentHistoryDTO.of(employmentHistory)));

        return new UserDTO(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPhone(), user.getProfileDescription(),
                user.getAdress(), user.getBirthdate(), userSkillDTOs, employmentHistoryDTOs,
                CountryDTO.of(user.getBirthplace()), CountryDTO.of(user.getNationality()));
    }

    public static void toUser(UserDTO userDTO, User user, UserSkillServiceInter userSkillService,
            SkillServiceInter skillService, EmploymentHistoryServiceInter emphService, CountryServiceInter countryService)
    {
        //Convert list of UserSkillDTO to list of UserSkill
        List<UserSkillDTO> userSkillDTOs = userDTO.getUserSkillList();
        List<UserSkill> userSkills = new ArrayList<>();

        if (userSkillDTOs != null && userSkillDTOs.size() > 0)
            userSkillDTOs.forEach((userSkill) -> userSkills.add(UserSkillDTO.toUserSkill(userSkill, userSkillService,
                    skillService)));

        //Convert list of EmploymentHistoryDTO to list of EmploymentHistory
        List<EmploymentHistoryDTO> employmentHistoryDTOs = userDTO.getEmpHistoryList();
        List<EmploymentHistory> employmentHistorys = new ArrayList<>();

        if (employmentHistoryDTOs != null && employmentHistoryDTOs.size() > 0)
            employmentHistoryDTOs.forEach((employmentHistory)
                    -> employmentHistorys.add(EmploymentHistoryDTO.toEmph(employmentHistory, emphService)));

        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setProfileDescription(userDTO.getProfileDescription());
        user.setAdress(userDTO.getAddress());
        user.setBirthdate(userDTO.getBirthdate());
        /*For full changing
        user.setUserSkillList(userSkills);
        user.setEmploymentHistoryList(employmentHistorys);
         */
        user.setBirthplace(CountryDTO.toCountry(userDTO.getBirthplace(), countryService));
        user.setNationality(CountryDTO.toCountry(userDTO.getNationality(), countryService));

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getProfileDescription()
    {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription)
    {
        this.profileDescription = profileDescription;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Date getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }

    public List<UserSkillDTO> getUserSkillList()
    {
        return userSkillList;
    }

    public void setUserSkillList(List<UserSkillDTO> userSkillList)
    {
        this.userSkillList = userSkillList;
    }

    public List<EmploymentHistoryDTO> getEmpHistoryList()
    {
        return empHistoryList;
    }

    public void setEmpHistoryList(List<EmploymentHistoryDTO> empHistoryList)
    {
        this.empHistoryList = empHistoryList;
    }

    public CountryDTO getBirthplace()
    {
        return birthplace;
    }

    public void setBirthplace(CountryDTO birthplace)
    {
        this.birthplace = birthplace;
    }

    public CountryDTO getNationality()
    {
        return nationality;
    }

    public void setNationality(CountryDTO nationality)
    {
        this.nationality = nationality;
    }

    @Override
    public String toString()
    {
        return "UserDTO{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + ", profileDescription=" + profileDescription + ", address=" + address + ", birthdate=" + birthdate + ", userSkillList=" + userSkillList + ", empHistoryList=" + empHistoryList + ", birthplace=" + birthplace + ", nationality=" + nationality + '}';
    }
}
