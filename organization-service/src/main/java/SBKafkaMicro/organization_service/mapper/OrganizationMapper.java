package SBKafkaMicro.organization_service.mapper;

import SBKafkaMicro.organization_service.dto.OrganizationDto;
import SBKafkaMicro.organization_service.entity.Organization;

public class OrganizationMapper {


    public static OrganizationDto mapToOrganizationDto(Organization organization){


        OrganizationDto organizationDto = new OrganizationDto(

                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getCreatedDate()

        );
        return organizationDto;

    }

    public static Organization mapToOrganization(OrganizationDto organizationDto){

        Organization organization = new Organization(

                organizationDto.getId(),
                organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(),
                organizationDto.getCreatedDate()

        );
        return organization;

    }

}
