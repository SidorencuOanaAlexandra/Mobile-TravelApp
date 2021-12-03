package com.example.crud.repo

import com.example.crud.domain.TravelPlace

class Repository {
    val list_TravelPlaces = mutableListOf<TravelPlace>(
        TravelPlace("1","Castelul Corvinilor","Hunedoara","45","22","Castelul Corvinilor, numit și Castelul Huniazilor sau al Hunedoarei, este cetatea medievală a Hunedoarei, unul din cele mai importante monumente de arhitectură gotică din România.\n" +
                "\n" +
                "Este considerat unul dintre cele mai frumoase castele din lume, fiind situat în „top 10 destinații de basm din Europa”","10:00-16:00 L-S","https://www.descopera.ro/wp-content/uploads/2021/05/castelul-corvinilor-hunedoara-shutter_descopera-3-scaled.jpg"),
        TravelPlace("2","Castelul Peles","Sinaia","45","25","Castelul Peleș este un palat din Sinaia, construit între anii 1873 și 1914. Construită ca reședință de vară a regilor României, clădirea se află, în prezent, în proprietatea Familiei Regale a României și adăpostește Muzeul Național Peleș.",
            "10:00-16:00 L-V","https://andragheorghe.files.wordpress.com/2013/10/1.jpg?w=1180"),
        TravelPlace("3","Muzeul Național de Istorie a Transilvaniei","Cluj","46","23",
            "Muzeul Național de Istorie a Transilvaniei, din Cluj-Napoca, situat pe str. Constantin Daicoviciu nr. 2, în clădirea cunoscută și drept Casa Petrechevich-Horvath este continuatorul primei asociații muzeale din Transilvania, Societatea Muzeului Ardelean, " +
                    "înființată la 23 noiembrie 1859, dispunând de colecții bogate de antichități, mineralogie, botanică, o pinacotecă, o " +
                    "colecție etnografică și zoologie.",
            "10:00-16:00 L-V","https://andragheorghe.files.wordpress.com/2013/10/1.jpg?w=1180"),

        TravelPlace("4","Grădina Botanică Alexandru Borza","Cluj","46","23",
            "Întinsă pe o suprafață de aproape 14 hectare, în partea sudică a Clujului, grădina botanică, " +
                    "organizată după Unirea Transilvaniei cu România, în anii activității de așezare pe temeiuri solide a universității clujene, a reușit să se dezvolte în timp atât " +
                    "ca și un obiectiv turistic clujean cât și ca important spațiu didactic și științific din cadrul Universității Babeș-Bolyai.",
            "10:00-16:00 S-D","https://castrumclusblog.files.wordpress.com/2017/02/gradina-botanica-cluj_23229040.jpg"),
        TravelPlace("5","Parcul Central Cluj","Cluj","46","23",
            "Muzeul Național de Istorie a Transilvaniei, din Cluj-Napoca, situat pe str. Constantin Daicoviciu nr. 2, în clădirea cunoscută și drept Casa Petrechevich-Horvath este continuatorul primei asociații muzeale din Transilvania, Societatea Muzeului Ardelean, " +
                    "înființată la 23 noiembrie 1859, dispunând de colecții bogate de antichități, mineralogie, botanică, o pinacotecă, o " +
                    "colecție etnografică și zoologie.",
            "10:00-16:00 L-V","https://cluj-napoca.xyz/media/places-to-visit/tourism/central-park/parcul-central.jpg"),

        )


    fun getAllData() = list_TravelPlaces;

    fun getTravelPlaceWithId(id_place: String) : TravelPlace{
        for( item in list_TravelPlaces){
            if(item.id == id_place)
                return item
        }
        return TravelPlace("","","","","","","","");
    }

    fun Update(id:String, new_item:TravelPlace){
        for( i in list_TravelPlaces.indices){
            if(list_TravelPlaces[i].id == new_item.id) {
                list_TravelPlaces[i] = new_item
            }
        }
    }

    fun Add(new_item: TravelPlace){
        var max = 0;
        for( i in list_TravelPlaces.indices){
            if(list_TravelPlaces[i].id.toInt() > max) {
                max = list_TravelPlaces[i].id.toInt()
            }
        }
        new_item.id = (max+1).toString()
        list_TravelPlaces.add(new_item)
    }

    fun Remove(id:String){
        var poz = -1
        for( i in list_TravelPlaces.indices){
            if(list_TravelPlaces[i].id == id) {
                poz = i;
            }
        }
        list_TravelPlaces.removeAt(poz)
    }
}