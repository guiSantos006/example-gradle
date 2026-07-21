package br.com.gui;

import br.com.gui.dto.UserDTO;
import br.com.gui.mapper.UserMapper;
import br.com.gui.model.UserModel;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {

    private static final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    static void main() {
        var model = new UserModel();
        model.setUserName("Mario");
        model.setCode(1);
        model.setBirthday(LocalDate.now().minusYears(20));
        System.out.println(mapper.toDTO(model));

        var dto = new UserDTO();
        dto.setName("Ana");
        dto.setId(2);
        dto.setBirthday(LocalDate.now().minusYears(10));
        System.out.println(mapper.toModel(dto));
    }
}
