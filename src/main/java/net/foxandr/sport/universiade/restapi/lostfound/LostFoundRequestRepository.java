package net.foxandr.sport.universiade.restapi.lostfound;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LostFoundRequestRepository extends JpaRepository<LostFoundRequestsEntity, Long> {
}
