package ventegocreative.co.nz.gdgapp.model.mappers

class PetDataSexMapper {

    companion object {

        fun petSexShortFullMapper(shortSex:String):String {
            when (shortSex) {
                "M" -> return "Male"
                "F" -> return "Female"
            }

            return "Unspecified"
        }

    }
}


