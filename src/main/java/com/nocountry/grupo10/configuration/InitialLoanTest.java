package com.nocountry.grupo10.configuration;

import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.model.entity.Loan;
import com.nocountry.grupo10.model.entity.Role;
import com.nocountry.grupo10.model.entity.RoleType;
import com.nocountry.grupo10.repository.AppUserRepository;
import com.nocountry.grupo10.repository.LoanRepository;
import com.nocountry.grupo10.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.nocountry.grupo10.model.entity.RoleType.ROLE_ADMIN;
import static com.nocountry.grupo10.model.entity.RoleType.ROLE_USER;


@Configuration
public class InitialLoanTest implements CommandLineRunner {

    @Autowired
    LoanRepository loanRepository;




    @Override
    public void run(String... args) throws Exception {
        createLoanIfNotExist();
    }

    /*
    Añadir Loan al usuario User inicial o más adelante borrar si no hace falta!!
    Solo para testear cosas más fácilmente!!!!
     */

    public void createLoanIfNotExist(){
        if(loanRepository.findAll().isEmpty()){
            Loan loan = new Loan();
            loan.setDues(12);
            loan.setInterest(40.5);
            loan.setMonthlyFee(500);
            loan.setRequiredMoney(55000l);
            loan.setState(false);
            loan.setTotalAmount(70000d);
            loanRepository.save(loan);
        }
    }


}
