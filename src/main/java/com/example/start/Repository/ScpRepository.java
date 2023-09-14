package com.example.start.Repository;

import com.example.start.Model.Scp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScpRepository extends JpaRepository<Scp, Long> {
}
