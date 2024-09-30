package tr.com.mcay.hibernateoptimization.person.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tr.com.mcay.hibernateoptimization.address.dto.AddressDTO;
import tr.com.mcay.hibernateoptimization.address.dto.mapper.AddressMapper;

import tr.com.mcay.hibernateoptimization.person.dto.PersonDTO;
import tr.com.mcay.hibernateoptimization.person.model.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);
    Person personDTOToPerson(PersonDTO personDTO);
  }
