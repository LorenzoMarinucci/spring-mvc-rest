package springmvcrest.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springmvcrest.api.v1.model.VendorDTO;
import springmvcrest.domain.Vendor;

@Mapper
public interface VendorMapper {

    public static VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    public VendorDTO vendorToVendorDTO(Vendor vendor);
    public Vendor VendorDTOToVendor(VendorDTO vendorDTO);
}
