package tr.com.mcay.hibernatecriteria.person.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.mcay.hibernatecriteria.person.dto.PersonDTO;
import tr.com.mcay.hibernatecriteria.person.model.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);
    Person personDTOToPerson(PersonDTO personDTO);
}
