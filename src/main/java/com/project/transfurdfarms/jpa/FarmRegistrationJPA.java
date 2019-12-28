package com.project.transfurdfarms.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.transfurdfarms.dto.FarmRegistration;

@Repository("FarmRegistrationJPA")
public interface FarmRegistrationJPA extends CrudRepository<FarmRegistration, Long> {
     FarmRegistration findByEmail(String email);
     FarmRegistration findByConfirmationToken(String confirmationToken);
}
