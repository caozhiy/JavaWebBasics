package edu.jlu.MyLombok;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Employee {
    @NonNull
    private int employee_id;
    private String first_name;
    private String last_name;
    private String job_title;

    @Setter(AccessLevel.PRIVATE)
    private int salary;
    @Setter(AccessLevel.PROTECTED)
    private int reports_to;
    @Setter(AccessLevel.PROTECTED)
    private int office_id;
}
