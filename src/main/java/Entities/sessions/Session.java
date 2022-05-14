package Entities.sessions;

import Entities.users.user;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public abstract class Session {

    private Long id;

    private List<file> files;

    private user organisateur;

    private List<user> users;

    private Integer State;

    private void kickuser(){

    }

}
