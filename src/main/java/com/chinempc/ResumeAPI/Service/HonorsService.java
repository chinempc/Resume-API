package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.Honors;
import com.chinempc.ResumeAPI.Repository.HonorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HonorsService {

    private final HonorsRepository honorsRepository;

    public List<Honors> getHonors() {
        return honorsRepository.findAll();
    }
}
