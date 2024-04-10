package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.ApiRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRouteRepository extends JpaRepository<ApiRoute, Long> {
}
