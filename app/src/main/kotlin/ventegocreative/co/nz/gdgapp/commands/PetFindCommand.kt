package ventegocreative.co.nz.gdgapp.commands

import ventegocreative.co.nz.gdgapp.model.api.PetfinderRequest
import ventegocreative.co.nz.gdgapp.model.domain.PetList
import ventegocreative.co.nz.gdgapp.model.mappers.PetDataDomainMapper

class PetFindCommand(val zipCode: String, val animal: String): Command<PetList> {

    override fun execute(): PetList {
        return PetDataDomainMapper().getFromData(PetfinderRequest(zipCode,animal).send())
    }
}

