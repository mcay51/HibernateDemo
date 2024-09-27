package tr.com.mcay.hibernateoptimization.address.service;

import org.springframework.stereotype.Service;
import tr.com.mcay.hibernateoptimization.address.dto.AddressDTO;
import tr.com.mcay.hibernateoptimization.address.dto.mapper.AddressMapper;
import tr.com.mcay.hibernateoptimization.address.model.Address;
import tr.com.mcay.hibernateoptimization.address.repository.AddressRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {


    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.addressDTOToAddress(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return AddressMapper.INSTANCE.addressToAddressDTO(savedAddress);
    }

    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(AddressMapper.INSTANCE::addressToAddressDTO)
                .collect(Collectors.toList());
    }
}

