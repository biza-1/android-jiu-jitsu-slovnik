package cz.matejbiza.jiu_jitsuslovnik

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "slovnik"
val TABLE_NAME = "slovicka"
val COL_ID = "ID"
val COL_japanese = "japanese"
val COL_czech = "czech"
val COL_type = "type"
val COL_content = "content"



class DataBaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_japanese + " VARCHAR(255)," +
                COL_czech + " VARCHAR(255)," +
                COL_type + " VARCHAR(255)," +
                COL_content + " TEXT)"
        db?.execSQL(createTable)
        val sql = """ INSERT INTO """+TABLE_NAME + """ ("""+COL_ID+""", """+COL_japanese+""", """+COL_czech+""", """+COL_type+""", """+COL_content+""") VALUES
                (2, 'Bushi', 'Válečník', 'slovíčko', '<p>Válečník, bojovník, původní výraz pro příslušníka japonské vojenské šlechty - samuraje.</p>'),
        (3, 'Bushido', 'Cesta válečníka', 'slovíčko', '<p>Cesta válečníka, etický kodex bushi, tedy samurajů, který zdůrazňoval čest, odvahu, oddanost, povinnost a poslušnost.</p>'),
        (4, 'Budo', 'Cesta boje', 'slovíčko', '<p> Doslova cesta boje, název pro japonská bojová umění, se zřetelem na duchovní význam cvičení, tedy protiklad k bujutsu, kde je hlavní zřetel kladen na bojovou účelnost. Nejznámějšími z nich jsou: judo, aikido, karatedo, kendo, iaido, jodo, kyudo, kobudo. V širším významu všechna japonská bojová umění, tedy jak budo, tak bujutsu. V nejširším přeneseném významu všechna bojová umění.</p>'),
        (5, 'Bujutsu', 'Bojové dovednosti', 'slovíčko', '<p>doslova umění válečníka, umění boje, nejvýstižněji bojové dovednosti (umění ve smyslu dovednost), předchůdce budo, hlavní význam v bujutsu má účelnost bojových technik. Nejznámějšími z nich jsou: jujutsu, aikijutsu, kenjutsu, iaijutsu</p>'),
        (6, 'Bugei', 'Válečnictví', 'slovíčko', '<p>válečnictví, válečnické znalosti, jiný výraz pro bujutsu</p>'),
        (7, 'Bujin', 'Válečník', 'slovíčko', '<p>válečník, doslova válečný člověk, jiný výraz pro bushi</p>'),
        (8, 'Buke', 'Válečnická rodina', 'slovíčko', '<p>válečnická rodina, válečnický klan</p>'),
        (9, 'Dó', 'Cesta', 'slovíčko', '<p>cesta, výraz používaný pro duchovní význam bojového umění</p>'),
        (11, 'Tachi mae ukemi', 'Pád vpřed', 'ukemi waza - techniky pádů', '<p></p>'),
        (12, 'Tachi ushiro ukemi', 'Pád vzad', 'ukemi waza - techniky pádů', '<p></p>'),
        (13, 'Tachi yoko ukemi', 'Pád stranou', 'ukemi waza - techniky pádů', '<p></p>'),
        (14, 'Kamae', 'Bojový postoj', 'shizei - postoje', '<p>Postavíte se do postoje s jednou nohou vepředu a druhou vzadu. Nohy jsou stejně široko jako ramena.</p>'),
        (15, 'Hidary', 'Levá strana', 'slovíčko', '<p></p>'),
        (16, 'Migi', 'Pravá strana', 'slovíčko', '<p></p>'),
        (17, 'Shiko dachi', 'Shiko dachi', 'shizei - postoje', '<p>postavíte se s oběma nohama rozkročenýma a v podstatě uděláte dřep</p>'),
        (18, 'Ryu', 'Škola', 'slovíčko', '<p>škola, směr, styl</p>'),
        (19, 'Dójó', 'Tělocvična', 'slovíčko', '<p>místo, kde se cvičí bojová umění, doslova místnost pro cestu</p>'),
        (20, 'Honbu dojo', 'Domovské dojo', 'slovíčko', '<p>domovské dojo (tělocvična), tedy takové dojo, v kterém vyučuje vedoucí představitel daného stylu či školy</p>'),
        (21, 'Budokan', 'Centrum pro výuku budo', 'slovíčko', '<p></p>'),
        (22, 'Budoka', 'Cvičitel bojových umění (budo)', 'slovíčko', '<p></p>'),
        (23, 'Karateka', 'Cvičitel karate', 'slovíčko', '<p></p>'),
        (24, 'Aikidoka', 'Cvičitel aikida', 'slovíčko', '<p></p>'),
        (25, 'Judoka', 'Cvičitel juda', 'slovíčko', '<p></p>'),
        (26, 'Gi', 'Oblek na cvičení budo', 'slovíčko', '<p>oblek na cvičení budo, lidově též nazývaný kimono</p>'),
        (27, 'Kimono', 'Oblek na cvičení budo', 'slovíčko', '<p>oblek na cvičení budo, správně nazívané gi</p>'),
        (28, 'Obi', 'Pás nošený ke gi', 'slovíčko', '<p>Pás nošený ke gi (kimono).\r</p>'),
        (29, 'Hakama', 'Sukně připomínající kalhoty', 'slovíčko', '<p>Široké plizované kalhoty, které se nosí v některých stylech bojového umění přes spodní kalhoty od gi.\r</p>'),
        (30, 'Kyu', 'Žákovský stupeň technické vyspělosti', 'slovíčko', '<p>Žákovský stupeň technické vyspělosti, označovaný barevnými pásy obi kromě černého.\r</p>'),
        (31, 'Dan', 'Mistrovský stupeň technické vyspělosti', 'slovíčko', '<p>mistrovský stupeň technické vyspělosti označovaný černým pásem</p>'),
        (32, 'Yudansha', 'Nositel technického stupně dan', 'slovíčko', '<p></p>'),
        (33, 'Mudansha', 'Cvičenec bez danu', 'slovíčko', '<p>cvičenec který není nositelem stupně dan</p>'),
        (34, 'Renshi', 'Asistent učitele', 'slovíčko', '<p>Nejnižší z trojice tradičních učitelských stupňů renshi, kioshi, hanshi, který znamenal asistenta učitele. Pro jeho získání je zpravidla podmínkou alespoň šestý dan.</p>'),
        (35, 'Kioshi', 'Učitel', 'slovíčko', '<p>Prostřední z trojice tradičních učitelských stupňů renshi, kioshi, hanshi, který znamenal učitele. Pro jeho získání je zpravidla podmínkou alespoň sedmý dan.</p>'),
        (36, 'Sensei', 'Učitel', 'slovíčko', '<p>Učitel, oslovení učitele - instruktora v bojovém umění.\r</p>'),
        (37, 'Senpai', 'Starší student', 'slovíčko', '<p>Student, který má vyšší pásek a více zkušeností.</p>'),
        (38, 'Hanshi', 'Mistr', 'slovíčko', '<p>Nejvyšší z trojice tradičních učitelských stupňů renshi, kioshi, hanshi, který znamenal mistra. Pro jeho získání je zpravidla podmínkou alespoň osmý dan.</p>'),
        (39, 'Shihan', 'Mistr', 'slovíčko', '<p></p>'),
        (40, 'Kamiza', 'Čestné místo v dojo', 'slovíčko', '<p></p>'),
        (41, 'Shinza', 'Čestné místo v dójó', 'slovíčko', '<p>Čestné místo v dójó, zpravidla prezentované shintoistickým oltáříkem.</p>'),
        (42, 'Zanshin', 'bdělost', 'slovíčko', '<p>Bdělost, připravenost, stav bdělé mysli.</p>'),
        (43, 'Ki', 'Vnitří sílá', 'slovíčko', '<p>Vnitřní síla, duch, vnitřní energie člověka.</p>'),
        (44, 'Kime', 'Soustředění energie do jediného bodu', 'slovíčko', '<p>Ohnisko, bod, zpevnění těla v závěru techniky a soustředění veškeré energie do tohoto jediného bodu.</p>'),
        (45, 'Kiai', 'Bojový výkřik', 'slovíčko', '<p></p>'),
        (46, 'Maai', 'Vzdálenost mezi soupeři', 'slovíčko', '<p></p>'),
        (47, 'Kihon', 'Základní techniky', 'slovíčko', '<p></p>'),
        (48, 'Kihon ido', 'Cvičení základní techniky v pohybu', 'slovíčko', '<p></p>'),
        (49, 'Kata', 'Forma', 'slovíčko', '<p>Forma, předem určená a přesně předepsaná forma nácviku.</p>'),
        (50, 'Kumite', 'Zápas', 'slovíčko', '<p>Cvičný zápas s partnerem, zápas.</p>'),
        (51, 'Bu', 'Válečník', 'slovíčko', '<p>Válečník, bojovník, původní výraz pro příslušníka japonské vojenské šlechty - samuraje.</p>'),
        (64, 'Yakusoku kumite', 'Cvičení s dohodnutými technikami', 'slovíčko', '<p>Předem dohodnuté cvičení s partnerem, jsou dohodnuty techniky, případně způsob.</p>'),
        (65, 'Jiyu kumite', 'Volné cvičení', 'slovíčko', '<p>Volné, předem nedohodnuté cvičení s partnerem, volný zápas.</p>'),
        (66, 'Kihon kumite', 'Základní cvičení s partnerem', 'slovíčko', '<p>Základní kumite, tedy základní cvičeni s partnerem, může se jednat o kumite, kde jsou použity techniky v základní podobě, tedy ve formě kihon, nebo o kumite které tvoří základ daného stylu.</p>'),
        (67, 'Ippon kumite', 'Zápas na jeden zásah', 'slovíčko', '<p>Kumite na jeden krok, tedy kumite jedinou akcí.</p>'),
        (68, 'Kihon ippon kumite', 'Zápas s jedním útokem a jednou obrannou', 'slovíčko', '<p>Základní kumite na jeden krok.</p>'),
        (69, 'Gohon kumite', 'Zápas s pěti útoky', 'slovíčko', '<p>Kumite na pět kroků, útočník provede pět útoků, obránce provádí pouze obranu a až při posledním protiútok.</p>'),
        (70, 'Okuri kumite', 'Zápas se střídáním útoků a protiútoků', 'slovíčko', '<p>Kumite kdy útočník provede útok, obránce provede protiútok a útočník na něj opět reaguje s obranou a protiútokem.</p>'),
        (71, 'Happo kumite', 'Zápas proti více soupeřům', 'slovíčko', '<p>Kumite proti více útočníkům.</p>'),
        (72, 'Randori', 'Zápas s partnerem', 'slovíčko', '<p>Cvičení s partnerem, zápas, jiný výraz pro jiyu kumite.</p>'),
        (73, 'Shiai', 'Soutěžní zápas', 'slovíčko', '<p>Utkání, soutěžní zápas.</p>'),
        (74, 'Sun dome', 'Zastavení útoku těsně před cílem', 'slovíčko', '<p></p>'),
        (75, 'Bunkai', 'Aplikace technik se soupeřem v kata', 'slovíčko', '<p></p>'),
        (76, 'Embusen', 'Linie pohybu', 'slovíčko', '<p>Linie pohybu, půdorys v kata.</p>'),
        (77, 'Mae', 'Dopředu', 'slovíčko', '<p></p>'),
        (78, 'Yoko', 'Stranou', 'slovíčko', '<p></p>'),
        (79, 'Ushiro', 'Dozadu', 'slovíčko', '<p></p>'),
        (80, 'Gyaku', 'Opačný, protilehlý', 'slovíčko', '<p></p>'),
        (81, 'Irimi', 'Vstup do soupeře', 'slovíčko', '<p>Vstup do soupeře, pohyb směrem dovnitř.</p>'),
        (82, 'Seiza', 'Sed v kleku na patách', 'slovíčko', '<p></p>'),
        (83, 'Rei', 'Pozdrav úklonou', 'slovíčko', '<p></p>'),
        (84, 'Sensei ni rei', 'Pozdrav úklonou učiteli', 'slovíčko', '<p></p>'),
        (85, 'Shomen ni rei', 'Pozdrav úklonou Doju', 'slovíčko', '<p>Pozdrav úklonou Doju (tělocvičně) při příchodu a odchodu jako projev vděku za možnost cvičit.</p>'),
        (86, 'Shinza ni rei', 'Pozdrav úklonou čestnému místu', 'slovíčko', '<p></p>'),
        (87, 'Otaka ni rei', 'Pozdrav úklonou s partnerem', 'slovíčko', '<p></p>'),
        (88, 'Za rei', 'Pozdrav v sedu v kleku na patách', 'slovíčko', '<p></p>'),
        (89, 'Tori', 'Útočník', 'slovíčko', '<p>Osoba, která provádí techniku, útočí.</p>'),
        (90, 'Bogyo', 'Obrana', 'slovíčko', '<p></p>'),
        (91, 'Kokyu ho', 'Dechová cvičení', 'slovíčko', '<p></p>'),
        (92, 'Misogi', 'Duševní pročištění', 'slovíčko', '<p>Doslova duševní pročištění, očistné meditační a dechové cvičení.</p>'),
        (93, 'Nogare', 'Způsob dýchání', 'slovíčko', '<p>Plynulé dýchání s klidným výdechem.</p>'),
        (94, 'Ibuki', 'Způsob dýchání', 'slovíčko', '<p>Dýchání se zpevněním všech svalů těla.</p>'),
        (95, 'Tegatana', 'Mečová ruka', 'slovíčko', '<p>Takzvaná mečová ruka, malíková hrana ruky a předloktí používaná v boji obdobně jako meč.</p>'),
        (96, 'Tatami', 'Žíněnka', 'slovíčko', '<p>Žíněnka na cvičení, původně rohože z rýžové slámy.</p>'),
        (97, 'Tai', 'Tělo', 'slovíčko', '<p></p>'),
        (98, 'Men', 'Hlava, čelo', 'slovíčko', '<p></p>'),
        (99, 'Yokomen', 'Strana tváře', 'slovíčko', '<p>Strana tváře, většinou oblast spánku.</p>'),
        (100, 'Shomen', 'Přední', 'slovíčko', '<p>Předek, čelo</p>'),
        (101, 'Mune', 'Hrudník', 'slovíčko', '<p></p>'),
        (102, 'Hara', 'Podbřišek', 'slovíčko', '<p></p>'),
        (103, 'Seika tanden', 'Střed těla', 'slovíčko', '<p>Oblast podbřišku asi na dva prsty pod pupkem, pomyslný střed těla.</p>'),
        (104, 'Goshi', 'Bok', 'slovíčko', '<p></p>'),
        (105, 'Te', 'Ruka', 'slovíčko', '<p></p>'),
        (106, 'Seiken', 'Čelní úderová plocha pěsti', 'slovíčko', '<p>Čelo (předek) zavřené pěsti, respektive její první dva klouby, úderová plocha při úderu pěstí.</p>'),
        (107, 'Uraken', 'Hřbet zavřené pěsti', 'slovíčko', '<p>Hřbet zavřené pěsti, také označení úderu který se touto úderovou plochou provádí.</p>'),
        (108, 'Tetsui', 'Kladivo', 'slovíčko', '<p>Malíková strana zavřené pěsti, tzv. pěst kladivo. Jiný výraz pro kentsui.</p>'),
        (109, 'Kentsui', 'Kladivo', 'slovíčko', '<p>Malíková strana zavřené pěsti, tzv. pěst kladivo. Jiný výraz pro tetsui.</p>'),
        (110, 'Shutsui', 'Kladivo', 'slovíčko', '<p>Malíková strana zavřené pěsti, tzv. pěst kladivo. Jiný výraz pro tetsui.</p>'),
        (111, 'Teisho', 'Dlaň', 'slovíčko', '<p>Dlaň (pata dlaně) otevřené ruky.</p>'),
        (112, 'Shotei', 'Dlaň', 'slovíčko', '<p>Dlaň (pata dlaně) otevřené ruky. Jiný název pro teisho.</p>'),
        (113, 'Haishu', 'Hřbet otevřené ruky', 'slovíčko', '<p></p>'),
        (114, 'Shuto', 'Malíková hrana otevřené ruky', 'slovíčko', '<p>Malíková hrana otevřené ruky, tzv. mečová ruka.</p>'),
        (115, 'Haito', 'Palcová hrana otevřené ruky', 'slovíčko', '<p></p>'),
        (116, 'Seiryuto', 'Začátek malíkové hrany', 'slovíčko', '<p>Začátek malíkové hrany za zápěstím, tzv. volská čelist.</p>'),
        (117, 'Nukite', 'Špičky natažených prstů', 'slovíčko', '<p>Špičky natažených prstů, takzvaná ruka - kopí.</p>'),
        (118, 'Ippon nukite', 'Špička nataženého ukazováčku', 'slovíčko', '<p>Špička nataženého ukazováčku, tzv. jednoprstá ruka kopí.</p>'),
        (119, 'Nihon nukite', 'Špičky nataženého ukazováčku a prostředníčku', 'slovíčko', '<p>Špičky nataženého ukazováčku a prostředníčku, tzv. dvouprstá ruka kopí.</p>'),
        (120, 'Yonhon nukite', 'Špičky natažených prstů ukazováčku až malíčku', 'slovíčko', '<p>Špičky natažených prstů ukazováčku až malíčku, tzv. čtyřprstá ruka kopí.</p>'),
        (121, 'Hiraken', 'Poloviční pěst', 'slovíčko', '<p>Poloviční pěst, klouby prstů jen napůl zavřené pěsti.</p>'),
        (122, 'Ipponken', 'Pěst s vysunutým kloubem ukazováku', 'slovíčko', '<p>Pěst s vysunutým kloubem ukazováku, tzv. jednokloubová pěst.</p>'),
        (123, 'Nakadaka ipponken', 'Pěst s vysunutým kloubem prostředníku', 'slovíčko', '<p>Pěst s vysunutým kloubem prostředníku, tzv. jednokloubová pěst prostředníku.</p>'),
        (124, 'Kakuto', 'Vnější strana dovnitř ohnutého zápěstí', 'slovíčko', '<p></p>'),
        (125, 'Kumade', 'Medvědí tlapa', 'slovíčko', '<p>Dlaň včetně skrčených prstů, tzv. medvědí tlapa.</p>'),
        (126, 'Washide', 'Orlí ruka', 'slovíčko', '<p>Špičky prstů sevřených do špetky, tzv. orlí ruka, orlí zobák.</p>'),
        (127, 'Keito', 'Kuřecí hřebínek', 'slovíčko', '<p>Hrana ruky od zápěstí k palci, tzv. kuřecí hřebínek.</p>'),
        (128, 'Ken', 'Zavřená pěst', 'slovíčko', '<p></p>'),
        (129, 'Kaisho', 'Otevřená ruka', 'slovíčko', '<p></p>'),
        (130, 'Kote', 'Zápěstí', 'slovíčko', '<p></p>'),
        (131, 'Wan', 'Předloktí', 'slovíčko', '<p>Paže, respektive předloktí, jiný výraz pro ude.</p>'),
        (132, 'Wanto', 'Předloktí', 'slovíčko', '<p>Meč paže, předloktí, jiný výraz pro ude.</p>'),
        (133, 'Shubo', 'Předloktí', 'slovíčko', '<p>Předloktí, doslova hůl paže, jiný výraz pro wanto.</p>'),
        (134, 'Ude', 'Předloktí', 'slovíčko', '<p>Předloktí, jiný výraz pro wanto.</p>'),
        (135, 'Haiwan', 'Horní strana paže', 'slovíčko', '<p>Horní strana (hřbet) paže, respektive hřbet předloktí.</p>'),
        (136, 'Gaiwan', 'Vnější strana paže', 'slovíčko', '<p>Vnější strana paže, respektive vnější strana předloktí.</p>'),
        (137, 'Naiwan', 'Vnitřní strana paže', 'slovíčko', '<p>Vnitřní strana paže, respektive vnitřní strana předloktí.</p>'),
        (138, 'Shuwan', 'Spodní strana paže', 'slovíčko', '<p>Spodní strana paže, respektive spodní strana předloktí.</p>'),
        (139, 'Empi', 'Loket', 'slovíčko', '<p>Loket, úder loktem.</p>'),
        (140, 'Hiji', 'Loket', 'slovíčko', '<p>Loket, úder loktem, jiný výraz pro empi.</p>'),
        (141, 'Koshi', 'Bříško chodidel za prsty', 'slovíčko', '<p></p>'),
        (142, 'Josokutei', 'Bříško chodidel za prsty.', 'slovíčko', '<p>Tzv. zvednutá noha, jiný výraz pro koshi.</p>'),
        (143, 'Sokute', 'Malíková hrana nohy', 'slovíčko', '<p>Malíková hrana nohy, tzv. mečová noha.</p>'),
        (144, 'Kakato', 'Pata', 'slovíčko', '<p></p>'),
        (145, 'Ensho', 'Pata', 'slovíčko', '<p>Kulatá pata, jiný výraz pro kakato.</p>'),
        (146, 'Haisoku', 'Nárt', 'slovíčko', '<p></p>'),
        (147, 'Sokutei', 'Chodidlo', 'slovíčko', '<p></p>'),
        (148, 'Tsumasaki', 'Špičký prstů nohy', 'slovíčko', '<p></p>'),
        (149, 'Hiza', 'Koleno', 'slovíčko', '<p></p>'),
        (150, 'Hizagashira', 'Koleno', 'slovíčko', '<p>Koleno, jiný výraz pro hiza.</p>'),
        (151, 'Shitsui', 'Koleno', 'slovíčko', '<p>Koleno, jiný výraz pro hiza, doslova kolenní kladivo.</p>'),
        (152, 'Jodan', 'Horní pásmo', 'slovíčko', '<p>Horní pásmo - hlava a krk.</p>'),
        (153, 'Chudan', 'Střední pásmo', 'slovíčko', '<p>Střední pásmo - od pasu ke krku.</p>'),
        (154, 'Gedan', 'Spodní pásmo', 'slovíčko', '<p>Spodní pásmo - od pasu dolů.</p>'),
        (155, 'Jodan uke', 'Kryt na horní pásmo', 'uke waza - techniky krytů', '<p></p>'),
        (156, 'Chudan uke', 'Kryt na střední pásmo', 'uke waza - techniky krytů', '<p></p>'),
        (157, 'Gedan uke', 'Kryt na spodní pásmo', 'uke waza - techniky krytů', '<p></p>'),
        (158, 'Atemi', 'Úder', 'slovíčko', '<p>Úder, rána, rozdrcení.</p>'),
        (159, 'Kansetsu', 'Páka', 'slovíčko', '<p>Páčení, páka.</p>'),
        (160, 'Nage', 'Hod', 'slovíčko', '<p>Hod, podraz.</p>'),
        (161, 'Tobi', 'Skok', 'slovíčko', '<p></p>'),
        (162, 'Cuki', 'Úder', 'slovíčko', '<p>Přímý uder, úder jehož dráha je shodná s osou předloktí, často je termínem cuki označován přímý úder zavřenou pěstí, takzvané seiken cuki, i když to je vlastně pouze jeden druh cuki.</p>'),
        (163, 'Uchi', 'Sek', 'slovíčko', '<p>Sek, úder jehož dráha jde po oblouku v určitém úhlu k ose předloktí.</p>'),
        (164, 'Geri', 'Kop', 'slovíčko', '<p></p>'),
        (165, 'Keri', 'Kop', 'slovíčko', '<p></p>'),
        (166, 'Uke', 'Kryt', 'slovíčko', '<p>Kryt, ten co se brání proti technice.</p>'),
        (167, 'Osae', 'Ovládnutí', 'slovíčko', '<p>Ovládnutí, kontrola tlačením.</p>'),
        (168, 'Zhime', 'Škrcení', 'slovíčko', '<p></p>'),
        (169, 'Waza', 'Technika', 'slovíčko', '<p></p>'),
        (170, 'Ukemi', 'Pád', 'slovíčko', '<p></p>'),
        (171, 'Kiri', 'Sek', 'slovíčko', '<p>Sek, respektive řez mečem.</p>'),
        (172, 'Giri', 'Sek', 'slovíčko', '<p>Sek, respektive řez mečem.</p>'),
        (173, 'Kuzushi', 'Vychýlení soupeře', 'slovíčko', '<p></p>'),
        (174, 'Yoi', 'Pozor', 'slovíčko', '<p>Pozor, připravte se.</p>'),
        (175, 'Hajime', 'Začněte', 'slovíčko', '<p></p>'),
        (176, 'Yame', 'Zastavte', 'slovíčko', '<p>Přerušte, zastavte cvičení.</p>'),
        (177, 'Mate', 'Zastavte', 'slovíčko', '<p>Přerušte, zastavte cvičení.</p>'),
        (178, 'Mawate', 'Otočte se', 'slovíčko', '<p></p>'),
        (179, 'Suzukete', 'Pokračujte', 'slovíčko', '<p></p>'),
        (180, 'Ichi', 'Jedna', 'slovíčko', '<p></p>'),
        (181, 'NI', 'Dva', 'slovíčko', '<p></p>'),
        (182, 'San', 'Tři', 'slovíčko', '<p></p>'),
        (183, 'Shi', 'Čtyři', 'slovíčko', '<p></p>'),
        (184, 'Go', 'Pět', 'slovíčko', '<p></p>'),
        (185, 'Roku', 'Šest', 'slovíčko', '<p></p>'),
        (186, 'Schichi', 'Sedm', 'slovíčko', '<p></p>'),
        (187, 'Hachi', 'Osm', 'slovíčko', '<p></p>'),
        (188, 'Ju', 'Deset', 'slovíčko', '<p></p>'),
        (189, 'Age uke', 'Druh krytu na horní pásmo', 'uke waza - techniky krytů', '<p></p>'),
        (190, 'Soto uke ', 'Vnější kryt', 'uke waza - techniky krytů', '<p>Vnější kryt, jiný výraz pro soto ude uke.</p>'),
        (191, 'Uchi uke', 'Vnitřní tkryt', 'uke waza - techniky krytů', '<p>Vnitřní kryt, jiný výraz pro uchi ude uke.</p>'),
        (192, 'Shuto uke', 'Kryt malíkovou hranou', 'uke waza - techniky krytů', '<p>Kryt malíkovou hranou, tzv. kryt mečovou rukou.</p>'),
        (193, 'Tato shuto uke', 'Kryt malíkovou hranou vertikálně (svisle)', 'uke waza - techniky krytů', '<p>Kryt malíkovou hranou ve vertikální poloze.</p>'),
        (194, 'Gedan Barai', 'Kryt na spodní pásmo', 'uke waza - techniky krytů', '<p>Doslova spodní zametení, druh krytu na spodní pásmo.</p>'),
        (195, 'Mawashi uke', 'Kryt oběma rukama najednou', 'uke waza - techniky krytů', '<p>Kruhový kryt oběma rukama najednou.</p>'),
        (196, 'Juji uke', 'Kryt překřížením rukou', 'uke waza - techniky krytů', '<p>Kryt ve tvaru písmene X překřížením rukou.</p>'),
        (197, 'Morote uke', 'Dvojitý kryt podpořený druhou rukou', 'uke waza - techniky krytů', '<p></p>'),
        (198, 'Osae uke', 'Kryt stlačením rukou', 'uke waza - techniky krytů', '<p>Kryt stlačením dolů dlaní nebo malíkovou hranou ruky.</p>'),
        (199, 'Te osae uke', 'Kryt stlačením rukou', 'uke waza - techniky krytů', '<p>Kryt stlačením dolů dlaní nebo malíkovou hranou ruky. Jiný výraz pro osae uke.</p>'),
        (200, 'Otoshi uke', 'Kryt sražením dolů', 'uke waza - techniky krytů', '<p></p>'),
        (201, 'Kake uke', 'Kryt zahákováním', 'uke waza - techniky krytů', '<p>Kryt zahákováním, při kterém je útočníkova končetina kontrolována pomocí ruky ohnuté do háku.</p>'),
        (202, 'Shuto kake uke', 'Kryt zahákováním malíkovou hranou ruky', 'uke waza - techniky krytů', '<p></p>'),
        (203, 'Tekubi kake uke', 'Kryt zahákování pěsti s ohnutým zápěstím', 'uke waza - techniky krytů', '<p>Kryt zahákováním pěstí s ohnutým zápěstím za hřbetem.</p>'),
        (204, 'Kakiwake uke', 'Dvojitý kryt ze středu ven', 'uke waza - techniky krytů', '<p>Dvojitý kryt ze středu ven, kryt roztažením.</p>'),
        (205, 'Kakiwake shuto uke', 'Kryt kakiwake uke malíkovými hranami', 'uke waza - techniky krytů', '<p>Kryt kakiwake uke malíkovými hranami otevřených rukou.</p>'),
        (206, 'Ude uke', 'Kryt předloktím', 'uke waza - techniky krytů', '<p></p>'),
        (207, 'Soto ude uke', 'Vnitřní kryt předloktím', 'uke waza - techniky krytů', '<p></p>'),
        (208, 'Uchi ude uke', 'Vnitřní kryt předloktím', 'uke waza - techniky krytů', '<p></p>'),
        (209, 'Haishu  uke', 'Kryt hřbetem ruky', 'uke waza - techniky krytů', '<p></p>'),
        (210, 'Teisho uke', 'Kryt otevřenou dlaní', 'uke waza - techniky krytů', '<p></p>'),
        (211, 'Nagashi uke', 'Plynulý kryt smetením', 'uke waza - techniky krytů', '<p>Plynulý kryt smetením - odchýlením.</p>'),
        (212, 'Haiwan nagashi uke', 'Kryt smetením hřbetem předloktí', 'uke waza - techniky krytů', '<p></p>'),
        (218, 'Te nagashi uke', 'Kryt smetením rukou', 'uke waza - techniky krytů', '<p>Kryt smetením rukou (dlaní).</p>'),
        (219, 'Seiryuto uke', 'Kryt hranou ruky seriyuto', 'uke waza - techniky krytů', '<p></p>'),
        (220, 'Keito uke', 'Kryt hranou ruy keito', 'uke waza - techniky krytů', '<p>Kryt hranou ruky keito, s do strany ohnutým zápěstím.</p>'),
        (221, 'Sukui uke', 'Kryt podebráním ', 'uke waza - techniky krytů', '<p>Kryt podebráním, popotažením, zachycením.</p>'),
        (222, 'Sho sukui uke', 'Kryt podebráním dlaní', 'uke waza - techniky krytů', '<p></p>'),
        (223, 'Maeude deai osae uke', 'Kryt stlačením předloktí', 'uke waza - techniky krytů', '<p></p>'),
        (224, 'Maeude hineri uke', 'kryt otočením předloktí', 'uke waza - techniky krytů', '<p></p>'),
        (225, 'Sokumen awase uke', 'Kombinovaný kryt oběma rukama stranou', 'uke waza - techniky krytů', '<p></p>'),
        (231, 'Teisho awase uke', 'Dvojitý kryt spojenými dlaněmi.', 'uke waza - techniky krytů', '<p></p>'),
        (232, 'Tsukami uke', 'Kryt držením', 'uke waza - techniky krytů', '<p></p>'),
        (233, 'Ryosho tsukami uke', 'Kryt držením oběma rukama', 'uke waza - techniky krytů', '<p></p>'),
        (234, 'Sokutei mawashi uke', 'Obloukový kryt chodidlem', 'uke waza - techniky krytů', '<p></p>'),
        (235, 'Sokutei osae uke', 'Kryt stlačením chodidlem', 'uke waza - techniky krytů', '<p></p>'),
        (236, 'Sokuto osae uke', 'Kryt stlačením hranou nohy', 'uke waza - techniky krytů', '<p></p>'),
        (237, 'Sokubo kake uke', 'Kryt holení záhákováním', 'uke waza - techniky krytů', '<p></p>'),
        (238, 'Ashikubi keke uke', 'Kryt kotníkem pomocí zahákování', 'uke waza - techniky krytů', '<p></p>'),
        (239, 'Mae geri', 'Kop vpřed', 'geri waza - techniky kopů', '<p></p>'),
        (240, 'Yoko geri', 'Kop stranou', 'geri waza - techniky kopů', '<p></p>'),
        (241, 'Sokuto geri', 'Kop stranou', 'geri waza - techniky kopů', '<p>Kop stranou, jiný název pro yoko geri</p>'),
        (242, 'Ushiro geri', 'Kop vzad', 'geri waza - techniky kopů', '<p></p>'),
        (243, 'Mawashi geri', 'Obloukový kop', 'geri waza - techniky kopů', '<p></p>'),
        (244, 'Ura mawashi geri', 'Obloukový kop patou', 'geri waza - techniky kopů', '<p></p>'),
        (245, 'Ushiro mawashi geri', 'Obloukový kop patou s otočkou', 'geri waza - techniky kopů', '<p></p>'),
        (246, 'Gyaku mawashi geri', 'Obloukový kop obrácený ven', 'geri waza - techniky kopů', '<p></p>'),
        (247, 'Nika cuki geri', 'Obloukový kop ploskou chodidla dovnitř', 'geri waza - techniky kopů', '<p></p>'),
        (248, 'Ura nika cuki geri', 'Obloukový kop malíkovou hranou chodidla ven', 'geri waza - techniky kopů', '<p></p>'),
        (249, 'Hiza geri', 'Kop kolenem', 'geri waza - techniky kopů', '<p></p>'),
        (250, 'Mae hiza geri', 'Kop kolenem vpřed', 'geri waza - techniky kopů', '<p></p>'),
        (251, 'Mawashi hiza geri', 'Obloukový kop kolenem', 'geri waza - techniky kopů', '<p></p>'),
        (252, 'Tobi geri', 'Kop ve výskoku', 'geri waza - techniky kopů', '<p></p>'),
        (253, 'Mae tobi geri', 'Kop vpřed ve výskoku', 'geri waza - techniky kopů', '<p></p>'),
        (254, 'Yoko tobi geri', 'Kop stranou ve výskoku', 'geri waza - techniky kopů', '<p></p>'),
        (255, 'Mawashi tobi geri', 'Obloukový kop ve výskoku', 'geri waza - techniky kopů', '<p></p>'),
        (256, 'Ushiro mawashi tobi geri', 'Kop s otočkou ve výskoku', 'geri waza - techniky kopů', '<p></p>'),
        (257, 'Kakato geri', 'Kop patou seshora dolů', 'geri waza - techniky kopů', '<p>Kop patou seshora dolů, tzv. kop kladivo.</p>'),
        (258, 'Kin geri', 'Švihový kop nártem dopředu', 'geri waza - techniky kopů', '<p>Švihový kop nártem dopředu, nejčastěji směřující na genitálie.</p>'),
        (259, 'Fumikomi', 'Dupnutí', 'geri waza - techniky kopů', '<p>Dupnutí, kop dupnutím.</p>'),
        (260, 'Fumikiri', 'Kop seknutím dolů', 'geri waza - techniky kopů', '<p>Kop seknutím dolů, jiný výraz pro gedan yokogeri.</p>'),
        (261, 'Kekomi', 'Přímý kop', 'geri waza - techniky kopů', '<p>Přímý kop, na rozdíl od keage.</p>'),
        (262, 'Kaege', 'Kyvadlový kop', 'geri waza - techniky kopů', '<p>Kyvadlový (švihový) kop, na rozdíl od kekomi.</p>'),
        (263, 'Mae geri kaege', 'Švihový kop vpřed', 'geri waza - techniky kopů', '<p></p>'),
        (264, 'Mae geri kekomi', 'Přímý kop vpřed', 'geri waza - techniky kopů', '<p></p>'),
        (265, 'Yoko geri kaege', 'Švihový kop stranou', 'geri waza - techniky kopů', '<p></p>'),
        (266, 'Yoko geri kekomi', 'Přímý kop stranou', 'geri waza - techniky kopů', '<p></p>'),
        (267, 'Nidan geri', 'Dvojitý kop', 'geri waza - techniky kopů', '<p></p>'),
        (268, 'Nami gaeshi', 'Kop vracející se vlna', 'geri waza - techniky kopů', '<p></p>'),
        (269, 'Jodan cuki', 'Úder na horní pásmo', 'atemi waza - techniky úderů', '<p></p>'),
        (270, 'Chudan cuki', 'Úder na střední pásmo', 'atemi waza - techniky úderů', '<p></p>'),
        (271, 'Gedan cuki', 'Úder na spodní pásmo', 'atemi waza - techniky úderů', '<p></p>'),
        (272, 'Oi cuki', 'Úder přední rukou', 'atemi waza - techniky úderů', '<p>Úder přední rukou, nad nohou která je vepředu (úder stejnostranný).</p>'),
        (273, 'Gyaku cuki ', 'Úder zadní rukou', 'atemi waza - techniky úderů', '<p>Úder zadní rukou, nad nohou která je vzadu (úder různostranný).</p>'),
        (274, 'Mawashi cuki', 'Hák', 'atemi waza - techniky úderů', '<p>Dlouhý hák, obloukový úder.</p>'),
        (275, 'Nagashi cuki', 'Úder současně s úhybem taihiraki', 'atemi waza - techniky úderů', '<p>Úder cuki se současným úhybem taihiraki, zadní noha zakročí a boky a ramena vytočíme do roviny s úderem.</p>'),
        (276, 'Tobikomi cuki', 'Úder přední rukou s výpadem', 'atemi waza - techniky úderů', '<p>Úder přední rukou s výpadem, skočení do úderu.</p>'),
        (277, 'Gyaku tobikomi cuki', 'Úder zadní rukou s výpadem ', 'atemi waza - techniky úderů', '<p>Ůder zadní rukou s výpadem, skočení do úderu.</p>'),
        (278, 'Kizami cuki', 'Prodloužený úder s vytočením ramen', 'atemi waza - techniky úderů', '<p></p>'),
        (279, 'Kagi cuki', 'Krátký hák', 'atemi waza - techniky úderů', '<p>Hákový úder, krátký hák.</p>'),
        (280, 'Age cuki', 'Zvedák', 'atemi waza - techniky úderů', '<p>Úder zespoda nahoru, zvedák.</p>'),
        (281, 'Choku cuki', 'Přímý úder s rotací ruky o 180 stupnů', 'atemi waza - techniky úderů', '<p></p>'),
        (282, 'Tate cuki', 'Úder s rotací o 90 stupňů', 'atemi waza - techniky úderů', '<p>Úder s rotací o 90 stupňů, pěst ve vertikální poloze.</p>'),
        (283, 'Ura cuki', 'Krátký úder bez rotace', 'atemi waza - techniky úderů', '<p></p>'),
        (284, 'Jon cuki notsukomi', 'Úder oicuki s nahnutím těla dopředu', 'atemi waza - techniky úderů', '<p></p>'),
        (285, 'Gyaku cuki notsukomi', 'Úder gyakucuki s nahnutím těla dopředu', 'atemi waza - techniky úderů', '<p></p>'),
        (286, 'Morote cuki ', 'Úder obouma rukama současně (dvojitý úder)', 'atemi waza - techniky úderů', '<p></p>'),
        (287, 'Yama cuki ', 'Široký úder oběma rukama před sebe', 'atemi waza - techniky úderů', '<p>Dvojitý široký úder oběma rukama ve tvaru písmene U na horní a spodní pásmo najednou.</p>'),
        (288, 'Awase cuki', 'Přímý úder oběma rukama před sebe', 'atemi waza - techniky úderů', '<p>Dvojitý přímý úder oběma rukama ve tvaru písmene U.</p>'),
        (289, 'Hasami cuki', 'Nůžkový úder', 'atemi waza - techniky úderů', '<p>Tzv. nůžkový úder, rukama proti sobě.</p>'),
        (290, 'Heiko cuki', 'Obouruční paralelní přímý úder ', 'atemi waza - techniky úderů', '<p></p>'),
        (291, 'Ren cuki', 'Vícenásobný střídavý úder', 'atemi waza - techniky úderů', '<p>Vícenásobný střídavý úder (střídavě oběma rukama).</p>'),
        (292, 'Dan cuki', 'Opakovaný úder', 'atemi waza - techniky úderů', '<p>Opakovaný úder (tou samou rukou rychle za sebou).</p>'),
        (293, 'Yoko mawashi uchi', 'Obloukový sek strannou', 'atemi waza - techniky úderů', '<p>Obloukový sek stranou, jakýkoliv obecně</p>'),
        (294, 'Tate mawashi uchi', 'Obloukový sek vertikálně', 'atemi waza - techniky úderů', '<p>Obloukový sek vertikálně, obecně jakýkoliv.</p>'),
        (295, 'Shuto uchi', 'Sek malíkovou hranou otevřené ruky', 'atemi waza - techniky úderů', '<p></p>'),
        (296, 'Shuto yokomen uchi', 'Sek směřující horizontálně do strany', 'atemi waza - techniky úderů', '<p>Sek shuto směřující horizontálně do strany, ruka dlaní dolů.</p>'),
        (297, 'Shuto gamen uchi', 'Sek směřující horizontálně dovnitř', 'atemi waza - techniky úderů', '<p>Sek shuto směřující horizontálně dovnitř, ruka dlaní nahoru.</p>'),
        (298, 'Shuto otoshi uchi', 'Sek vertikálně dolů', 'atemi waza - techniky úderů', '<p>Sek shuto vertikálně dolů</p>'),
        (299, 'Uchi shuto mawashi uchi', 'Sek směřující horizontálně do strany', 'atemi waza - techniky úderů', '<p>Sek shuto směřující horizontálně do strany, ruka dlaní dolů. Jiný název pro shuto yokomen uchi.</p>'),
        (300, 'Soto shuto mawashi uchi', 'Sek směřující horizontálně dovnitř', 'atemi waza - techniky úderů', '<p>Sek shuto směřující horizontálně dovnitř, ruka dlaní nahoru. Jiný název pro shuto gamen uchi.</p>'),
        (301, 'Haito uchi', 'Sek palcovou hranou otevřené ruky', 'atemi waza - techniky úderů', '<p></p>'),
        (302, 'Uraken uchi', 'Sek hřbetem zavřené pěsti', 'atemi waza - techniky úderů', '<p></p>'),
        (303, 'Yokouraken uchi', 'Horizontální sek stranou ', 'atemi waza - techniky úderů', '<p>Horizontální sek stranou typu uraken.</p>'),
        (304, 'Tateuraken uchi', 'Vertikální sek ', 'atemi waza - techniky úderů', '<p>Vertikální sek typu uraken.</p>'),
        (305, 'Shomen uraken uchi', 'Sek dopředu', 'atemi waza - techniky úderů', '<p>Sek uraken dopředu, ruka směřuje kolmo k zemi.</p>'),
        (306, 'Furi uchi', 'Sek zvenčí dovnitř', 'atemi waza - techniky úderů', '<p>Sek uraken zvenčí dovnitř, ruka přetočená palcem dolů.</p>'),
        (307, 'Furi uraken uchi', 'Sek zvenčí dovnitř', 'atemi waza - techniky úderů', '<p>Sek uraken zvenčí dovnitř, ruka přetočená palcem dolů.</p>'),
        (308, 'Tetsui uchi', 'Sek malíkovou stranou zavřené pěsti', 'atemi waza - techniky úderů', '<p>Sek malíkovou stranou zavřené pěsti, takzvaný úder pěstí jako kladivem.</p>'),
        (309, 'Kentsui uchi', 'Sek malíkovou stranou zavřené pěsti', 'atemi waza - techniky úderů', '<p>Sek malíkovou stranou zavřené pěsti, takzvaný úder pěstí jako kladivem. Jiný výraz pro tetsui uchi.</p>'),
        (310, 'Yokotetsui uchi', 'Vertikální sek', 'atemi waza - techniky úderů', '<p>Vertikální sek typu tetsui.</p>'),
        (311, 'Tetsui uchi yokomawashi', 'Horizontální sek', 'atemi waza - techniky úderů', '<p>Horizontální sek typu tetsui, jiný výraz pro yokotetsui uchi.</p>'),
        (312, 'Tetsui uchi tatemawashi', 'Vertikální sek', 'atemi waza - techniky úderů', '<p>Vertikální sek typu tetsui, jiný výraz pro tatetetsui uchi.</p>'),
        (313, 'Empi uchi', 'Sek/úder loktem', 'atemi waza - techniky úderů', '<p>Sek loktem, lze říci též úder loktem.</p>'),
        (314, 'Hiji ate', 'Sek/úder loktem', 'atemi waza - techniky úderů', '<p>Sek loktem, lze říci též úder loktem. Jiný výraz pro empi uchi.</p>'),
        (315, 'Mae empi uchi', 'Úder loktem vpřed', 'atemi waza - techniky úderů', '<p></p>'),
        (316, 'Yoko empi uchi', 'Úder loktem stranou', 'atemi waza - techniky úderů', '<p></p>'),
        (317, 'Mawashi empi uchi', 'Obloukový úder loktem', 'atemi waza - techniky úderů', '<p></p>'),
        (318, 'Ushiro empi uchi', 'Úder loktem vzad', 'atemi waza - techniky úderů', '<p></p>'),
        (319, 'Tate empi uchi', 'Úder loktem vzhůru', 'atemi waza - techniky úderů', '<p>Úder loktem vzhůru, jiný výraz pro age empi uchi.</p>'),
        (320, 'Age ampi uchi', 'Úder loktem vzhůru', 'atemi waza - techniky úderů', '<p>Úder loktem vzhůru, jiný výraz pro tate empi uchi.</p>'),
        (321, 'Otoshi empi ichi', 'Úder loktem dolů', 'atemi waza - techniky úderů', '<p></p>'),
        (322, 'Mae hiji ate', 'Úder loktem vpřed', 'atemi waza - techniky úderů', '<p>Úder loktem vpřed, jiný výraz pro mae empi uchi.</p>'),
        (323, 'Yoko hiji ate', 'Úder loktem stranou', 'atemi waza - techniky úderů', '<p>Úder loktem stranou, jiný výraz pro yoko empi uchi.</p>'),
        (324, 'Otoshi hiji ate ', 'Úder loktem dolů', 'atemi waza - techniky úderů', '<p>Úder loktem dolů, jiný výraz pro otoshi empi uchi.</p>'),
        (325, 'Ushiro hiji ate', 'Úder loktem vzad', 'atemi waza - techniky úderů', '<p>Úder loktem vzad, jiný výraz pro ushiro empi uchi.</p>'),
        (326, 'Zenkutsu Dachi', 'Postoj s pokrčenou přední nohou', 'shizei - postoje', '<p>Postoj s pokrčenou přední nohou a nataženou zadní nohou, váha mírně vepředu.</p>'),
        (327, 'Neko ashi dachi', 'Postoj kočky', 'shizei - postoje', '<p>Postoj kočky, přední noha odlehčená, opřená jen o špičku.</p>'),
        (328, 'Neko ashi dachi shomen', 'Postoj kočky se zadní nohou směřující dopředu', 'shizei - postoje', '<p>Postoj kočky se zadní nohou směřující dopředu. Přední noha odlehčená, opřená jen o špičku.</p>'),
        (329, 'Neko ashi dachi hanmi', 'Postoj kočky se zadní nohou vytočenou do strany', 'shizei - postoje', '<p>Postoj kočky se zadní nohou vytočenou do strany. Přední noha odlehčená, opřená jen o špičku.</p>'),
        (330, 'Neko ashi dachi mahanmi', 'Postoj kočky se zadní nohou vytočenou dozadu', 'shizei - postoje', '<p>Postoj kočky se zadní nohou vytočenou dozadu. Přední noha odlehčená, opřená jen o špičku.</p>'),
        (331, 'Kiba dachi', 'Boční postoj', 'shizei - postoje', '<p>Boční postoj, takzvaný postoj jezdce na koni, chodidla rovnoběžně.</p>'),
        (332, 'Naifanchi dachi', 'Postoj jezdce na koni', 'shizei - postoje', '<p>Postoj jezdce na koni, chodidla vytočená dovnitř, jiný výraz pro uchi hachiji dachi.</p>'),
        (333, 'Tate seishan dachi', 'Postoj jezdce na koni s nohy v přímce za sebou', 'tai iku - gymnastika', '<p>Postoj jezdce na koni s nohy v přímce za sebou, chodidla vytočená dovnitř.</p>'),
        (334, 'Yoko seishan dachi', 'Široký postoj', 'shizei - postoje', '<p>Široký postoj, jedna noha mírně ve předu.</p>'),
        (335, 'Kokutsu dachi', 'Postoj s oběma nohama pokrčenýma', 'shizei - postoje', '<p>Postoj s oběma nohama pokrčenýma a váha na zadní noze, obranný postoj.</p>'),
        (336, 'Sanchin dachi', 'Postoj přesýpacích hodin.', 'shizei - postoje', '<p></p>'),
        (337, 'Fudo dachi', 'Zakořeněný postoj', 'shizei - postoje', '<p></p>'),
        (338, 'Hangetsu dachi', 'Postoj půlměsíce', 'shizei - postoje', '<p></p>'),
        (339, 'Musubi dachi', 'Formální postoj při stání', 'shizei - postoje', '<p>Paty u sebe špičky od sebe vytočeny ven.</p>'),
        (340, 'Heisoku dachi', 'Postoj s uzavřenými nohami', 'shizei - postoje', '<p>Paty i špičky u sebe.</p>'),
        (341, 'Heikou dachi', 'Postoj rozkročný rovnoběžný', 'shizei - postoje', '<p>Postoj rozkročný rovnoběžný, chodidla na šířku ramen.</p>'),
        (342, 'Hachiji dachi', 'Postoj rozkročný otevřený', 'shizei - postoje', '<p>Postoj rozkročný otevřený, chodidla na šířku ramen vytočená ven.</p>'),
        (343, 'Soto hachiji dachi', 'Postoj rozkročný otevřený', 'shizei - postoje', '<p>Postoj rozkročný otevřený, chodidla na šířku ramen vytočená ven. Jiný výraz pro hachiji dachi.</p>'),
        (344, 'Uchi hachiji dachi', 'Postoj rozkročný uzavřený', 'shizei - postoje', '<p>Postoj rozkročný zavřený, chodidla vytočená dovnitř, jiný výraz pro naifanchi dachi.</p>'),
        (345, 'Kosa dachi', 'Postoj se zkříženýma nohama', 'shizei - postoje', '<p></p>'),
        (346, 'Sagi ashi dachi', 'Postoj na jedné noze', 'shizei - postoje', '<p></p>'),
        (347, 'Renoji dachi', 'Postoj ve tvaru písmene L', 'shizei - postoje', '<p></p>'),
        (348, 'Teiji dachi', 'Postoj ve tvaru písmene T', 'shizei - postoje', '<p></p>'),
        (349, 'Ashi', 'Noha', 'slovíčko', '<p>Noha, chodidlo, krok</p>'),
        (350, 'Tsugi', 'Další', 'slovíčko', '<p>Další, následující</p>'),
        (351, 'Tsugi ashi', 'Chůze s přísunem nohou', 'shin tai - chůze', '<p>Chůze, při které se jedna noha posune a druhá se za ní přisune.</p>'),
        (352, 'Ayumi ashi', 'Chůze se střídáním nohou', 'shin tai - chůze', '<p>Chůze při, které se nohy střídají. </p>'),
        (353, 'Ayumi', 'Chůze', 'slovíčko', '<p></p>'),
        (354, 'Kin', 'Slabina', 'slovíčko', '<p>Slabina (tříslo)</p>')"""
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insertData(WORD_ID: Int, WORD_japanese: String,WORD_czech: String,WORD_type: String,WORD_content: String) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_ID, WORD_ID)
        cv.put(COL_japanese, WORD_japanese)
        cv.put(COL_czech, WORD_czech)
        cv.put(COL_type, WORD_type)
        cv.put(COL_content, WORD_content)
        db.insert(TABLE_NAME, null, cv)
    }
    fun returnData(searchVal: String = "", searchLanguage: String = "", checkBoxData: String): MutableList<Model> {
        val db = this.writableDatabase
        // to choose search language
        var languageSearch = COL_japanese
        if (searchLanguage == "CZ") {
            languageSearch = COL_czech
        }
        val sql =
            "SELECT * FROM " + TABLE_NAME + " WHERE (" + languageSearch + " LIKE '%" + searchVal + "%' OR  "+ COL_type + " LIKE '%" + searchVal + "%') AND " + COL_type + " IN (" + checkBoxData + ") ORDER BY " + languageSearch + " ASC"
        val cursor = db.rawQuery(sql, null)
        var rv = mutableListOf<Model>()
        // what to show first if czech or japanese
        if (searchLanguage == "JP") {
            while (cursor.moveToNext()) {
                rv.add(Model(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(0),cursor.getString(4)))
            }
        } else {
            while (cursor.moveToNext()) {
                rv.add(Model(cursor.getString(2), cursor.getString(1), cursor.getString(3), cursor.getInt(0),cursor.getString(4)))
            }
        }
        cursor.close()
        return rv
    }
    fun returnSingleData(wordID: String): MutableList<Model> {
        val db = this.writableDatabase
        val sql =
            "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + " = " + wordID + ""
        val cursor = db.rawQuery(sql, null)
        var rv = mutableListOf<Model>()
        while (cursor.moveToNext()) {
            rv.add(Model(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(0),cursor.getString(4)))
        }
        return rv
    }
    fun getSimilarWords(searchVal: String = ""): MutableList<Model> {
        val db = this.writableDatabase
        // edited to do any words or techniques that contain parts of word
        var searchValEdited = searchVal.replace(" ", "%' OR " + COL_japanese + " LIKE '%")
        searchValEdited = COL_japanese + " LIKE '%" + searchValEdited + "%'"
        val sql =
            "SELECT * FROM " + TABLE_NAME + " WHERE (" + searchValEdited + ") AND " + COL_japanese + " != '" + searchVal + "' "
        val cursor = db.rawQuery(sql, null)
        var rv = mutableListOf<Model>()

        while (cursor.moveToNext()) {
            rv.add(Model(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(0),cursor.getString(4)))
        }
        cursor.close()
        return rv
    }
}