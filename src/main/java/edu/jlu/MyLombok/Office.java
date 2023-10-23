package edu.jlu.MyLombok;

import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Office {

    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PUBLIC)
    private static int count = 0;
    private int office_id;
    private String address;
    private String city;
    private String state;
}
