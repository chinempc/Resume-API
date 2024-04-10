package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.ApiRoute;
import com.chinempc.ResumeAPI.Repository.ApiRouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiRouteService {

    private final ApiRouteRepository apiRouteRepository;

    public List<ApiRoute> getApiInfo() {
        return apiRouteRepository.findAll();
    }
}
