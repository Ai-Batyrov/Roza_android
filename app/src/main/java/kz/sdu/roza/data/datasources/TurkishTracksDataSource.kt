package kz.sdu.roza.data.datasources

import kz.sdu.roza.data.models.Track

class TurkishTracksDataSource {
    private val list = listOf<Track>(
        Track("Her Gece", "Mirkelam"),
        Track("Kar Beyazdır Ölüm", "Kerim Tekin"),
        Track("İçimde Ölen Biri Var", "Ahmet Kaya"),
        Track("Bir Sevmek Bin Defa Ölmekmiş", "Üç Hürel"),
        Track("Hasretinle Yandı Gönlüm", "Seha Okuş "),
        Track("Bir Çocuk Sevdim", "Sezen Aksu"),
        Track("Ruh", "Rehber"),
        Track("İstikrarlı Hayal", "Gaye Su Akyol"),
        Track("Amanın Leyla", "Neşet Ertaş"),
        Track("Unutamadım", "Müslüm Gürses"),
        Track("Dalgalandım da Duruldum", "Müzeyyen Senar"),
        Track("Bu Kalp Seni Unutur mu?", "Fikret Kızılok"),
        Track("Resimdeki Gözyaşları", "Cem Karaca"),
        Track("Dönence", "Barış Manço"),
        Track("Arnavut Kaldırımı", "Demet Sağıroğlu"),
        Track("Sevince", "Erkin Koray"),
        Track("Oynama Şıkıdım", "Tarkan"),
        Track("Bir Derdim Var", "Mor ve Ötesi"),
        Track("Yaz Gazeteci", "Selda Bağcan"),
        Track("Ben Şarkımı Söylerken", "Şebnem Ferah"),
        Track("Summertime", "Cem Adrian"),
        Track("Everything That I Can", "Sertab Erener"),
        Track("Güneş Toğla Benim İçin", "Ali İhsan"),
        Track("Here I am Zeki Müren", "Zeki Müren"),
        Track("Geççek", "TARKAN"),
        Track("Canıma Minnet", "Sakiler"),
    )

    fun loadTracks(): List<Track> {
        return list
    }
}