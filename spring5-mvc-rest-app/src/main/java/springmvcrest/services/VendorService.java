package springmvcrest.services;

import springmvcrest.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO getVendorById(Long id);
    VendorDTO patchCustomer(VendorDTO vendorDTO, Long id);
    VendorDTO saveVendorByDTO(VendorDTO vendorDTO, Long id);
    void deleteByIdVendor(Long id);
}
