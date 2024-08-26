package SBKafkaMicro.organization_service.service.impl;

import SBKafkaMicro.organization_service.dto.OrganizationDto;
import SBKafkaMicro.organization_service.entity.Organization;
import SBKafkaMicro.organization_service.mapper.OrganizationMapper;
import SBKafkaMicro.organization_service.repository.OrganizationRepository;
import SBKafkaMicro.organization_service.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {


    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
