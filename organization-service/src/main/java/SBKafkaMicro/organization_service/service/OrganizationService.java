package SBKafkaMicro.organization_service.service;

import SBKafkaMicro.organization_service.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);

}
