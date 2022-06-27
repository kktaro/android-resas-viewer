package com.example.androidresasviewer.model.remote_data_source

import android.util.Log
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ResasApiClientTest {
    @Test
    fun `都道府県一覧取得`() {
        val resasApiClient = ResasApiClientModule().provideResasApiClient(ResasApiClientProvider())
        runBlocking {
            val response = resasApiClient.getPrefectures()
            if (!response.isSuccessful) {
                assert(false)
            } else {
                val correctPrefectures = Prefectures(
                    result = listOf(
                        Prefecture(1,"北海道"),
                        Prefecture(2,"青森県"),
                        Prefecture(3,"岩手県"),
                        Prefecture(4,"宮城県"),
                        Prefecture(5,"秋田県"),
                        Prefecture(6,"山形県"),
                        Prefecture(7,"福島県"),
                        Prefecture(8,"茨城県"),
                        Prefecture(9,"栃木県"),
                        Prefecture(10,"群馬県"),
                        Prefecture(11,"埼玉県"),
                        Prefecture(12,"千葉県"),
                        Prefecture(13,"東京都"),
                        Prefecture(14,"神奈川県"),
                        Prefecture(15,"新潟県"),
                        Prefecture(16,"富山県"),
                        Prefecture(17,"石川県"),
                        Prefecture(18,"福井県"),
                        Prefecture(19,"山梨県"),
                        Prefecture(20,"長野県"),
                        Prefecture(21,"岐阜県"),
                        Prefecture(22,"静岡県"),
                        Prefecture(23,"愛知県"),
                        Prefecture(24,"三重県"),
                        Prefecture(25,"滋賀県"),
                        Prefecture(26,"京都府"),
                        Prefecture(27,"大阪府"),
                        Prefecture(28,"兵庫県"),
                        Prefecture(29,"奈良県"),
                        Prefecture(30,"和歌山県"),
                        Prefecture(31,"鳥取県"),
                        Prefecture(32,"島根県"),
                        Prefecture(33,"岡山県"),
                        Prefecture(34,"広島県"),
                        Prefecture(35,"山口県"),
                        Prefecture(36,"徳島県"),
                        Prefecture(37,"香川県"),
                        Prefecture(38,"愛媛県"),
                        Prefecture(39,"高知県"),
                        Prefecture(40,"福岡県"),
                        Prefecture(41,"佐賀県"),
                        Prefecture(42,"長崎県"),
                        Prefecture(43,"熊本県"),
                        Prefecture(44,"大分県"),
                        Prefecture(45,"宮崎県"),
                        Prefecture(46,"鹿児島県"),
                        Prefecture(47,"沖縄県"),
                    )
                )
                assert(response.body() == correctPrefectures)
            }
        }
    }

    @Test
    fun `北海道総人口取得`() {
        val resasApiClient = ResasApiClientModule().provideResasApiClient(ResasApiClientProvider())
        runBlocking {
            val response = resasApiClient.getComposition(1)
            if (!response.isSuccessful) {
                assert(false)
            } else {
                val compositions =response.body()!!.compositions.data[0]
                val correctCompositions = Compositions(
                    label = "総人口",
                    data = listOf(
                        Composition(year = 1960, population = 5039206),
                        Composition(year = 1965, population = 5171800),
                        Composition(year = 1970, population = 5184287),
                        Composition(year = 1975, population = 5338206),
                        Composition(year = 1980, population = 5575989),
                        Composition(year = 1985, population = 5679439),
                        Composition(year = 1990, population = 5643647),
                        Composition(year = 1995, population = 5692321),
                        Composition(year = 2000, population = 5683062),
                        Composition(year = 2005, population = 5627737),
                        Composition(year = 2010, population = 5506419),
                        Composition(year = 2015, population = 5381733),
                        Composition(year = 2020, population = 5216615),
                        Composition(year = 2025, population = 5016554),
                        Composition(year = 2030, population = 4791592),
                        Composition(year = 2035, population = 4546357),
                        Composition(year = 2040, population = 4280427),
                        Composition(year = 2045, population = 4004973),
                    )
                )
                print(compositions.toString())
                assert(compositions == correctCompositions)
            }
        }
    }
}