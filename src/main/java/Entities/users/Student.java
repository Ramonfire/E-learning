package Entities.users;

import Entities.users.user;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student  extends user {
    private  Long niveau;
}
