package com.youcode.aftas.core.database.repository;

import com.youcode.aftas.core.database.model.entity.Competition;
import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.entity.Hunting;
import com.youcode.aftas.core.database.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository

public interface HuntingRepository extends JpaRepository<Hunting, UUID>, JpaSpecificationExecutor<Hunting> {

    Optional<Hunting> findByMemberAndFishAndCompetition(Member member, Fish fish, Competition competition);
    /*
    example of us of JpaSpecificationExecutor

    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    List<Person> find(@Param("lastName") String lastName);

     */
}