package ventegocreative.co.nz.gdgapp.model.mappers

import ventegocreative.co.nz.gdgapp.model.api.PetfinderResult
import ventegocreative.co.nz.gdgapp.model.data.Pet
import ventegocreative.co.nz.gdgapp.model.domain.Pet as PetDomain
import ventegocreative.co.nz.gdgapp.model.domain.PetList as PetListDomain

class PetDataDomainMapper {

    fun getFromData(result: PetfinderResult): PetListDomain {
        return PetListDomain(convertPetListToDomain(result.petfinder.pets.pet))
    }

    private fun convertPetListToDomain(list: List<Pet>): List<PetDomain> {
        return list.map { convertPetItemToDomain(it) }
    }

    private fun convertPetItemToDomain(pet: Pet): PetDomain {
        return PetDomain(pet.age,pet.size,pet.id,pet.name,pet.sex,pet.animal)
    }
}


