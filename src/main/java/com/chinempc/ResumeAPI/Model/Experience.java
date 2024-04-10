package com.chinempc.ResumeAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.YearMonth;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Experience {
    @Id
    @Column(name = "company_name")
    private String companyName;
    private String Occupation;
    @Column(name = "start_date")
    private YearMonth startDate;
    @Column(name = "end_date")
    private YearMonth endDate;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> notes;
}
