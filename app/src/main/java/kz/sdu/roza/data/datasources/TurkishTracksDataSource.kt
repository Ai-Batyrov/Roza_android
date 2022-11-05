package kz.sdu.roza.data.datasources

import kz.sdu.roza.data.models.Track

class TurkishTracksDataSource {
    private val list = listOf(
        Track("uiid-1", "Her Gece", "Mirkelam", "/url/img.png"),
        Track("uiid-1", "Kar Beyazdır Ölüm", "Kerim Tekin", "/url/img.png"),
        Track("uiid-1", "İçimde Ölen Biri Var", "Ahmet Kaya", "/url/img.png"),
        Track("uiid-1", "Bir Sevmek Bin Defa Ölmekmiş", "Üç Hürel", "/url/img.png"),
        Track("uiid-1", "Hasretinle Yandı Gönlüm", "Seha Okuş", "/url/img.png"),
        Track("uiid-1", "Bir Çocuk Sevdim", "Sezen Aksu", "/url/img.png"),
        Track("uiid-1", "Ruh", "Rehber", "/url/img.png"),
        Track("uiid-1", "İstikrarlı Hayal", "Gaye Su Akyol", "/url/img.png"),
        Track("uiid-1", "Amanın Leyla", "Neşet Ertaş", "/url/img.png"),
        Track("uiid-1", "Unutamadım", "Müslüm Gürses", "/url/img.png"),
        Track("uiid-1", "Dalgalandım da Duruldum", "Müzeyyen Senar", "/url/img.png"),
        Track("uiid-1", "Bu Kalp Seni Unutur mu?", "Fikret Kızılok", "/url/img.png"),
        Track("uiid-1", "Resimdeki Gözyaşları", "Cem Karaca", "/url/img.png"),
        Track("uiid-1", "Dönence", "Barış Manço", "/url/img.png"),
        Track("uiid-1", "Arnavut Kaldırımı", "Demet Sağıroğlu", "/url/img.png"),
        Track("uiid-1", "Sevince", "Erkin Koray", "/url/img.png"),
        Track("uiid-1", "Oynama Şıkıdım", "Tarkan", "/url/img.png"),
        Track("uiid-1", "Bir Derdim Var", "Mor ve Ötesi", "/url/img.png"),
        Track("uiid-1", "Yaz Gazeteci", "Selda Bağcan", "/url/img.png"),
        Track("uiid-1", "Ben Şarkımı Söylerken", "Şebnem Ferah", "/url/img.png"),
        Track("uiid-1", "Summertime", "Cem Adrian", "/url/img.png"),
        Track("uiid-1", "Everything That I Can", "Sertab Erener", "/url/img.png"),
        Track("uiid-1", "Güneş Toğla Benim İçin", "Ali İhsan", "/url/img.png"),
        Track("uiid-1", "Here I am Zeki Müren", "Zeki Müren", "/url/img.png"),
        Track("uiid-1", "Geççek", "TARKAN", "/url/img.png"),
        Track("uiid-1", "Canıma Minnet", "Sakiler", "/url/img.png"),
    )

    fun loadTracks(): List<Track> {
        return list
    }
}
