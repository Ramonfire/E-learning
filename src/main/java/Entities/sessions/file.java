package Entities.sessions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class file {

    private Long idFile;

    private String name;

    private Byte[] bytecode;
}
