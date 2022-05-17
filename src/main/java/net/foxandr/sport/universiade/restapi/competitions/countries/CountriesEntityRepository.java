package net.foxandr.sport.universiade.restapi.competitions.countries;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesEntityRepository extends JpaRepository<CountriesEntity, Long> {

    CountriesEntity findAllById(Long id);

}
