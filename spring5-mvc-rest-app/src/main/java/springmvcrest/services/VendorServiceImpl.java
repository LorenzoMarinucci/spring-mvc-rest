package springmvcrest.services;

import org.springframework.stereotype.Service;
import springmvcrest.api.v1.mapper.VendorMapper;
import springmvcrest.api.v1.model.VendorDTO;
import springmvcrest.controllers.v1.VendorController;
import springmvcrest.domain.Vendor;
import springmvcrest.repositories.VendorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }


    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll().stream().map(vendor -> {
            VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(vendor);
            returnDTO.setVendorUrl(getCustomUrl(vendor.getId()));
            return returnDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor savedVendor = vendorRepository.save(vendorMapper.VendorDTOToVendor(vendorDTO));
        VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(savedVendor);
        returnDTO.setVendorUrl(getCustomUrl(savedVendor.getId()));
        return returnDTO;
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(vendor);
        returnDTO.setVendorUrl(getCustomUrl(vendor.getId()));
        return returnDTO;
    }

    @Override
    public VendorDTO patchCustomer(VendorDTO vendorDTO, Long id) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (vendorDTO.getName() != null) {
            vendor.setName(vendorDTO.getName());
        }
      return saveVendorReturnDTO(vendor);
    }

    private VendorDTO saveVendorReturnDTO(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO returnDTO = vendorMapper.vendorToVendorDTO(savedVendor);
        returnDTO.setVendorUrl(getCustomUrl(savedVendor.getId()));
        return returnDTO;
    }

    @Override
    public VendorDTO saveVendorByDTO(VendorDTO vendorDTO, Long id) {
        Vendor vendor = vendorMapper.VendorDTOToVendor(vendorDTO);
        vendor.setId(id);
        return saveVendorReturnDTO(vendor);
    }

    @Override
    public void deleteByIdVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    private String getCustomUrl(Long id) {
        return VendorController.BASE_URL + "/" + id;
    }
}
